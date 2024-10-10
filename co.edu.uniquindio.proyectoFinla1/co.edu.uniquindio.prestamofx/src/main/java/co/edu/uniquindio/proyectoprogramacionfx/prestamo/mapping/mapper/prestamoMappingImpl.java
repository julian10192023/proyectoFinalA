package co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.mapper;



import co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.dto.ClienteDto;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.model.Cliente;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.service.IPrestamoMapping;

import java.util.ArrayList;
import java.util.List;

public class prestamoMappingImpl implements IPrestamoMapping {


    @Override
    public List<ClienteDto> getClientesDto(List<Cliente> listaClientes) {
        if (listaClientes==null){
            return null;
        }
        List<ClienteDto> listaClienteDto = new ArrayList<ClienteDto>(listaClientes.size());
        for (Cliente cliente : listaClientes) {
            listaClienteDto.add(clienteToClienteDto(cliente));
        }
        return listaClienteDto;
    }

    @Override
    public ClienteDto clienteToClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCedula(),
                cliente.getEmail(),
                cliente.getDireccion());
    }

    @Override
    public Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        return Cliente.builder()
                .nombre(clienteDto.nombre())
                .apellido(clienteDto.apellido())
                .cedula(clienteDto.cedula())
                .email(clienteDto.email())
                .direccion(clienteDto.direccion())
                .build();
    }
}
