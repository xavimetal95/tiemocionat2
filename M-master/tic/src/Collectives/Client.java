/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collectives;

/**
 *
 * @author carlos
 */
public class Client extends Persona{
    protected String codigo_cliente;

    public String getCodigo_cliente() {
        return codigo_cliente;
    }
    
    public Client(){};
    
    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    public Client(String enombre, String ecod_postal, String edireccion, String ecodigo, String[] eciudades, String ebank_account, String ecodigo_cliente){
        super(enombre,ecod_postal,edireccion,ecodigo,eciudades,ebank_account);
        codigo_cliente = ecodigo_cliente;
    }
}