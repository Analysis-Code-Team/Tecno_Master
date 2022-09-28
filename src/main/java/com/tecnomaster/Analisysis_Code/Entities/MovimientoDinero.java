package com.tecnomaster.Analisysis_Code.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MovimientoDinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id;

    @Column(nullable = false)
    private double monto; //El monto debe ser positivo y el usuario debe selecionar el tipo

    @Column(nullable = false)
    private byte tipo; //El Usuario debe seleccionar el tipo de movimiento

    @Column(nullable = false)
    private String concepto;

    @ManyToOne
    @JoinColumn(name="usuario", referencedColumnName = "id", nullable = false)
    private Empleado usuario;

    @ManyToOne
    @JoinColumn(name="empresa", referencedColumnName = "id", nullable = false)
    private Empresa empresa;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaCracion;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaActualizacion;

    //    Generar fecha actual de forma automatica

    @PrePersist
    public void prePersist(){
        this.fechaCracion = new Date();
    }

    //    Construtor Vacio
    public MovimientoDinero() {
    }

    //    Constructor con parametros
    public MovimientoDinero(double monto, String concepto, Empleado usuario, Empresa empresa,byte tipo) {

        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
        this.empresa = empresa;
        this.fechaActualizacion = fechaCracion;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public byte getTipo() {
        return tipo;
    }

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getFechaCracion() {
        return fechaCracion;
    }

    public void setFechaCracion(Date fechaCracion) {
        this.fechaCracion = fechaCracion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}