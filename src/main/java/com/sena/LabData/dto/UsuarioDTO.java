package com.sena.LabData.dto;

import com.sena.LabData.entity.Caso;

import java.util.List;


public class UsuarioDTO {


    private Integer id;


    private String nombre;


    private String apellido;


    private String direccion;


    private String movil;


    private String password;


    private String correo;


    private String tipoUsuario;


    private String username;

    private List<Caso> listaCasos;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = this.username;
    }

    public void addCaso(Caso caso) {
        listaCasos.add(caso);
    }

    public List<Caso> getListaCasos() {
        return listaCasos;
    }

    public void setListaCasos(List<Caso> listaCasos) {
        this.listaCasos = listaCasos;
    }
}
