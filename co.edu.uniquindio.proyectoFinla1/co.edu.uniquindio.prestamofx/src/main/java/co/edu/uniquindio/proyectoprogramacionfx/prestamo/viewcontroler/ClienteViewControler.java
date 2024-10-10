package co.edu.uniquindio.proyectoprogramacionfx.prestamo.viewcontroler;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyectoprogramacionfx.prestamo.Controler.ClienteControler;
import co.edu.uniquindio.proyectoprogramacionfx.prestamo.mapping.dto.ClienteDto;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteViewControler {
    ClienteControler clienteControler;
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();
    ClienteDto clienteSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableColumn<ClienteDto, String> coluApellido;

    @FXML
    private TableColumn<ClienteDto, String> coluCedula;

    @FXML
    private TableColumn<ClienteDto, String> coluDireccion;

    @FXML
    private TableColumn<ClienteDto, String> coluEmail;

    @FXML
    private TableColumn<ClienteDto, String> coluNombre;

    @FXML
    private TableView<ClienteDto> tabVisaulizar;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    void onActualizar(ActionEvent event) {

    }

    private boolean datosValido(ClienteDto clienteDto) {
        if (clienteDto.nombre().isEmpty()
                || clienteDto.apellido().isEmpty()
                || clienteDto.cedula().isEmpty()
                || clienteDto.email().isEmpty()
                || clienteDto.direccion().isEmpty()){
            return  false;
        } else{
            return true;
        }
    }



    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
    private ClienteDto crearClienteDto() {
        return new ClienteDto(txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtEmail.getText(),
                txtDireccion.getText()
        );
    }

    private void agregarAdministrador() {
      ClienteDto clienteDto =crearClienteDto();

    }

    @FXML
    void onAgregar(ActionEvent event) {
        agregarAdministrador();
        ClienteDto clienteDto = crearClienteDto();
        if (datosValido (clienteDto)){
           if( clienteControler.agregarCliente(clienteDto)){
               listaClientes.add(clienteDto);
           }else{
               mostrarMensaje("Cliente no agregado ","El cliente ya existe  ","L ",Alert.AlertType.ERROR);
           }

        }
        else{
            mostrarMensaje("compos incompletos","Notificacion ","Los datos del formulario estan incompletos ",Alert.AlertType.WARNING);
        }

    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarCliente();
        ClienteDto clienteDto = eliminarClienteDto();
        if (datosValido (clienteDto)){
            if( clienteControler.eliminarCliente(clienteDto)){
                listaClientes.remove(clienteDto);
            }else{
                mostrarMensaje("Cliente no agregado ","El cliente ya existe  ","L ",Alert.AlertType.ERROR);
            }

        }
        else{
            mostrarMensaje("compos incompletos","Notificacion ","Los datos del formulario estan incompletos ",Alert.AlertType.WARNING);
        }



    }

    private void eliminarCliente() {
        ClienteDto clienteDto =eliminarClienteDto();

    }

    private ClienteDto eliminarClienteDto() {
        return new ClienteDto(txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtEmail.getText(),
                txtDireccion.getText()
        );
    }

    @FXML
    void onNuevo(ActionEvent event) {

    }

    @FXML
    void initialize() {
        clienteControler  = new ClienteControler();
        initView();

    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tabVisaulizar.getItems().clear();
        tabVisaulizar.setItems(listaClientes);
        listenerSelection();

    }

    private void obtenerClientes() {
       listaClientes.addAll(clienteControler.obtenerClientes());

    }

    private void listenerSelection() {
        tabVisaulizar.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });

    }

    private void mostrarInformacionCliente(ClienteDto clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.nombre());
            txtApellido.setText(clienteSeleccionado.apellido());
            txtCedula.setText(clienteSeleccionado.cedula());
            txtEmail.setText(clienteSeleccionado.email());
            txtDireccion.setText(clienteSeleccionado.direccion());
        }
    }


    private void initDataBinding() {
        coluNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        coluApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        coluCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        coluEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        coluDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
    }

}

