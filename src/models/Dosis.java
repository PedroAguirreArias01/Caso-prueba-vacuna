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
public class Dosis implements Serializable{
    
    private Integer id;
    private Integer valorTiempo;
    private String unidadTiempo;
    private Vacuna vacuna;

    public Dosis() {
    }

    public Dosis(Integer id, Integer valorTiempo, String unidadTiempo, Vacuna vacuna) {
        this.id = id;
        this.valorTiempo = valorTiempo;
        this.unidadTiempo = unidadTiempo;
        this.vacuna = vacuna;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValorTiempo() {
        return valorTiempo;
    }

    public void setValorTiempo(Integer valorTiempo) {
        this.valorTiempo = valorTiempo;
    }

    public String getUnidadTiempo() {
        return unidadTiempo;
    }

    public void setUnidadTiempo(String unidadTiempo) {
        this.unidadTiempo = unidadTiempo;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    @Override
    public String toString() {
        return "Dosis{" + "id=" + id + ", valorTiempo=" + valorTiempo + ", unidadTiempo=" + unidadTiempo + ", vacuna=" + vacuna + '}';
    }
}
