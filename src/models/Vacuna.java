/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "VACUNAS")
public class Vacuna implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ENFERMEDAD_VACUNAS", 
            joinColumns = @JoinColumn(name = "id_vacuna"), 
            inverseJoinColumns = @JoinColumn(name = "id_enfermedad"))
    private Set<Enfermedad> listEnfermedades = new HashSet<>();
    @OneToMany(mappedBy="vacuna")
    private Set<Dosis> listDosis = new HashSet<>();

    public Vacuna() {
    }

    public Vacuna(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Enfermedad> getListEnfermedades() {
        return listEnfermedades;
    }

    public void setListEnfermedades(Set<Enfermedad> listEnfermedades) {
        this.listEnfermedades = listEnfermedades;
    }

    public Set<Dosis> getListDosis() {
        return listDosis;
    }

    public void setListDosis(Set<Dosis> listDosis) {
        this.listDosis = listDosis;
    }
    
    @Override
    public String toString() {
        return "Vacuna{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
