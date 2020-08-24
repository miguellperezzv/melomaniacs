/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;
import java.sql.Date;


/**
 *
 * @author luisy
 */
public class Lanzamiento {
    int k_artista;
    int k_lanzamiento;
    String k_genero;
    Date f_lanzamiento;
    String n_lanzamiento;
    String i_lanzamiento;
    String s_lanzamiento;
    String k_artista_nombre;
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public Lanzamiento() {
    }

    public String getS_lanzamiento() {
        return s_lanzamiento;
    }

    public void setS_lanzamiento(String s_lanzamiento) {
        this.s_lanzamiento = s_lanzamiento;
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

    public String getK_genero() {
        return k_genero;
    }

    public void setK_genero(String k_genero) {
        this.k_genero = k_genero;
    }

    public Date getF_lanzamiento() {
        return f_lanzamiento;
    }

    public void setF_lanzamiento(Date f_lanzamiento) {
        this.f_lanzamiento = f_lanzamiento;
    }

    public String getN_lanzamiento() {
        return n_lanzamiento;
    }

    public void setN_lanzamiento(String n_lanzamiento) {
        this.n_lanzamiento = n_lanzamiento;
    }

    public String getI_lanzamiento() {
        return i_lanzamiento;
    }

    public void setI_lanzamiento(String i_lanzamiento) {
        this.i_lanzamiento = i_lanzamiento;
    }

    public String getK_artista_nombre() {
        return k_artista_nombre;
    }

    public void setK_artista_nombre(String k_artista_nombre) {
        this.k_artista_nombre = k_artista_nombre;
    }
    
    
    
}
