package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.Inmueble;
import co.edu.uniquindio.poo.model.InmuebleServiceFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListadoController {
    @FXML private TableView<Inmueble> tablaInmuebles;
    @FXML private TableColumn<Inmueble, String> colTipo;
    @FXML private TableColumn<Inmueble, String> colCiudad;
    @FXML private TableColumn<Inmueble, Integer> colHabitaciones;
    @FXML private TableColumn<Inmueble, Integer> colNumPisos;
    @FXML private TableColumn<Inmueble, Double> colPrecio;

    private final InmuebleServiceFacade facade = new InmuebleServiceFacade();
    private ObservableList<Inmueble> inmueblesList;
    private DashboardController dashboardController;

    @FXML
    public void initialize() {
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colHabitaciones.setCellValueFactory(new PropertyValueFactory<>("habitaciones"));
        colNumPisos.setCellValueFactory(new PropertyValueFactory<>("numPisos"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        loadInmuebles();
    }

    public void loadInmuebles() {
        inmueblesList = FXCollections.observableArrayList
        (facade.listadoInmuebles());
        tablaInmuebles.setItems(inmueblesList);
    }

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @FXML
    private void onDeleteButton() {
        Inmueble selected = tablaInmuebles.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Advertencia", "Seleccione un inmueble para eliminar", Alert.AlertType.WARNING);
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "¿Eliminar este inmueble?", ButtonType.OK, ButtonType.CANCEL);
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                facade.eliminarInmueble(selected);
                loadInmuebles();
                showAlert("Éxito", "Inmueble eliminado", Alert.AlertType.INFORMATION);
            }
        });
    }

    @FXML
    private void onBackToDashboard() {
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

