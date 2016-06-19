/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IODades.DB;

import IODades.DB.Interfaces.jdbc;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author TicEmocionat
 */
public class IOjdbc implements IODades.DataSource {
    
    protected jdbc base_datos;
    protected Connection connect = null;
    
    ArrayList<String> out = new ArrayList<>();
    
    public IOjdbc(jdbc linea_base){
        base_datos = linea_base;   
    }
    
    public IOjdbc(){};
    
    @Override
    public int open (String source, int mode){
        int error = 0;
        
        try {
            base_datos.open(source);
        } catch (SQLException ex) {
            error = 1;
            System.out.println("Error en open");
        }
        
        return error;
    }
    
    @Override
    public int close (String source){
        int error = -1;
        
        
        return error;
    }
    
    @Override
    public int importdades(ArrayList dades, String source){
        int error = 0;
        
        try {
            out.clear();
            out = base_datos.importdades(source);
        } catch (SQLException ex) {
            error = 1;
            System.out.println("Error en import con open");
        }
        
        return error;
    }
    
    @Override
    public int exportdades(ArrayList dades, String source, int mode){
        int error = 0;
        
        return error;
    }
    
    public ArrayList<String> getline(){
        return out;
    }
    
    
    
}
