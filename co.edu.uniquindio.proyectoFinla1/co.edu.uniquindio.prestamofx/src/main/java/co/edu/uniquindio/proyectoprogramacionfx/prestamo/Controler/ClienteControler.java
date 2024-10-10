package co.edu.uniquindio.proyectoprogramacionfx.prestamo.Controler;

import co.edu.uniquindio.proyectoprogramacionfx.prestamo.factory.ModelFactory;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.dto.ClienteDto;


import java.util.List;

public class ClienteControler  {
        ModelFactory modelFactory;
        public ClienteControler(){
            modelFactory = ModelFactory.getInstancia();
        }

        public List<ClienteDto> obtenerClientes() {
            return modelFactory.obtenerClientes();
        }


    public boolean agregarCliente(ClienteDto clienteDto) {
            return modelFactory.agregarCliente(clienteDto);
    }


    public boolean eliminarCliente(ClienteDto clienteDto) {
        return modelFactory.eliminarCliente(clienteDto);
    }
}


