package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.InmuebleServiceFacade;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FormularioController {

    @FXML private ComboBox<String> cbTipo;
    @FXML private TextField txtCiudad, txtHabitaciones, txtPisos, txtPrecio;
    @FXML private Button btnSave, btnCancel;

    private final InmuebleServiceFacade facade = new InmuebleServiceFacade();
    private DashboardController dashboardController;

    @FXML
    public void initialize() {
        cbTipo.getItems().addAll("Casa", "Apartamento", "Finca", "Local");

        btnSave.disableProperty().bind(
            cbTipo.valueProperty().isNull()
                .or(txtCiudad.textProperty().isEmpty())
                .or(txtHabitaciones.textProperty().isEmpty())
                .or(txtPisos.textProperty().isEmpty())
                .or(txtPrecio.textProperty().isEmpty())
        );
    }

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @FXML
    private void onSaveInmueble() {
        try {
            String tipo = cbTipo.getValue();
            String ciudad = txtCiudad.getText().trim();
            int habitaciones = Integer.parseInt(txtHabitaciones.getText());
            int pisos = Integer.parseInt(txtPisos.getText());
            double precio = Double.parseDouble(txtPrecio.getText());

            facade.crearInmueble(tipo, ciudad, habitaciones, pisos, precio);

            showAlert("Éxito", "Inmueble agregado correctamente", Alert.AlertType.INFORMATION);
            backToDashboard();
        } catch (Exception e) {
            showAlert("Error", "Datos inválidos o incompletos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onCancel() {
        backToDashboard();
    }

    private void backToDashboard() {
        if (dashboardController != null) {
            dashboardController.backToDashboard();
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alerta = new Alert(type);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(message);
        alerta.showAndWait();
    }
}
