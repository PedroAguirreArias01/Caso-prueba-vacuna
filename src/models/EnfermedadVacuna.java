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
public class EnfermedadVacuna implements Serializable{
    
    private Enfermedad enfermedad;
    private Vacuna vacuna;

    public EnfermedadVacuna() {
    }
    
    public EnfermedadVacuna(Enfermedad enfermedad, Vacuna vacuna) {
        this.enfermedad = enfermedad;
        this.vacuna = vacuna;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    @Override
    public String toString() {
        return "EnfermedadVacuna{" + "enfermedad=" + enfermedad + ", vacuna=" + vacuna + '}';
    }
}
