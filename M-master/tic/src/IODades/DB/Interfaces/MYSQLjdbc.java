/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IODades.DB.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class MYSQLjdbc extends jdbc {
    
    ArrayList<String> cad = new ArrayList<>();
    
    public ArrayList<String> importdades(String data) throws SQLException{//SELECT
        
        String[] datos;
        String[] datos_where;
        String[] campo_where;
        String query = null;
        
        datos = data.split(";");
        
        if(datos.length == 3){//Tiene WHERE?
            datos_where = datos[2].split("@@@");
            
            query = datos[1] + " FROM " + datos[0] + " WHERE ";
            
            for(int i = 0; i < datos_where.length; i++){
                campo_where = datos_where[i].split("@@");
                query += " " + campo_where[0] + " " + campo_where[1] + " '" +campo_where[2] + "' ";
            }
            
            query += ";";
            
        }else if(datos.length < 3){
            query = datos[1] + " FROM " + datos[0] +";";
        }
        
        if(query != null){
          return super.importdades(query);
        }
        
        return cad;
    }
    
}