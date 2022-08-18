package com.sena.LabData.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tipoTrabajos")
public class TipoTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotBlank
    private String nombre;

    @Column
    @NotBlank
    private String area;

   /* @OneToMany
    @JoinColumn(name = "id_caso")
    private List<Caso> casos;*/

    public TipoTrabajo() {
    }

    public TipoTrabajo(Integer id, String nombre, String area) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
