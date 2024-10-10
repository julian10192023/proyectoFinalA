package co.edu.uniquindio.proyectoprogramacionfx.prestamo.utils;

import co.edu.uniquindio.proyectoprogramacionfx.prestamo.model.Cliente;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.model.PrestamoObjeto;

public class DataUtil {
    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();
        Cliente cliente1 = Cliente.builder().
                nombre("juan").
                apellido("gomez").
                cedula("12345").
                email("amarangoje@hahas")
                .direccion("calle siempre viva ")
                .build();
        Cliente cliente2 = Cliente.builder().
                nombre("julian").
                apellido("posada").
                cedula("3555").
                email("julian@")
                .direccion("calle 53 ")
                .build();
        Cliente cliente3 = Cliente.builder().
                nombre("valentina ").
                apellido("rojas").
                cedula("4545").
                email("valentin@a")
                .direccion("san andres")
                .build();
        Cliente cliente4 = Cliente.builder().
                nombre("juan jose").
                apellido("tavares").
                cedula("1745").
                email("juanjose@")
                .direccion("fachada ")
                .build();

        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);
        prestamoObjeto.getListaClientes().add(cliente4);

        return prestamoObjeto;
    }


}
