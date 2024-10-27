/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesFachada;

import Excepciones.FacadeException;
import javax.swing.JTable;

/**
 *
 * @author skevi
 */
public interface IMesaFCD {
    
    public void cargarTablaMesas(JTable table) throws FacadeException;
    public String calcularPrecio(String tamaño);
    public void agregarMesas(int numero, String tamaño, String ubicacion) 
            throws FacadeException;
    
}
