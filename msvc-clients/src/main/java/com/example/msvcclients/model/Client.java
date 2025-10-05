package com.example.msvcclients.model;

public class Client {
    private Long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasenia;

    public Client(Long id, String dni, String nombres, String apellidos, String usuario, String contrasenia) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Long getId() { return id; }
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getUsuario() { return usuario; }
    public String getContrasenia() { return contrasenia; }
}