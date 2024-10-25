/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesFachada;

import Entidades.Cliente;
import Excepciones.FacadeException;
import javax.swing.JComboBox;

/**
 *
 * @author skevi
 */
public interface IClienteFCD {
    
    public void cargarComboBoxClientes(JComboBox combo) throws FacadeException;
    
}
