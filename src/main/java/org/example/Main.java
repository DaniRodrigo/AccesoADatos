package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[]args){

        AccesoDatosJDBC a = new AccesoDatosJDBC();

        a.openConection();

        boolean actualizacionExitosa = a.executeUpdate("DELETE FROM alumnos WHERE Escuela = 'Conalep Texcoco';");

        if (actualizacionExitosa) {
            System.out.println("Actualización exitosa.");
        } else {
            System.out.println("No se encontró un alumno con el nombre 'Fabian' o no se realizó ninguna actualización.");
        }

        ResultSet resultSet = a.executeQuery("SELECT * FROM alumnos");

        try {
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                int edad = resultSet.getInt("Edad");
                String semestre = resultSet.getNString("Semestre");
                int promedio = resultSet.getInt("Promedio");
                String escuela = resultSet.getString("Escuela");
                System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Semestre: " + semestre + ", Promedio: " + promedio + ", Escuela: " + escuela);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            a.closeConexion();
        }
    }
