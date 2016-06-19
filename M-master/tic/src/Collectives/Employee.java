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
public class Employee extends Persona{
    protected String codigo_empleado;
    
    public Employee (String enombre, String ecod_postal, String edireccion, String ecodigo, String[] eciudades, String ebank_account, String ecodigo_empleado){
        super(enombre,ecod_postal,edireccion,ecodigo,eciudades,ebank_account);
        codigo_empleado = ecodigo_empleado;
    }
    
    public Employee(){};

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }
    
    
}
