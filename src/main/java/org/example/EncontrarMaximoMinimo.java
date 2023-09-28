package org.example;

import java.util.Scanner;

public class EncontrarMaximoMinimo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int numero;
            int numeroMaximo = Integer.MIN_VALUE; // Inicializar con el valor mínimo posible
            int numeroMinimo = Integer.MAX_VALUE; // Inicializar con el valor máximo posible

            System.out.println("Ingrese números. Ingrese 0 para finalizar.");

            while (true) {
                numero = scanner.nextInt();

                if (numero == 0) {
                    break; // Salir del bucle si se ingresa 0
                }

                // Actualizar el número máximo y mínimo si es necesario
                if (numero > numeroMaximo) {
                    numeroMaximo = numero;
                }
                if (numero < numeroMinimo) {
                    numeroMinimo = numero;
                }
            }

            if (numeroMaximo == Integer.MIN_VALUE || numeroMinimo == Integer.MAX_VALUE) {
                System.out.println("No se ingresaron números distintos de 0.");
            } else {
                System.out.println("Número más alto: " + numeroMaximo);
                System.out.println("Número más bajo: " + numeroMinimo);
            }

            scanner.close();
        }
    }

