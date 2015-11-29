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
public class DAOException extends Exception{
      public DAOException(){
        super();
    }
    public DAOException(String msj){
        super(msj);
    }
    public DAOException(Throwable thr){
        super(thr);
    }
    public DAOException(String msj,Throwable thr){
        super(msj,thr);
    }
    
}
