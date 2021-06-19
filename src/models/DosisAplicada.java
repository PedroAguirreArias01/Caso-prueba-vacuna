/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "DOSIS_APLICADA")
public class DosisAplicada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FECHA_APLICACION")
    private LocalDate fechaAplicacion;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial")
    private Historial historial;
    
    @ManyToOne
    @JoinColumn(name = "id_dosis")
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
        return "DosisAplicada{" + "id=" + id + ", fechaAplicacion=" + fechaAplicacion + '}';
    }
}
