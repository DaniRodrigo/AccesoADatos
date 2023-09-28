package org.example;

import java.io.*;
import java.util.Scanner;

public class LecturaYEscrituraDeFicheros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nombre del archivo
        String nombreArchivo = "FicheroPrueba.txt";

        try {
            // Comprobar si el archivo existe
            File archivo = new File(nombreArchivo);
            boolean existe = archivo.exists();

            // Crear FileWriter en modo de añadir (append) si el archivo existe
            FileWriter fileWriter = new FileWriter(nombreArchivo, true);

            // Si el archivo no existe, crearlo desde cero
            if (!existe) {
                fileWriter.write("Contenido inicial del archivo:\n");
            }

            // Leer el contenido del archivo antes de escribir
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            System.out.println("Contenido actual del archivo:");
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            bufferedReader.close();

            System.out.println("Introduce datos para escribir en el archivo (termina con '#'): ");
            String entrada;
            while (!(entrada = scanner.nextLine()).equals("#")) {
                fileWriter.write(entrada + "\n");
            }

            fileWriter.close();
            System.out.println("Datos escritos en el archivo con éxito.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir o leer en el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
