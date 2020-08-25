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
public class Contacto {
    
    String k_tipocontacto;
    String k_usuario;
    int k_contacto;
    String v_contacto;

   public Contacto(){
        
    }
    public String getK_tipocontacto() {
        return k_tipocontacto;
    }

    public void setK_tipocontacto(String k_tipocontacto) {
        this.k_tipocontacto = k_tipocontacto;
    }

    public String getK_usuario() {
        return k_usuario;
    }

    public void setK_usuario(String k_usuario) {
        this.k_usuario = k_usuario;
    }

    public int getK_contacto() {
        return k_contacto;
    }

    public void setK_contacto(int k_contacto) {
        this.k_contacto = k_contacto;
    }

    public String getV_contacto() {
        return v_contacto;
    }

    public void setV_contacto(String v_contacto) {
        this.v_contacto = v_contacto;
    }
    
    
    
}
