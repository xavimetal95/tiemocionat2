/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IODades.XMLParsers;

import IODades.*;
import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author TicEmocionat
 */
public class XMLDom implements DataSource, Serializable{
    
    protected DocumentBuilder builder;
    protected Document doc;
    protected Element elem;
    protected Node nodeArrel, nodeFill, subnode;
    protected NodeList llistaNodes, llistaAtrib;
    
    public XMLDom(DocumentBuilder ebuilder, Document edoc, Element eelem, Node enodeArrel, Node enodeFill, Node esubnode, NodeList ellistaNodes, NodeList ellistaAtrib){
        builder = ebuilder;
        doc = edoc;
        elem = eelem;
        nodeArrel = enodeArrel;
        nodeFill = enodeFill;
        subnode = esubnode;
        llistaNodes = ellistaNodes;
        llistaAtrib = ellistaAtrib;
    }
    
    public XMLDom(){};
    
    @Override
    public int open (String source, int mode){
        int error = 0;
        
        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.newDocument(); 
            elem = doc.createElement(source);
            doc.appendChild(elem);
        }catch (ParserConfigurationException e) {
            System.out.printf ("Error al realtzar el parser"+ e.getMessage()); //comentar
            error = -1;
        }
       catch (DOMException e) {
            System.out.printf ("Error del DOM al obrir" + e.getMessage()); //comentar
            error = -3;
        }

        
        return error;
    }
    
    @Override
    public int close (String source){
        int error = -1;
        
        try{
            TransformerFactory transFabric = TransformerFactory.newInstance();
            Transformer transformer = transFabric.newTransformer();
            DOMSource dsource = new DOMSource(doc); // Crea la font XML a partir del document
            StreamResult result = new StreamResult(new File(source)); // Crear el fitxer
            transformer.transform(dsource, result);
        }catch (TransformerException e){
            System.out.println("Error al transformar" + e.getMessage()); //comentar
        }

        
        return error;
    }
    
    @Override
    public int importdades(ArrayList dades, String source){
        
        
        return 0;
    }
    
    @Override
    public int exportdades (ArrayList dades, String source, int mode){
        
        
        return 0;
    }
}