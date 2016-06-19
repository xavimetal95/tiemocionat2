/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IODades.DB.Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author carlos
 */
public class jdbc {
    protected ArrayList<String> cads = new ArrayList<>();
    
    protected Connection connect = null; //objecte de connexió
    
    Statement statement = null;
    ResultSet resultSet = null;// (ResultSetRow)
    ResultSetMetaData res = null;

    public int open(String data) throws SQLException{
        String[] datos;
        
        datos = data.split(";");
        connect = DriverManager.getConnection ("jdbc:"+datos[0]+"://"+datos[1]+"/"+datos[2]+"?" + "user="+datos[3]+"&password="+datos[4]);
        
        return 0;
    }
    
    public int close(String data){
        
        
        return 0;
    }
    
    public ArrayList<String> importdades(String data) throws SQLException{
          
            statement =  connect.createStatement();

            resultSet =  statement.executeQuery(data);
            res = resultSet.getMetaData();
            int columns = res.getColumnCount();
            
            String arrayline = "";
            
                while(resultSet.next()){
                    for(int i = 0; i < columns; i++){
                        arrayline += resultSet.getString(i+1);
                        if(i < columns - 1){
                            arrayline += ";";
                        }
                    }
                    cads.add(arrayline);
                    arrayline = "";
                }
            
            resultSet.close();
            
        return cads;
    }
    
}
