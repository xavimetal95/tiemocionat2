/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import Collectives.Employee;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class Operation implements Serializable{
    protected int code;
    protected Date start_date;
    protected Employee emp;
    
    public Operation(int ecode, Date estart_date, Employee eemp){
        code = ecode;
        start_date = estart_date;
        emp = eemp;
    }
    
    public Operation(){};

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
    
    
}
