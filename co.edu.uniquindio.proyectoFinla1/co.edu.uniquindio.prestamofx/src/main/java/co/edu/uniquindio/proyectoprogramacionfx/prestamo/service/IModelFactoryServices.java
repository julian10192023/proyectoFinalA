package co.edu.uniquindio.proyectoprogramacionfx.prestamo.service;

import co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.dto.ClienteDto;

import java.util.List;

public interface IModelFactoryServices {
    List<ClienteDto> obtenerClientes();

    boolean agregarCliente(ClienteDto clienteDto);

}
