package com.sena.LabData.entity;


import javax.persistence.*;


@Entity
@Table(name = "usuarios")
public class UsuarioLab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    @Column

    private String apellido;

    @Column

    private String direccion;

    @Column
    private String movil;

    @Column
    private String contrasena;

    @Column
    private String correo;

    @Column
    private String tipoUsuario;

    @Column
    private String usuario;


    public UsuarioLab(Integer id, String nombre, String apellido, String direccion, String movil, String contraseña, String correo, String tipoUsuario, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.movil = movil;
        this.contrasena = contraseña;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
    }

    public UsuarioLab() {
    }

    public UsuarioLab(String nombre, String apellido, String direccion, String movil, String contrasena, String correo, String tipoUsuario, String usuario) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}