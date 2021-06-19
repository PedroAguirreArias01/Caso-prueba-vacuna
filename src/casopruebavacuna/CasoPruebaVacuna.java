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
import models.dao.EnfermedadDAO;
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
        EnfermedadDAO enfermedadDAO = new EnfermedadDAO();
        
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
        consultarVacunas(vacunaDAO);
        consultarDosis(dosisDAO);
        consultarDosisAplicada(dosisAplicadaDAO);
        consultarEnfermedades(enfermedadDAO);
        actualizarPersona(personaDAO);
        actualizarEnfermedad(enfermedadDAO);
        actualizarVacuna(vacunaDAO);
        
        eliminarDosisAplicada(dosisAplicadaDAO, dosisAplicadaDAO.consultarDosisAplicadaPorID(1));
        eliminarPersona(personaDAO, 1);
        eliminarEnfermedad(enfermedadDAO);
        eliminarVacuna(vacunaDAO);
    }

    public static Enfermedad createEnfermedad() {
        Enfermedad enfermedad = new Enfermedad();
        enfermedad.setNombre("Covid 19 v5");
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

    public static void consultarPersonas(PersonaDAO personaDAO) {
        List<Persona> listPersonas = personaDAO.consultarTodasPersonas();
        System.out.println("LISTA DE PERSONAS");
        listPersonas.forEach(listPersona -> {
            System.out.println(listPersona.toString());
        });
    }

    public static void consultarVacunas(VacunaDAO vacunaDAO) {
        List<Vacuna> listaVacunas = vacunaDAO.consultarTodasVacunas();
        System.out.println("LISTADO DE VACUNAS");
        listaVacunas.forEach(vacuna -> {
            System.out.println(vacuna.toString());
        });
    }

    public static void consultarDosis(DosisDAO dosisDAO) {
        List<Dosis> listDosis = dosisDAO.consultarTodasDosises();
        System.out.println("LISTADO DE DOSIS");
        listDosis.forEach(dosis -> {
            System.out.println(dosis.toString());
        });
    }

    public static void consultarDosisAplicada(DosisAplicadaDAO dosisAplicadaDAO) {
        List<DosisAplicada> listDosisAplicada = dosisAplicadaDAO.consultarTodasDosisAplicadaes();
        System.out.println("LISTADO DE DOSIS APLICADA");
        listDosisAplicada.forEach(dosisAplicada -> {
            System.out.println(dosisAplicada.toString());
        });
    }
    
    public static void consultarEnfermedades(EnfermedadDAO enfermedadDAO){
        List<Enfermedad> listEnfermedad = enfermedadDAO.consultarTodasEnfermedades();
        System.out.println("LISTADO DE ENFERMEDADES");
        listEnfermedad.forEach(enfermedad -> {
            System.out.println(enfermedad.toString());
        });
    }
    
    public static void actualizarPersona(PersonaDAO personaDAO){
        Persona persona = personaDAO.consultarPersonaPorID(2);
        persona.setPrimerNombre("Lorena");
        persona.setPrimerApellido("Lopez");
        personaDAO.actualizarPersona(persona);
        System.out.println("PERSONA ACTUALIZADA");
        System.out.println(personaDAO.consultarPersonaPorID(persona.getId()));
    }
    
    public static void actualizarEnfermedad(EnfermedadDAO enfermedadDAO){
        Enfermedad enfermedad = enfermedadDAO.consultarEnfermedadPorID(2);
        enfermedad.setNombre("Tuberculosis");
        enfermedad.setDescripcion("La tuberculosis (TB) es una infección bacteriana causada por un gérmen llamado Mycobacterium tuberculosi");
        enfermedadDAO.actualizarEnfermedad(enfermedad);
        System.out.println(enfermedadDAO.consultarEnfermedadPorID(2));
    }
    
    public static void actualizarVacuna(VacunaDAO vacunaDAO){
        Vacuna vacuna = vacunaDAO.consultarVacunaPorID(2);
        vacuna.setNombre("BCG");
        vacuna.setDescripcion("Vacuna contra la tuberculosis");
        vacunaDAO.actualizarVacuna(vacuna);
        System.out.println(vacunaDAO.consultarVacunaPorID(2).toString());
    }
    
    public static void eliminarDosisAplicada(DosisAplicadaDAO dosisAplicadaDAO, DosisAplicada dosisAplicada){
        dosisAplicadaDAO.eliminarDosisAplicada(dosisAplicada);
    }
    
    public static void eliminarPersona(PersonaDAO personaDAO, Integer idPersona) {
        Persona persona = personaDAO.consultarPersonaPorID(idPersona);
        System.out.println("Persona a eliminar: ");
        System.out.println(persona.toString());
        personaDAO.eliminarPersona(persona);
        System.out.println("PERSONA ELIMINADA:)");
    }
    
    public static void eliminarEnfermedad(EnfermedadDAO enfermedadDAO){
        enfermedadDAO.eliminarEnfermedad(enfermedadDAO.consultarEnfermedadPorID(1));
    }
    
    public static void eliminarVacuna(VacunaDAO vacunaDAO){
        vacunaDAO.eliminarVacuna(vacunaDAO.consultarVacunaPorID(1));
        System.out.println("Vacuna eliminada");
    }
}
