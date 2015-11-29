/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.electro.dao;

import com.electro.model.ElectroModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dandres
 */
public interface ElectroDAO extends AutoCloseable{
    
    public void add(ElectroModel electro);
    
    public void update(ElectroModel electro) throws SQLException;

    public void delete(int id) throws SQLException;

    public ElectroModel findById(int id) throws SQLException;

    public List<ElectroModel> getAllElectros() throws SQLException;
}
