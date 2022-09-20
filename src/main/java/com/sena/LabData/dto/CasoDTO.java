package com.sena.LabData.dto;

import com.sena.LabData.entity.Odontologo;
import com.sena.LabData.entity.UsuarioLab;

public class CasoDTO {


    private Integer id;


    private String numeroOrden;


    private String fechaIngreso;


    private String nombrePte;


    private String idPte;


    private Boolean registro;


    private Boolean antagonista;

    private UsuarioLab user;

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
