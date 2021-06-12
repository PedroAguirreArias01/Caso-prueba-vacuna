/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pedro
 */
public class Vacuna implements Serializable{
    
    private Integer id;
    private String nombre;
    private String descripcion;
    private Set<Enfermedad> listEnfermedades = new HashSet<>();

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

    @Override
    public String toString() {
        return "Vacuna{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
