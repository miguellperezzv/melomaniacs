/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author luisy
 */


public class Producto {
    int k_producto;
    String k_estado;
    String k_formato;
    int k_artista;
    int k_lanzamiento;
    String d_descripcion;
    int precio;

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Producto() {
    }

    public int getK_producto() {
        return k_producto;
    }

    public void setK_producto(int k_producto) {
        this.k_producto = k_producto;
    }

    public String getK_estado() {
        return k_estado;
    }

    public void setK_estado(String k_estado) {
        this.k_estado = k_estado;
    }

    public String getK_formato() {
        return k_formato;
    }

    public void setK_formato(String k_formato) {
        this.k_formato = k_formato;
    }

    public int getK_artista() {
        return k_artista;
    }

    public void setK_artista(int k_artista) {
        this.k_artista = k_artista;
    }

    public int getK_lanzamiento() {
        return k_lanzamiento;
    }

    public void setK_lanzamiento(int k_lanzamiento) {
        this.k_lanzamiento = k_lanzamiento;
    }

    public String getD_descripcion() {
        return d_descripcion;
    }

    public void setD_descripcion(String d_descripcion) {
        this.d_descripcion = d_descripcion;
    }

    
   

    

    
    
}
