/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electro.dao;

import com.electro.model.ElectroModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dandres
 */
public class ElectroDAOJDBCImpl implements ElectroDAO {

    private Connection conexion = null;

    public ElectroDAOJDBCImpl() {
        String url = "jdbc:mysql://localhost:3306/electrodomesticos?zeroDateTimeBehavior=convertToNull";
        String userName = "root";
        String password = "Persefone2014";
        try {
            conexion = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se pudo establecer conexion: " + e, "Conection lost", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void add(ElectroModel electro) {
        
        try (Statement stmt = conexion.createStatement()) {
            String query = "INSERT INTO producto VALUES (" + electro.getIdProducto()
                    + "," + "'" + electro.getTipo()
                    + "'," + "'" + electro.getMarca() + "',"
                    + "'" + new java.sql.Date(electro.getFechaVenta().getTime())
                    + "'," + electro.getPrecio() + "," + "" + electro.getEstado() + "" + ")";
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha creado el registro"
                    + e, "Error al agregar un registro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(ElectroModel electro) throws SQLException {
        try (Statement stmt = conexion.createStatement()) {
                String query = "UPDATE procesadores "
                        + "SET tipo='" + electro.getTipo() + "',"
                        + "marca='" + electro.getMarca() + "',"
                        + "fecha_venta='" + new java.sql.Date(electro.getFechaVenta().getTime()) + "',"
                        + "precio=" + electro.getPrecio()+ ","
                        + "estado="+ electro.getEstado2()
                        + " WHERE id_producto=" + electro.getIdProducto();
                if (stmt.executeUpdate(query) != 1) {
                    throw new SQLException("Error updating registro");
                }
            } catch (SQLException se) {
                throw new SQLException("Error updating Electro in DAO", se);
            }

        
    }

    @Override
    public void delete(int id) throws SQLException {
        ElectroModel electro = findById(id);
        if (electro == null){
            throw new SQLException("Electro id: " + id + " does not exist to delete.");
        }
        try (Statement stmt = conexion.createStatement()) {
            String query = "DELETE FROM producto WHERE id_producto=" + id;
            
            if (stmt.executeUpdate(query) != 1) {
                throw new SQLException("Error deleting registro");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new SQLException("Error deleting registro in DAO", se);
        } 
    }

    @Override
    public ElectroModel findById(int id) throws SQLException {
        try (Statement stmt=conexion.createStatement()){
            String query = "SELECT * FROM producto WHERE id_producto=" + id;
            ResultSet rs=stmt.executeQuery(query);
            if (rs.next()) {
               return new ElectroModel(rs.getInt("id_producto"),
                       rs.getString("tipo"),
                       rs.getString("marca"),
                       rs.getDate("fecha_venta"),
                       rs.getFloat("precio"),
                       rs.getBoolean("estado")
                        );
           }
            else{
                JOptionPane.showMessageDialog(null, "No encontrado", "ERROR", JOptionPane.ERROR_MESSAGE) ;
                return null;
            }
        } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "No se ha creado registro" + e, "Invalid Add", JOptionPane.ERROR_MESSAGE);
                        return null;
        } 
        
    }

    @Override
    public List<ElectroModel> getAllElectros() throws SQLException {
        try (Statement stmt=conexion.createStatement()){
            String query="select * from producto";
            ResultSet rs=stmt.executeQuery(query);
            List<ElectroModel> lista= new ArrayList<>();
            while (rs.next()) { 
                lista.add(new ElectroModel(rs.getInt("id_producto"),
                       rs.getString("tipo"),
                       rs.getString("marca"),
                       rs.getDate("fecha_venta"),
                       rs.getFloat("precio"),
                       rs.getBoolean("estado")
                       
                ));
            }
            return lista;
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha creado registro" + e, "Invalid Add", JOptionPane.ERROR_MESSAGE);
                return null;
        }
        
    }

    @Override
    public void close() throws Exception {
        try {
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se esta cerrando la conexión"
                    + e, "title", JOptionPane.ERROR_MESSAGE);
        } 
    }

}
