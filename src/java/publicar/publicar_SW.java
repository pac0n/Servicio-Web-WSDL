/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicar;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author Pac0n
 */
@WebService(serviceName = "publicar_SW")
public class publicar_SW {



    /**
     * Web service operation
     */
    @WebMethod(operationName = "consulta")
    
    public String[] consulta() {
         conectar cc = new conectar();
         Connection cn = cc.conexion();
        //TODO write your implementation code here:
        String [] titulos = {"ID","Nombre"};
        String [] registros = new String[2];
        
        String sql="Select *from donador";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0]=rs.getString("id_donador");
                registros[1]=rs.getString("nombre");
            }
               
        } catch (SQLException ex) {
           
        }
        for (int x=0;x<registros.length;x++)
        {
            return registros;
        }
            
        return null;
        

    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrar_equipo")
    public String registrar_equipo(@WebParam(name = "disco_duro") String disco_duro, @WebParam(name = "procesador") String procesador, @WebParam(name = "ram") String ram, @WebParam(name = "id_donador") int id_donador) {
        //TODO write your implementation code here:       
       conectar cc = new conectar();
       Connection cn = cc.conexion();
       String sql="";
       
       sql="insert into equipo (disco_duro, procesador, ram, id_donador) values(?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, disco_duro);
            pst.setString(2, procesador);
            pst.setString(3, ram);
            pst.setInt(4, id_donador);
            

            int n=pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en el registro");
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrar_donador")
    public String registrar_donador(@WebParam(name = "nombre") String nombre, @WebParam(name = "nickname") String nickname, @WebParam(name = "pass") String pass, @WebParam(name = "wa") int wa, @WebParam(name = "estatus") String estatus) {
        //TODO write your implementation code here:
         conectar cc = new conectar();
       Connection cn = cc.conexion();
       String sql="";
       
       sql="insert into donador (nombre, nickname, pass, wa, estatus) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, nickname);
            pst.setString(3, pass);
            pst.setInt(4, wa);
            pst.setString(5, estatus);

            int n=pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en el registro");
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrar_beneficiado")
    public String registrar_beneficiado(@WebParam(name = "nombre") String nombre, @WebParam(name = "nickname") String nickname, @WebParam(name = "pass") String pass, @WebParam(name = "donador") String donador, @WebParam(name = "equipo_recibido") int equipo_recibido, @WebParam(name = "estatus") String estatus) {
        //TODO write your implementation code here:
         conectar cc = new conectar();
       Connection cn = cc.conexion();
       String sql="";
       
       sql="insert into beneficiado (nombre, nickname, pass, donador, equipo_recibido, estatus) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, nickname);
            pst.setString(3, pass);
            pst.setString(4, donador);
            pst.setInt(5, equipo_recibido);
            pst.setString(6, estatus);


            int n=pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en el registro");
        }
        return null;
    }
}
