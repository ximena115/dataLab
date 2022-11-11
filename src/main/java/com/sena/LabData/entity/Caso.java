package com.sena.LabData.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "casos")
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotBlank
    private String numeroOrden;

    @Column
    @NotBlank
    private String fechaIngreso;

    @Column
    @NotBlank
    private String nombrePte;

    @Column
    @NotBlank
    private String idPte;

    @Column
    private Boolean registro;

    @Column
    private Boolean antagonista;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  UsuarioLab user;

    public Caso(Integer id, String numeroOrden,String fechaIngreso, String nombrePte, String idPte,
                Boolean registro, Boolean antagonista, UsuarioLab user) {
        this.id = id;
        this.numeroOrden = numeroOrden;
        this.fechaIngreso = fechaIngreso;
        this.nombrePte = nombrePte;
        this.idPte = idPte;
        this.registro = registro;
        this.antagonista = antagonista;
        this.user = user;
    }

    public Caso() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombrePte() {
        return nombrePte;
    }

    public void setNombrePte(String nombrePte) {
        this.nombrePte = nombrePte;
    }

    public String getIdPte() {
        return idPte;
    }

    public void setIdPte(String idPte) {
        this.idPte = idPte;
    }

    public Boolean getRegistro() {
        return registro;
    }

    public void setRegistro(Boolean registro) {
        this.registro = registro;
    }

    public Boolean getAntagonista() {
        return antagonista;
    }

    public void setAntagonista(Boolean antagonista) {
        this.antagonista = antagonista;
    }

    public UsuarioLab getUser() {
        return user;
    }

    public void setUser(UsuarioLab user) {
        user = user;
    }
}
