/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "FAMILIARES")
public class Familiar implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_persona_padre")
    @JoinColumn(name = "id_persona_padre")
    private Persona personaPadre;
    @Column(name = "id_persona_hijo")
    @JoinColumn(name = "id_persona_hijo")
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
