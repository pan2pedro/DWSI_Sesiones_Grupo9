package com.idat.dao.daoImpl;

import com.idat.dao.IIntervalosHorariosDao;
import com.idat.entity.IntervalosHorarios;
import com.idat.repository.ConexionMysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntervalosHorariosDaoImpl implements IIntervalosHorariosDao {

    @Override
    public int operacionesEscritura(String indicador, IntervalosHorarios p) {
        ConexionMysql connection = new ConexionMysql();
        Connection con = null;
        CallableStatement cst = null;
        int procesar = -1;
        String procedimiento = "{call IntervalosHorarios_Crud (?,?,?,?) }";
        try {
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setString(1, indicador);
            cst.setInt(2, p.getIdIntervaloHorario());
            cst.setString(3, p.getIntervaloHorario());
            cst.setInt(4, p.getNumeroVehiculos());
            procesar = cst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("operacionesEscritura - Error : " + ex.getMessage());
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error : " + ex.getMessage());
            }
        }
        return procesar;
    }

    @Override
    public List<IntervalosHorarios> operacionesLectura(String indicador, IntervalosHorarios p) {
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        ConexionMysql connection = new ConexionMysql();
        List<IntervalosHorarios> lista = new ArrayList<>();
        String procedimiento = "{call IntervalosHorarios_Crud (?,?,?,?)}";
        try{
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setString(1, indicador);
            cst.setInt(2, p.getIdIntervaloHorario());
            cst.setString(3, p.getIntervaloHorario());
            cst.setInt(4, p.getNumeroVehiculos());
            rs = cst.executeQuery();
            IntervalosHorarios objIntervalosHorarios;
            while(rs.next()){
                objIntervalosHorarios = new IntervalosHorarios();
                objIntervalosHorarios.setIdIntervaloHorario(rs.getInt(1));
                objIntervalosHorarios.setIntervaloHorario(rs.getString(2));
                objIntervalosHorarios.setNumeroVehiculos(rs.getInt(3));
                lista.add(objIntervalosHorarios);
            }
        }catch(SQLException ex){
            
        }finally{
            try{
                if (rs!= null) rs.close();
                if (cst!= null) cst.close();
                if (con!=null) con.close();
            }catch(SQLException ex){}
        }
        return lista;
    }
}
