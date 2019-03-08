package JPA;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPA {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    public int contadorAlumno = 0, contadorAsignatura = 0, contadorAA = 0;
    
    public void persisteAlumno(int idAlumno, String apellidos, String nombre, int curso, int titulacion){
        Alumno alumno;
        alumno = new Alumno (idAlumno, apellidos, nombre, curso, titulacion);
        tx.begin();
        try{
            em.persist(alumno);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }
    }
    
    public void persisteAsignatura(int idAsignatura, String nombreAsignatura, String tipoAsignatura, float creditos){
        Asignatura asignatura;
        asignatura = new Asignatura(idAsignatura, tipoAsignatura, nombreAsignatura, creditos);
        
        tx.begin();
        try{
            em.persist(asignatura);
            
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }      
        
    }
    
    public void persisteAlumnoAsignatura(int idAlumno, int idAsignatura, Character cursada){
        AlumnoAsignatura alumAsig;
        
        alumAsig = new AlumnoAsignatura(idAlumno, idAsignatura);
        alumAsig.setCursada(cursada);
        
        tx.begin();
        try{
            em.persist(alumAsig);
            
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }
        
    }
    
    public String [][] registrosAlumnos(){
        
        String consultaAlumnos = "SELECT * FROM Alumnos";
        String [][] registros;
        int numRegistros, contador = 0;
        
        // Obtener numero de registros a travez de un count
        String consultaC = "SELECT COUNT(a) FROM Alumno a";
        Query consulta22 = em.createQuery(consultaC);
        Object n = consulta22.getSingleResult();
        numRegistros = Integer.parseInt(n.toString());
        
        registros = new String [numRegistros][5];
        
        Query consulta = em.createNativeQuery(consultaAlumnos);
        
        List<Object []> listaUsuarios = consulta.getResultList();
        for(Object [] usr : listaUsuarios){
            
            registros [contador][0] = usr[0].toString();
            registros [contador][1] = usr[1].toString();
            registros [contador][2] = usr[3].toString();
            registros [contador][3] = usr[2].toString();
            registros [contador][4] = usr[4].toString();
            
            contador++;          
            
        }   
        contador = 0;
        return registros;
    }
    
    public String [][] registrosAsignaturas(){
        
        String consultaAlumnos = "SELECT * FROM Asignaturas";
        String [][] registros;
        int numRegistros, contador = 0;
        
        // Obtener numero de registros a travez de un count
        String consultaC = "SELECT COUNT(a) FROM Asignatura a";
        Query consulta22 = em.createQuery(consultaC);
        Object n = consulta22.getSingleResult();
        numRegistros = Integer.parseInt(n.toString());
        
        registros = new String [numRegistros][4];
        
        Query consulta = em.createNativeQuery(consultaAlumnos);
        
        List<Object []> listaAsignaturas = consulta.getResultList();
        for(Object [] usr : listaAsignaturas){
            
            registros [contador][0] = usr[0].toString();
            registros [contador][1] = usr[2].toString();
            registros [contador][2] = usr[3].toString();
            registros [contador][3] = usr[1].toString();
            
            contador++;          
            
        }  
        contador = 0;
        return registros;
    }
    
    public String [][] registrosAA(){
        String consultaAlumnos = "SELECT * FROM Alumnoasignatura";
        String [][] registros;
        int numRegistros, contador = 0;
        
        // Obtener numero de registros a travez de un count
        String consultaC = "SELECT COUNT(a) FROM AlumnoAsignatura a";
        Query consulta22 = em.createQuery(consultaC);
        Object n = consulta22.getSingleResult();
        numRegistros = Integer.parseInt(n.toString());
        
        registros = new String [numRegistros][3];
        
        Query consulta = em.createNativeQuery(consultaAlumnos);
        
        List<Object []> listaAsignaturas = consulta.getResultList();
        for(Object [] usr : listaAsignaturas){
            
            registros [contador][0] = usr[1].toString();
            registros [contador][1] = usr[2].toString();
            registros [contador][2] = usr[0].toString();
            
            contador++;          
            
        }  
        contador = 0;
                
        return registros;
    }
    
    public void eliminaAlumno (int idUsuario){
        
        tx.begin();
        
        try{
            Alumno usuario = em.find(Alumno.class, idUsuario);
            if(usuario != null){
                em.remove(usuario);
            }
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        
        
    }
    
    public void eliminaAsignatura (int idAsignatura){
        
        tx.begin();
        
        try{
            Asignatura asignatura = em.find(Asignatura.class, idAsignatura);
            if(asignatura != null){
                em.remove(asignatura);
            }
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        
        
    }
    
    public String [] muestraSiguienteAlumno(){
        String [] registro = new String [5];
        String [][] datos = registrosAlumnos();
        
        contadorAlumno++;
        
        if(contadorAlumno >= datos.length)
            contadorAlumno = datos.length - 1 ;
      
        for (int i = 0; i < datos[0].length; i++) {
            registro[i] = datos[contadorAlumno][i];
        }        
        return registro;
        
    }
    
    public String [] muestraSiguienteAsignatura(){
        String [] registro = new String [4];
        String [][] datos = registrosAsignaturas();
        
        contadorAsignatura++;
        
        if(contadorAsignatura >= datos.length)
            contadorAsignatura = datos.length - 1;
        
        for (int i = 0; i < datos[0].length; i++) {
            registro[i] = datos[contadorAsignatura][i];
        }
        
        return registro;
        
    }
    
    public String [] muestraSiguienteAA(){
        String [] registro = new String [34];
        String [][] datos = registrosAA();
        
        contadorAA++;
        
        if(contadorAA >= datos.length)
            contadorAA = datos.length - 1;
        
        for (int i = 0; i < datos[0].length; i++) {
            registro[i] = datos[contadorAA][i];
        }
        
        return registro;
    }
    
    public String [] muestraAnteriorAlumno(){
        String [] registro = new String [5];
        String [][] datos = registrosAlumnos();
        
        contadorAlumno--;
        
        if(contadorAlumno < 1){
            contadorAlumno = 0;
        }
        
        for (int i = 0; i < datos[0].length; i++) {
            registro[i] = datos[contadorAlumno][i];
        }
        
        return registro;
    }
    
    public String [] muestraAnteriorAsignatura(){
        String [] registro = new String [4];
        String [][] datos = registrosAsignaturas();
        
        contadorAsignatura--;
        
        if(contadorAsignatura < 1){
            contadorAsignatura = 0;
        }
        
        for (int i = 0; i < datos[0].length; i++) {
            registro[i] = datos[contadorAsignatura][i];
        }
        
        return registro;
    }
    
    public String [] muestraAnteriorAA(){
        String [] registro = new String [3];
        String [][] datos = registrosAA();
        
        contadorAA--;
        
        if(contadorAA < 1){
            contadorAA = 0;
        }
        
        for (int i = 0; i < datos[0].length; i++) {
            registro[i] = datos[contadorAA][i];
        }
        
        return registro;
    }
    
    public void actualizaAlumno(int idAlumno, String apellidos, String nombre, int curso, int titulacion){
        Alumno alumno;
        
        tx.begin();
        
        alumno = em.find(Alumno.class, idAlumno);
        alumno.setApellidos(apellidos);
        alumno.setNombre(nombre);
        alumno.setCurso(curso);
        alumno.setTitulacion(titulacion);
        
        tx.commit();       
    }
    
    public void actualizaAsignatura(Integer id_asignatura, String tipo, String nombre, float creditos){
        Asignatura asignatura;
        
        tx.begin();
        
        asignatura = em.find(Asignatura.class, id_asignatura);
        asignatura.setTipo(tipo);
        asignatura.setNombre(nombre);
        asignatura.setCreditos(creditos);
        
        tx.commit();
    }
    
    public void actualizaAA(int idAlumno, int idAsignatura, Character cursada){
        String alumnoAsignaturaUpdate = "UPDATE alumnoasignatura SET " + "cursada = '" + cursada + "' WHERE id_alumno = " + idAlumno + " AND id_asignatura = " + idAsignatura;
        
        Query consulta = em.createNativeQuery(alumnoAsignaturaUpdate);
        
        tx.begin();
            consulta.executeUpdate();
        tx.commit();
        
    }
    
    public String [] alumno(int idAlumno){
        String alumno = "SELECT id_alumno, apellidos, nombre, curso, titulacion FROM Alumnos where id_alumno = " + idAlumno;
        String [] datosAlumno = new String[5];
        Query consulta = em.createNativeQuery(alumno);
        
        List<Object []> alumnoDatos = consulta.getResultList();
        
        for(Object [] alum : alumnoDatos){
            datosAlumno[0] = alum[0].toString();
            datosAlumno[1] = alum[1].toString();
            datosAlumno[2] = alum[2].toString();
            datosAlumno[3] = alum[3].toString();
            datosAlumno[4] = alum[4].toString();
        }
        
        return datosAlumno;
        
    }
    
    public String [] asignatura(int idAsignatura){
        
        String alumno = "SELECT id_asignatura, nombre, tipo, creditos FROM Asignaturas where id_asignatura = " + idAsignatura;
        String [] datosAsignatura = new String[4];
        Query consulta = em.createNativeQuery(alumno);
        
        List<Object []> asignaturaDatos = consulta.getResultList();
        
        for(Object [] alum : asignaturaDatos){
            datosAsignatura[0] = alum[0].toString();
            datosAsignatura[1] = alum[1].toString();
            datosAsignatura[2] = alum[2].toString();
            datosAsignatura[3] = alum[3].toString();
        }
        
        return datosAsignatura;
        
    }
            
}
