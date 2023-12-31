package org.example;

import java.sql.*;

public class AccesoDatosJDBC {

    /**
     * Clase que utilizamos para conectar con la base de datos MySQL.
     */

        //Atributos

        private Connection con;
        private String url = "jdbc:mysql://localhost:3306/alumnosaccesodatos?serverTimezone=UTC";  //url de la base de datos

        /**
         * Método que abre la conexion con la base de datos y utiliza las credenciales establecidas.
         */

        public void openConection() {

            //Es necesario el uso de try-catch

            try {
                con = DriverManager.getConnection(url, "root", "DaniRodrigo791");
                System.out.println("Conexión efectuada");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Método que cierra la conexion con la base de datos.
         */
        public void closeConexion() {

            //Es necesario el uso de try-catch

            try {
                con.close();
                System.out.println("Conexión finalizada");
            } catch (SQLException ex) {
                System.out.println("ERROR:al cerrar la conexión");
                ex.printStackTrace();
            }
        }

    /**
     * Método que introduce una consulta SQL de lectura en la base de datos y la ejecuta.
     */
    public ResultSet executeQuery(String sql) { // solo selects
        try {
            Statement sentencia = con.createStatement();
            return sentencia.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que introduce una consulta SQL que va a modificar la base de datos y la ejecuta.
     */
    public boolean executeUpdate(String sql) { // insert, update y delete
        try {
            Statement sentencia = con.createStatement();
            return sentencia.executeUpdate(sql) <= 0 ? false : true;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    //Getter para obtener la conexión en otras clases y métodos

    public Connection getCon() {
        return con;
    }

    }

