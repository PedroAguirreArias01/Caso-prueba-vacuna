/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pedro
 */
public class Historial implements Serializable {

    private Integer idPersona;
    private LocalDate fechaCreacion;
    private Persona persona;
    private Set<DosisAplicada> listaDosisAplicada = new HashSet<>();

    public Historial() {
    }

    public Historial(Integer idPersona, LocalDate fechaCreacion, Persona persona) {
        this.idPersona = idPersona;
        this.fechaCreacion = fechaCreacion;
        this.persona = persona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<DosisAplicada> getListaDosisAplicada() {
        return listaDosisAplicada;
    }

    public void setListaDosisAplicada(Set<DosisAplicada> listaDosisAplicada) {
        this.listaDosisAplicada = listaDosisAplicada;
    }

    @Override
    public String toString() {
        return "Historial{" + "idPersona=" + idPersona + ", fechaCreacion=" + fechaCreacion + ", persona=" + persona + ", listaDosisAplicada=" + listaDosisAplicada + '}';
    }
}
