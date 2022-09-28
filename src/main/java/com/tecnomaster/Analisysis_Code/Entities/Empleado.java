package com.tecnomaster.Analisysis_Code.Entities;


import javax.persistence.*;

@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nombreEmpleado;
    private  String correo;
    private  String role;
    @ManyToOne
    @JoinColumn(name= "empresa_id")
    private Empresa  empresa;

    public Empleado() {
    }

    public Empleado(String nombreEmpleado, String correo, String role, Empresa empresa) {
        this.nombreEmpleado = nombreEmpleado;
        this.correo = correo;
        this.role = role;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
