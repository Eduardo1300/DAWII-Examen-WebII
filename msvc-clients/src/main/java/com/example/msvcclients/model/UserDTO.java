package com.example.msvcclients.model;

import java.util.Date;

public class UserDTO {
    private Long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private Date nacimiento;
    private int port;

    public Long getId() { return id; }
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public Date getNacimiento() { return nacimiento; }
    public int getPort() { return port; }

    public void setId(Long id) { this.id = id; }
    public void setDni(String dni) { this.dni = dni; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setNacimiento(Date nacimiento) { this.nacimiento = nacimiento; }
    public void setPort(int port) { this.port = port; }
}