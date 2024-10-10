package co.edu.uniquindio.proyectoprogramacionfx.prestamo.service;




import co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.dto.ClienteDto;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.model.Cliente;

import java.util.List;

public interface IPrestamoMapping {
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);
    ClienteDto clienteToClienteDto(Cliente cliente);
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

}
