module co.edu.uniquindio.proyectoprogramacionfx.prestamo {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.proyectoprogramacionfx.prestamo to javafx.fxml;
    exports co.edu.uniquindio.proyectoprogramacionfx.prestamo;

    opens co.edu.uniquindio.proyectoprogramacionfx.prestamo.viewcontroler to javafx.fxml;
    exports co.edu.uniquindio.proyectoprogramacionfx.prestamo.viewcontroler;

    opens co.edu.uniquindio.proyectoprogramacionfx.prestamo.Controler;
    exports co.edu.uniquindio.proyectoprogramacionfx.prestamo.Controler;
}