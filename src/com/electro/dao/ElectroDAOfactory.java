/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.electro.dao;

/**
 *
 * @author dandres
 */
public class ElectroDAOfactory {
    public ElectroDAO createElectroDAO(){
        return new ElectroDAOJDBCImpl();
    } 
    
}
