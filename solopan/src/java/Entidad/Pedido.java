/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Date;

/**
 *
 * @author Programador KS 2
 */
public class Pedido {
    Integer cantidad;
    Integer tipopan;
    Integer client;
    String fecha_despacho;

    public Pedido() {
    }

    public Pedido(Integer cantidad, Integer tipopan, Integer client, String fecha_despacho) {
        this.cantidad = cantidad;
        this.tipopan = tipopan;
        this.client = client;
        this.fecha_despacho = fecha_despacho;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTipopan() {
        return tipopan;
    }

    public void setTipopan(Integer tipopan) {
        this.tipopan = tipopan;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getFecha_despacho() {
        return fecha_despacho;
    }

    public void setFecha_despacho(String fecha_despacho) {
        this.fecha_despacho = fecha_despacho;
    }
    
    
    
    
}
