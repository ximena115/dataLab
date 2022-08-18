package com.sena.LabData.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotBlank
    private String nombre;

    @Column
    @NotBlank
    private String apellido;

    @Column
    @NotBlank
    private String movil;

    @Column
    @NotBlank
    private String fijo;

    @Column
    @NotBlank
    private String especialidad;


    /*@OneToMany
    @JoinColumn(name = "id_caso")
    private List<Caso> casos;*/

    public Odontologo() {
    }

    public Odontologo(Integer id, String nombre, String apellido, String movil, String fijo, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.movil = movil;
        this.fijo = fijo;
        this.especialidad = especialidad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
