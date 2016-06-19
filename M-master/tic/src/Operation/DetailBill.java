/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import Collectives.Client;
import GoodsandServices.CommercialGood;

/**
 *
 * @author carlos
 */
public class DetailBill {
    protected CommercialGood resource;
    protected Client cliente;
    protected int quantity;
    
    public DetailBill(CommercialGood eresource, Client ecliente, int equantity){
        resource = eresource;
        cliente = ecliente;
        quantity = equantity;
    }
    
    public DetailBill(){};

    public CommercialGood getResource() {
        return resource;
    }

    public void setResource(CommercialGood resource) {
        this.resource = resource;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
