/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopruebavacuna;

import java.time.LocalDate;
import java.time.Month;
import models.Dosis;
import models.Enfermedad;
import models.Persona;
import models.Vacuna;
import models.dao.PersonaDAO;

/**
 *
 * @author Pedro
 */
public class CasoPruebaVacuna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.crearPersona(createPerson());
    }
    
    public static Enfermedad createEnfermedad(){
        Enfermedad enfermedad = new Enfermedad();
        enfermedad.setNombre("Covid 19");
        enfermedad.setDescripcion("Enfermedad que afecta los pulmones");
        return enfermedad;
    }
    
    public static Persona createPerson(){
        Persona persona = new Persona();
        persona.setPrimerApellido("Parra");
        persona.setSegundoApellido("Moreno");
        persona.setDocumento("1007142723");
        persona.setFechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 12));
        persona.setPrimerNombre("Blanca");
        persona.setTipoDocumento("C");
        return persona;
    }
    
  public static Vacuna createVacuna(){
      Vacuna vacuna = new Vacuna();
      vacuna.setNombre("Pfizer");
      vacuna.setDescripcion("Vacuna que protege frente al covid 19 ");
      return vacuna;
  }
  
  public Dosis crearDosis(){
      Dosis dosis = new Dosis();
      dosis.setUnidadTiempo("H");
      dosis.setValorTiempo(1);
      return dosis;
  }
}
