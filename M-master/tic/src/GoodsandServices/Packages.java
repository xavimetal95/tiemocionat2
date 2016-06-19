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
public class Packages extends CommercialGood implements Serializable{
    
    protected Float precio;
    protected int numero;
    
    public Packages(String enombre, String ecodigo, Float eprecio, int enumero){
        super(enombre,ecodigo);
        precio = eprecio;
        numero = enumero;
    }
    
    public Packages(){};

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
