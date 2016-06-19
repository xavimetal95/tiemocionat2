/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collectives;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class Persona implements Serializable{
    protected String nombre, cod_postal, direccion, codigo, bank_account;
    protected String[] ciudades;
    
    public Persona(String enombre, String ecod_postal, String edireccion, String ecodigo, String[] eciudades, String ebank_account){
        nombre = enombre;
        cod_postal = ecod_postal;
        direccion = edireccion;
        codigo = ecodigo;
        ciudades = eciudades;
        bank_account = ebank_account;
    }
    
    public Persona(){};

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getBank() {
        return bank_account;
    }

    public void setBank(String ebank_account) {
        this.bank_account = bank_account;
    }

    public String[] getCiudades() {
        return ciudades;
    }

    public void setCiudades(String[] ciudades) {
        this.ciudades = ciudades;
    }
    
    
}
