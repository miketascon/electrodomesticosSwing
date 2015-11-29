/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.electro.controller;

import com.electro.dao.ElectroDAO;
import com.electro.dao.ElectroDAOfactory;
import com.electro.model.ElectroModel;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dandres
 */
public class ElectroController {
    
    private static final ElectroController controller = new ElectroController();
    private int id;
    private ElectroModel electroActual;
    private List<ElectroModel> listaElectro;
    private ElectroDAOfactory fabrica;

    public ElectroController() {
        fabrica = new ElectroDAOfactory();
        
    }
    
   public static ElectroController getController(){
       return controller;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElectroModel getElectroActual() {
        return electroActual;
    }

    public void setElectroActual(ElectroModel electroActual) {
        this.electroActual = electroActual;
    }

    public List<ElectroModel> getListaElectro() {
         if (listaElectro == null) {
            try (ElectroDAO dao = fabrica.createElectroDAO();) {
                listaElectro = dao.getAllElectros();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error" + e.getClass().getName()
                        + ",quiting", JOptionPane.ERROR_MESSAGE
                );
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error closing resource" + e.getClass().getName()
                        + ",quiting", JOptionPane.ERROR_MESSAGE
                );
            }

        }
        return listaElectro;
    }

    public void setListaElectro(List<ElectroModel> listaElectro) {
        this.listaElectro = listaElectro;
    }

    public ElectroDAOfactory getFabrica() {
        return fabrica;
    }

    public void setFabrica(ElectroDAOfactory fabrica) {
        this.fabrica = fabrica;
    }
    
    public void recargarLista(){
        listaElectro = null;
    }
    
     public boolean addElectro() {
        try (ElectroDAO dao = fabrica.createElectroDAO();) {
            dao.add(electroActual);
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error closing resource" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

    }
     
     public boolean updateElectro() {
        try (ElectroDAO dao = fabrica.createElectroDAO();) {
            dao.update(electroActual);
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "message" + e.getMessage(), "Error closing resource" + e.getClass().getName()
                    + ",quiting", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

    }
    
        public boolean deleteElectro(int id) {
        this.id = id;
        try (ElectroDAO dao = fabrica.createElectroDAO();) {
            dao.delete(id);
            return true;
        } catch (IOException e) {
            System.out.println("Error " + e.getClass().getName() + " , quiting.");
            System.out.println("Message: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error closing resource " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
            return false;
        }

    }
}
