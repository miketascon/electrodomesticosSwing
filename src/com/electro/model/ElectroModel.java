/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.electro.model;

import java.util.Date;

public class ElectroModel {
    private int idProducto;
    private String tipo;
    private String marca;
    private Date fechaVenta;
    private float precio;
    private int estado;

    public ElectroModel() {
    }

    public ElectroModel(int idProducto, String tipo, String marca, Date fechaVenta, float precio, boolean estado) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.marca = marca;
        this.fechaVenta = fechaVenta;
        this.precio = precio;
        
        setEstado(estado);
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fecha) {
        this.fechaVenta = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public boolean getEstado(){
        if (estado == 1){
            return true;
        }else{
            return false;
        }
    }
   
    public int getEstado2(){
        if (getEstado() == true){
            return 1;
        }else{
            return 0;
        }
    }
    
    public void setEstado(boolean estado){
        if (estado){
            this.estado = 1;
        }else{
            this.estado = 0;
        }
        
    }
    
    
    
}
