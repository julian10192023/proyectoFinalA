package co.edu.uniquindio.proyectoprogramacionfx.prestamo.factory;

import co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.dto.ClienteDto;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.mapper.prestamoMappingImpl;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.model.PrestamoObjeto;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.service.IModelFactoryServices;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.service.IPrestamoMapping;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoObjeto;
    private IPrestamoMapping mapper;

    private ModelFactory(){

        mapper =new prestamoMappingImpl();
        prestamoObjeto = DataUtil.inicializarDatos();
    }

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    @Override
    public List<ClienteDto> obtenerClientes() {
        return mapper.getClientesDto(prestamoObjeto.getListaClientes());
    }

    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        return prestamoObjeto.crearCliente(mapper.clienteDtoToCliente(clienteDto)) ;
    }


    public boolean eliminarCliente(ClienteDto clienteDto) {
        return prestamoObjeto.eliminarCliente(mapper.clienteDtoToCliente(clienteDto)) ;
    }
}
