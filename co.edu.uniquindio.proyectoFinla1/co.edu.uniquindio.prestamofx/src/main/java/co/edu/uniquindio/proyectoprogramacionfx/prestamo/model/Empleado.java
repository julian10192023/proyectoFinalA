package co.edu.uniquindio.proyectoprogramacionfx.prestamo.model;

public class Empleado extends  Persona{
    PrestamoObjeto ownedByPrestamoUq;

    public Empleado() {
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

}
