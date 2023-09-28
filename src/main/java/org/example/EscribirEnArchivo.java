package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirEnArchivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();

        try {
            FileWriter archivo = new FileWriter(nombreArchivo, true); // El segundo argumento "true" permite la adición de datos al archivo existente

            System.out.println("Introduce los datos que deseas escribir en el archivo (Escribe 'fin' para terminar):");

            while (true) {
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("fin")) {
                    break; // Salir del bucle si se ingresa "fin"
                }

                archivo.write(entrada + "\n"); // Escribe la entrada en el archivo
            }

            archivo.close(); // Cierra el archivo cuando hayas terminado de escribir
            System.out.println("Datos escritos en el archivo con éxito.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        } finally {
            scanner.close(); // Cierra el scanner
        }
    }
}
