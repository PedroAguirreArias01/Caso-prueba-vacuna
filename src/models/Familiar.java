/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Familiar implements Serializable{
    
    private Integer id;
    private Persona personaPadre;
    private Persona personaHijo;

    public Familiar() {
    }

    public Familiar(Integer id, Persona personaPadre, Persona personaHijo) {
        this.id = id;
        this.personaPadre = personaPadre;
        this.personaHijo = personaHijo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersonaPadre() {
        return personaPadre;
    }

    public void setPersonaPadre(Persona personaPadre) {
        this.personaPadre = personaPadre;
    }

    public Persona getPersonaHijo() {
        return personaHijo;
    }

    public void setPersonaHijo(Persona personaHijo) {
        this.personaHijo = personaHijo;
    }

    @Override
    public String toString() {
        return "Familiar{" + "id=" + id + ", personaPadre=" + personaPadre + ", personaHijo=" + personaHijo + '}';
    }
}
