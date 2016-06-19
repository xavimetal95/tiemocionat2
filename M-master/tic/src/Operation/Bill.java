/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import Collectives.Employee;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class Bill extends Operation{
    protected float discount, taxes, totalamount;
    protected String methodpayment, conditionpayment, status;
    
    public Bill(int ecode, Date estart_date, Employee eemp, String estatus,
            String emethodpayment){
        super(ecode, estart_date, eemp);
        methodpayment = emethodpayment;
        status = estatus;   
    }
    
    public Bill(){};

    public String getMethodpayment() {
        return methodpayment;
    }

    public void setMethodpayment(String methodpayment) {
        this.methodpayment = methodpayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
