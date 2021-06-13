/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Pedro
 */
public class DosisAplicada implements Serializable {

    private Integer id;
    private LocalDate fechaAplicacion;
    private Historial historial;
    private Dosis dosis;

    public DosisAplicada() {
    }

    public DosisAplicada(Integer id, LocalDate fechaAplicacion, Historial historial, Dosis dosis) {
        this.id = id;
        this.fechaAplicacion = fechaAplicacion;
        this.historial = historial;
        this.dosis = dosis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public Dosis getDosis() {
        return dosis;
    }

    public void setDosis(Dosis dosis) {
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return "DosisAplicada{" + "id=" + id + ", fechaAplicacion=" + fechaAplicacion +'}';
    }
}
