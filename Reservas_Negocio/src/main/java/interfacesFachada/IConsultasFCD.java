/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Sebastian Murrieta
 */
package interfacesFachada;

import DTOs.ReservaDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface IConsultasFCD {

    List<ReservaDTO> consultarReservasPorFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<ReservaDTO> consultarReservasPorTipoMesa(String tipoMesa);

    List<ReservaDTO> consultarReservasPorUbicacion(String ubicacion);

    List<ReservaDTO> consultarReservas(LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoMesa, String ubicacion);
}
