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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "HISTORIAL")
public class Historial implements Serializable {
    
    @Id
    @GeneratedValue(generator = "persona")
    @org.hibernate.annotations.GenericGenerator(
            name = "persona",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "persona")
    )
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    
    @OneToOne()
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    private Persona persona;
    
    @OneToMany(mappedBy = "historial")
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
