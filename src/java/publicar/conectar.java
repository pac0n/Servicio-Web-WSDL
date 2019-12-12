/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Pac0n
 */
public class conectar {
     Connection conect = null;
    public Connection conexion()
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                conect = DriverManager.getConnection("jdbc:mysql://localhost/dec","root","");

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("error de conexion");

            }
            return conect;
        }
}
