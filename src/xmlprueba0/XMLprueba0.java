/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlprueba0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class XMLprueba0 {

    public static void main(String[] args) {
        try {
            //FLUJO DE ESCRITURA
            XMLStreamWriter sw = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream("autores.xml"));          

            //ESCRITURA
            sw.writeStartDocument("1.0");
            sw.writeStartElement("autores");
            sw.writeStartElement("autor");
            sw.writeAttribute("codigo", "a1");
            sw.writeStartElement("nome");
            sw.writeCharacters("Alexandre Dumas");
            sw.writeEndElement();
            sw.writeStartElement("titulo");
            sw.writeCharacters("El conde de montecristo");
            sw.writeEndElement();
            sw.writeStartElement("titulo");
            sw.writeCharacters("Los miserables");
            sw.writeEndElement();
            sw.writeEndElement();
            sw.writeStartElement("autor");
            sw.writeAttribute("codigo", "a2");
            sw.writeStartElement("nome");
            sw.writeCharacters("Fiodor Dostoyevski");
            sw.writeEndElement();
            sw.writeStartElement("titulo");
            sw.writeCharacters(" El idiota");
            sw.writeEndElement();
            sw.writeStartElement("titulo");
            sw.writeCharacters("Noches blancas");
            sw.writeEndDocument();
            sw.flush();
            sw.close();

            //FLUJO DE LECTURA
            XMLEventReader er = XMLInputFactory.newInstance().createXMLEventReader("autores.xml", new FileInputStream("autores.xml"));
            
            //LECTURA
            while (er.hasNext()) {
                System.out.println(er.nextEvent().toString());
            }
            er.close();

        } catch (XMLStreamException | FileNotFoundException ex) {
            Logger.getLogger(XMLprueba0.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
