package org.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

    public class GeneradorDOM {
        private Document document; // Atributo

        public GeneradorDOM() throws ParserConfigurationException { // Constructor
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            document = b.newDocument();
        }

        public void generarDocument() {
            Element persona = document.createElement("persona"); // Creamos el elemento persona
            document.appendChild(persona); // Lo convertimos en elemento raíz

            persona.setAttribute("profesion", "cantante");

            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode("Elsa"));
            persona.appendChild(nombre);

            Element mujer = document.createElement("mujer");
            persona.appendChild(mujer);

            Element fechaNacimiento = document.createElement("fecha_de_nacimiento");
            persona.appendChild(fechaNacimiento);

            Element dia = document.createElement("dia");
            dia.appendChild(document.createTextNode("18"));
            fechaNacimiento.appendChild(dia);

            Element mes = document.createElement("mes");
            mes.appendChild(document.createTextNode("6"));
            fechaNacimiento.appendChild(mes);

            Element año = document.createElement("año");
            año.appendChild(document.createTextNode("1996"));
            fechaNacimiento.appendChild(año);

            Element ciudad = document.createElement("ciudad");
            ciudad.appendChild(document.createTextNode("Pamplona"));
            persona.appendChild(ciudad);
        }

        public void generarXml() throws TransformerConfigurationException, IOException, TransformerException {
            TransformerFactory factoria = TransformerFactory.newInstance();
            Transformer transformer = factoria.newTransformer();

            Source source = new DOMSource(document);
            File file = new File("C:\\Users\\danir\\Desktop\\Trasteo Clases\\Acceso a datos\\prueba3.xml");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            Result r = new StreamResult(pw);

            transformer.transform(source, r);
        }

        public static void main(String[] args) {
            try {
                GeneradorDOM generador = new GeneradorDOM();
                generador.generarDocument();
                generador.generarXml();
                System.out.println("Mensaje XML generado con éxito.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

