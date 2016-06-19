/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IODades.XMLParsers.Dom;

import java.io.*;
import GoodsandServices.Packages;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author carlos
 */
public class DomPedido extends IODades.XMLParsers.XMLDom {
     
    
    public DomPedido(){};

    @Override
    public int importdades(ArrayList dades, String source){
        
        return 0;
    }
    
    @Override
    public int exportdades(ArrayList dades, String source, int mode){
        int cont = 0;
        
        Element pedido,paquete,precio ,numero;
        
        System.out.println(open(source,0));
        
        while(dades.size() > cont){
            pedido = doc.createElement("Pedido");
            pedido.setAttribute("ID", String.valueOf(cont+1));
            elem.appendChild(pedido);
            paquete = doc.createElement("Paquete");
            paquete.setTextContent(((Packages)dades.get(cont)).getNombre());
            pedido.appendChild(paquete);
            precio = doc.createElement("Precio");
            precio.setTextContent(String.valueOf(((Packages)dades.get(cont)).getPrecio()));
            pedido.appendChild(precio);
            numero = doc.createElement("Numero");
            numero.setTextContent(String.valueOf(((Packages)dades.get(cont)).getNumero()));
            pedido.appendChild(numero);
            cont++;
        }
        
        return 0;
    }
    
}
