/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoodsandServices;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class CommercialGood implements Serializable{
    protected String nombre, codigo;
    
    public CommercialGood(String enombre, String ecodigo){
        nombre = enombre;
        codigo = ecodigo;
    }
    
    public CommercialGood(){};

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
