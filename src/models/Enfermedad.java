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
public class Enfermedad implements Serializable{
    
    private Integer id;
    private String nombre;
    private String descripcion;
    private Set<Vacuna> listaVacuna = new HashSet<>();

    public Enfermedad() {
    }

    public Enfermedad(Integer id, String nombre, String descripcion) {
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

    public Set<Vacuna> getListaVacuna() {
        return listaVacuna;
    }

    public void setListaVacuna(Set<Vacuna> listaVacuna) {
        this.listaVacuna = listaVacuna;
    }
    
    @Override
    public String toString() {
        return "Enfermedad{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
