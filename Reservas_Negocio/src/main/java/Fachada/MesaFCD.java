/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import BO.MesaBO;
import BO.RestauranteBO;
import DTOs.MesaDTO;
import DTOs.RestauranteDTO;
import Excepciones.BOException;
import Excepciones.FacadeException;
import Interfaces.IMesaBO;
import Interfaces.IRestauranteBO;
import interfacesFachada.IMesaFCD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skevi
 */
public class MesaFCD implements IMesaFCD{

    private IMesaBO mesaBO;
    private IRestauranteBO restauranteBO;

    public MesaFCD() {
        this.mesaBO = new MesaBO();
        this.restauranteBO = new RestauranteBO();
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
    
    /**
     * 
     * @param numero
     * @param tamaño
     * @param ubicacion
     * @throws FacadeException 
     */
    @Override
    public void agregarMesas(int numero, String tamaño, String ubicacion) 
            throws FacadeException {
        try{
             //definimos la lista de mesas
             List<MesaDTO> mesas = new ArrayList<>();
            
             //definimos el restaurante.
             RestauranteDTO restaurante = restauranteBO.consultar();
             
             //definimos la capacidad maxima y minima
             int capacidadMinima;
             int capacidadMaxima;
             
             if (tamaño.equalsIgnoreCase("PEQUEÑA")) {
                capacidadMinima = 1;
                capacidadMaxima = 2;    
             }
             else if(tamaño.equalsIgnoreCase("MEDIANA")){
                 capacidadMinima = 3;
                 capacidadMaxima = 4;    
             }
             else{
                 capacidadMinima = 5;
                 capacidadMaxima = 8;    
             }
             
             List<String> codigos = generarCodigos(tamaño, ubicacion, numero);
             
             
             //definimos el loop para generar las mesas
             for (int i = 0; i < numero; i++) {
                 mesas.add(new MesaDTO(
                   codigos.get(i),
                   tamaño,
                   capacidadMinima,
                   capacidadMaxima,
                   ubicacion,      
                   restaurante      
                 ));
             }
             
             //guardamos las mesas generadas
             mesaBO.agregarMesas(mesas);
             
        }catch(BOException be){
            throw new FacadeException(be.getMessage());
        }
        
    }
    
    /**
     * 
     * @param numero
     * @param tamaño
     * @param ubicacion
     * @return 
     */
    private List<String> generarCodigos(String tamaño, String ubicacion, int cantidad) 
            throws FacadeException {
        List<String> codigos = new ArrayList<>();

        try {
            // Obtener la cantidad actual de mesas en la ubicación para definir el punto de inicio
            int cantidadActual = mesaBO.cantidadMesasPorUbicacion(ubicacion);
            System.out.println("Cantidad actual: " + cantidadActual);

            // Validar que la cantidad solicitada no supere el límite de 1000
            if (cantidadActual + cantidad > 1000) {
                throw new FacadeException("No se pueden generar más de 1000 mesas en esta ubicación.");
            }

            // Asignar las abreviaturas correspondientes a cada ubicación
            String codigoUbicacion;
            switch (ubicacion.toUpperCase()) {
                case "VENTANA":
                    codigoUbicacion = "VEN";
                    break;
                case "TERRAZA":
                    codigoUbicacion = "TER";
                    break;
                case "GENERAL":
                    codigoUbicacion = "GEN";
                    break;
                default:
                    throw new FacadeException("Ubicación desconocida: " + ubicacion);
            }

            // Generar los códigos desde `cantidadActual + 1` y en adelante hasta cumplir con `cantidad`
            for (int i = 1; i <= cantidad; i++) {
                int numeroActual = cantidadActual + i;
                String numeroFormateado = String.format("%03d", numeroActual); // Asegura 3 dígitos

                // Construir el código completo con el tamaño y el número formateado
                String codigo = codigoUbicacion + "-" + tamaño + "-" + numeroFormateado;
                codigos.add(codigo);
            }

        } catch (BOException be) {
            throw new FacadeException("Error generando códigos de mesa: " + be.getMessage(), be);
        }

        return codigos;
    }
}
