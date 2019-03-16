package com.example.leonelquiroga.unnobatrabajofinal.adapter;

public class Paciente {

    private String descripcion;
    private String detalle;
    private float distancia;
    private String domicilio;
    private float latitud;
    private float longitud;
    private String telefono;
    private String tipo;
    private float valor;

    public Paciente() {
    }

    public Paciente(String descripcion, String detalle, float distancia, String domicilio, float latitud, float longitud, String telefono, String tipo, float valor) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.distancia = distancia;
        this.domicilio = domicilio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.telefono = telefono;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
