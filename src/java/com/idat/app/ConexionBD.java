package com.idat.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    public static void main(String [] args) throws SQLException{
        Connection con= null;
        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            String objetoBD = "{CALL IntervalosHorarios_Crud(?, ?, ?, ?)}";
            con = conexion();
            cst = con.prepareCall(objetoBD);
            cst.setString(1, "ConsultarTodo");
            cst.setInt(2, 0);
            cst.setString(3, null);
            cst.setInt(4, 0);
            boolean hasResultSet = cst.execute();
            if (hasResultSet) {
                rs = cst.getResultSet();
                while (rs.next()) {
                    System.out.println(
                        "Id: " + rs.getInt("idIntervaloHorario") +
                        " - Intervalo: " + rs.getString("intervaloHorario") +
                        " - Número de Vehículos: " + rs.getInt("numeroVehiculos")
                    );
                }
            } else {
                int procesar = cst.getUpdateCount();
                System.out.println("Procesar: " + procesar);
            }
            
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }finally{
            rs.close();
            cst.close();
            con.close();
        }
    }
    
    public static Connection conexion() throws ClassNotFoundException{
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/dbtest2";
        try{
            con = DriverManager.getConnection(url, "root", "user");
        }catch(Exception ex){
            System.out.println("conexion-Error: " + ex.getMessage());
        }
        return con;
    }
}
