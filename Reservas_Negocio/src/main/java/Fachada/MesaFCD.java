/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import BO.MesaBO;
import DTOs.MesaDTO;
import Excepciones.BOException;
import Excepciones.FacadeException;
import Interfaces.IMesaBO;
import interfacesFachada.IMesaFCD;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skevi
 */
public class MesaFCD implements IMesaFCD{

    private IMesaBO mesaBO;

    public MesaFCD() {
        this.mesaBO = new MesaBO();
    }
    
    /**
     * Carga los datos de las mesas a una tabla.
     * 
     * @param table tabla en la que se agregaran los datos.
     * @throws FacadeException Excepcion de capas inferiores.
     */
    @Override
    public void cargarTablaMesas(JTable table) throws FacadeException {
        try {
            // Obtener las mesas de algún servicio o repositorio
            List<MesaDTO> mesas = mesaBO.consultarMesas();
            
            String[] columnNames = {"Codigo", "Tipo", "Min Personas", "Max Personas", "Ubicacion"};
            
            // Crear o obtener el modelo de la tabla
            DefaultTableModel model = new DefaultTableModel(columnNames,0);

            // Limpiar el modelo de la tabla para evitar duplicados
            model.setRowCount(0);

            // Recorrer la lista de mesas y agregar los datos al modelo de la tabla
            for (MesaDTO mesa : mesas) {
                Object[] rowData = {
                    mesa.getCodigoMesa(),
                    mesa.getTipoMesa(),
                    mesa.getCapacidadMinima(),
                    mesa.getCapacidadMaxima(),
                    mesa.getUbicacion()
                };
                model.addRow(rowData); // Agregar la fila al modelo
            }

            // Asignar el modelo a la tabla
            table.setModel(model);
            
        } catch (BOException be) {
            // Lanzar una excepción en caso de error en las capas inferiores
            throw new FacadeException(be.getMessage());
        }
    }
    
    /**
     * 
     * @param tamaño
     * @return 
     */
    @Override
    public String calcularPrecio(String tamaño){
        
        if (tamaño.equalsIgnoreCase("PEQUEÑA")) {
            return "300.0";
        }
        if (tamaño.equalsIgnoreCase("MEDIANA")) {
            return "500.0";
        }
        if (tamaño.equalsIgnoreCase("GRANDE")) {
            return "700.0";
        }
        return null;
        
    }
    
}
