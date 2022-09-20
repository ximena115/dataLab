package com.sena.LabData.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "clinicas")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotBlank
    private String nombre;

    @Column
    @NotBlank
    private String direccion;

    @Column
    @NotBlank
    private String movil;

    @Column
    @NotBlank
    private String fijo;

    @Column
    @NotBlank
    private String auxiliar;

    public Clinica() {
    }

    public Clinica(Integer id, String nombre, String direccion, String movil, String fijo, String auxiliar) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.movil = movil;
        this.fijo = fijo;
        this.auxiliar = auxiliar;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }

    /*public List<Odontologo> getOdontologos() {
        return odontologos;
    }

    public void setOdontologos(List<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }*/
}

