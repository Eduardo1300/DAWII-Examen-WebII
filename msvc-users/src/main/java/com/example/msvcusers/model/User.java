package com.example.msvcusers.model;

import java.util.Date;

public class User {
    private Long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private Date nacimiento;
    private int port;

    public User(Long id, String dni, String nombres, String apellidos, Date nacimiento, int port) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.port = port;
    }

    public Long getId() { return id; }
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public Date getNacimiento() { return nacimiento; }
    public int getPort() { return port; }
}