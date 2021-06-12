/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopruebavacuna;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import models.Dosis;
import models.DosisAplicada;
import models.Enfermedad;
import models.Historial;
import models.Persona;
import models.Vacuna;
import models.dao.DosisAplicadaDAO;
import models.dao.DosisDAO;
import models.dao.PersonaDAO;
import models.dao.VacunaDAO;

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
        VacunaDAO vacunaDAO = new VacunaDAO();
        DosisDAO dosisDAO = new DosisDAO();
        DosisAplicadaDAO dosisAplicadaDAO = new DosisAplicadaDAO();
        
        Persona persona = createPerson();
        Historial historial = new Historial();
        historial.setFechaCreacion(LocalDate.now());
        persona.setHistorial(historial);
        historial.setPersona(persona);
        personaDAO.crearPersona(persona);
        
        Vacuna vacuna = createVacuna();
        Enfermedad enfermedad = createEnfermedad();
        vacuna.getListEnfermedades().add(enfermedad);
        vacunaDAO.crearVacuna(vacuna);

        Dosis dosis = crearDosis(vacuna);
        dosisDAO.crearDosis(dosis);

        DosisAplicada dosisAplicada = crearDosisAplicada(dosis, historial);
        dosisAplicadaDAO.crearDosisAplicada(dosisAplicada);
        
        consultarPersonas(personaDAO);
    }

    public static Enfermedad createEnfermedad() {
        Enfermedad enfermedad = new Enfermedad();
        enfermedad.setNombre("Covid 19 v2");
        enfermedad.setDescripcion("Enfermedad que afecta los pulmones");
        return enfermedad;
    }

    public static Persona createPerson() {
        Persona persona = new Persona();
        persona.setPrimerApellido("Parra");
        persona.setSegundoApellido("Moreno");
        persona.setDocumento("1007142723");
        persona.setFechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 12));
        persona.setPrimerNombre("Rosa");
        persona.setTipoDocumento("C");
        
        return persona;
    }

    public static Vacuna createVacuna() {
        Vacuna vacuna = new Vacuna();
        vacuna.setNombre("Pfizer1");
        vacuna.setDescripcion("Vacuna que protege frente al covid 19 ");
        return vacuna;
    }

    public static Dosis crearDosis(Vacuna vacuna) {
        Dosis dosis = new Dosis();
        dosis.setUnidadTiempo("H");
        dosis.setValorTiempo(1);
        dosis.setVacuna(vacuna);
        return dosis;
    }

    public static DosisAplicada crearDosisAplicada(Dosis dosis, Historial historial) {
        DosisAplicada dosisAplicada = new DosisAplicada();
        dosisAplicada.setDosis(dosis);
        dosisAplicada.setHistorial(historial);
        dosisAplicada.setFechaAplicacion(LocalDate.now());
        return dosisAplicada;
    }
    
    public static void consultarPersonas(PersonaDAO personaDAO){
        List<Persona> listPersonas = personaDAO.consultarTodasPersonas();
        for (Persona listPersona : listPersonas) {
            System.out.println(listPersona.toString());
        }
    }
    
}
