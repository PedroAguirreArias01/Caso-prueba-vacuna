/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopruebavacuna;

import java.time.LocalDate;
import java.time.Month;
import models.Enfermedad;
import models.Historial;
import models.Persona;
import models.Vacuna;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
public class CasoPruebaVacuna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Historial historial = new Historial();
        historial.setFechaCreacion(LocalDate.now());
        Persona persona = createPerson();
        persona.setHistorial(historial);
        historial.setPersona(persona);
        Vacuna vacuna = createVacuna();
        Enfermedad enfermedad = createEnfermedad();
        vacuna.getListEnfermedades().add(enfermedad);
        try{
            session.beginTransaction();
            session.save(persona);
            session.save(historial);
            session.save(vacuna);
            session.save(enfermedad);            
            session.getTransaction().commit();
        } catch(HibernateException e){
            session.getTransaction().rollback();
            System.out.println("Error: "+e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public static Enfermedad createEnfermedad(){
        Enfermedad enfermedad = new Enfermedad();
        enfermedad.setNombre("Covid 19");
        enfermedad.setDescripcion("Enfermedad que afecta los pulmones");
        return enfermedad;
    }
    
    public static Persona createPerson(){
        Persona persona = new Persona();
        persona.setPrimerApellido("Aguirre");
        persona.setSegundoApellido("Arias");
        persona.setDocumento("1007142723");
        persona.setFechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 12));
        persona.setPrimerNombre("Pedro");
        persona.setTipoDocumento("C");
        return persona;
    }
    
  public static Vacuna createVacuna(){
      Vacuna vacuna = new Vacuna();
      vacuna.setNombre("Pfizer");
      vacuna.setDescripcion("Vacuna que protege frente al covid 19 ");
      return vacuna;
  }
}
