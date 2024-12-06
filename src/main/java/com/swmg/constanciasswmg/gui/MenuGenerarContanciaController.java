package com.swmg.constanciasswmg.gui;

import com.swmg.constanciasswmg.dao.implementations.DocenteDAO;
import com.swmg.constanciasswmg.dao.implementations.ParticipacionEEDAO;
import com.swmg.constanciasswmg.dao.implementations.PladeaDAO;
import com.swmg.constanciasswmg.dao.implementations.ProyectoDAO;
import com.swmg.constanciasswmg.pojo.Pladea;
import com.swmg.constanciasswmg.pojo.ParticipacionEE;
import com.swmg.constanciasswmg.pojo.Proyecto;
import com.swmg.constanciasswmg.utils.GenerarPDF;
import com.swmg.constanciasswmg.utils.SessionDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class MenuGenerarContanciaController {

    @FXML
    private Tab tabPladea;

    @FXML
    private TableView<Pladea> tvPladea;

    @FXML
    private TableColumn<Pladea, String> colEjeEstrategico;

    @FXML
    private TableColumn<Pladea, String> colNombrePrograma;

    @FXML
    private TableColumn<Pladea, String> colObjetivosGenerales;

    @FXML
    private TableColumn<Pladea, String> colAcciones;

    @FXML
    private TableColumn<Pladea, String> colMetas;

    @FXML
    private Button btnGenerarConstanciaPladea;

    @FXML
    private Tab tabProyecto;

    @FXML
    private TableView<Proyecto> tvProyecto;

    @FXML
    private TableColumn<Proyecto, String> colNombreProyecto;

    @FXML
    private TableColumn<Proyecto, String> colDuracion;

    @FXML
    private TableColumn<Proyecto, String> colLugar;

    @FXML
    private Tab tabEE;

    @FXML
    private TableView<ParticipacionEE> tvImparticionEE;

    @FXML
    private TableColumn<ParticipacionEE, String> colNombreEE;

    @FXML
    private TableColumn<ParticipacionEE, String> colProgramaE;

    @FXML
    private TableColumn<ParticipacionEE, String> colBloque;

    @FXML
    private Label lblGenerarConstancia;

    @FXML
    private Button btnVolver;

    private final DocenteDAO docenteDAO = new DocenteDAO();
    private final PladeaDAO pladeaDAO = new PladeaDAO();
    private final ParticipacionEEDAO participacionEEDAO = new ParticipacionEEDAO();
    private final ProyectoDAO proyectoDAO = new ProyectoDAO();
    private final GenerarPDF generadorpdf = new GenerarPDF();

    @FXML
    private void initialize() {
        configureTabs();
        configurePladeaTableView();
        fillPladeaTableView();
        configureImparticionEETableView();
        fillImparticionEETableView();
        configureProyectoTableView();
        fillProyectoTableView();
    }

    @FXML
    private void volverMenuDocente() {
        MainStage.changeView("menu-principal-docente-view.fxml", 800, 600);
    }


    private void configureTabs() {
        try {
            int[] availableDocuments = docenteDAO.availableKindOfDocument(SessionDetails.getUserId());

            tabPladea.setDisable(availableDocuments[0] == 0);
            tabProyecto.setDisable(availableDocuments[1] == 0);
            tabEE.setDisable(availableDocuments[2] == 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configurePladeaTableView() {
        // Configuración de columnas
        colEjeEstrategico.setCellValueFactory(new PropertyValueFactory<>("ejeEstrategico"));
        colNombrePrograma.setCellValueFactory(new PropertyValueFactory<>("nombrePrograma"));
        colObjetivosGenerales.setCellValueFactory(new PropertyValueFactory<>("objetivosGenerales"));
        colAcciones.setCellValueFactory(new PropertyValueFactory<>("acciones"));
        colMetas.setCellValueFactory(new PropertyValueFactory<>("metas"));
    }

    private void fillPladeaTableView() {
        try {
            int userId = SessionDetails.getUserId(); // ID del docente actual
            List<Pladea> pladeaList = pladeaDAO.getPladeaByDocenteId(userId);
            ObservableList<Pladea> observablePladeaList = FXCollections.observableArrayList(pladeaList);
            tvPladea.setItems(observablePladeaList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configureImparticionEETableView() {
        colNombreEE.setCellValueFactory(new PropertyValueFactory<>("nombreEe"));
        colProgramaE.setCellValueFactory(new PropertyValueFactory<>("programa"));
        colBloque.setCellValueFactory(new PropertyValueFactory<>("bloque"));
    }

    private void fillImparticionEETableView() {
        try {
            int userId = SessionDetails.getUserId();
            List<ParticipacionEE> participacionEEList = participacionEEDAO.getParticipacionesByDocenteId(userId);
            ObservableList<ParticipacionEE> observableParticipacionEEList = FXCollections.observableArrayList(participacionEEList);
            tvImparticionEE.setItems(observableParticipacionEEList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configureProyectoTableView() {
        colNombreProyecto.setCellValueFactory(new PropertyValueFactory<>("nombreProyecto"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
    }

    private void fillProyectoTableView() {
        try {
            int userId = SessionDetails.getUserId();
            List<Proyecto> proyectoList = proyectoDAO.getProyectosByDocenteId(userId);
            ObservableList<Proyecto> observableProyectoList = FXCollections.observableArrayList(proyectoList);
            tvProyecto.setItems(observableProyectoList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void GenerarConstanciaPladea() {
        Pladea selectedPladea = tvPladea.getSelectionModel().getSelectedItem();
        if (selectedPladea == null) {
            showAlert("Selección requerida", "Por favor selecciona un registro de la tabla para generar la constancia.");
            return;
        }
        try {

            //boolean success = pladeaDAO.generatePladeaConstancia(selectedPladea, SessionDetails.getUserId());
            generadorpdf.GenerarConstanciaPladea(selectedPladea, docenteDAO.getNombreDeDocenteByID(SessionDetails.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Ocurrió un error al generar la constancia.");
        }
    }

    @FXML
    private void GenerarConstanciaEE() {
        //Pladea selectedPladea = tvPladea.getSelectionModel().getSelectedItem();
        ParticipacionEE selectedParticipacion = tvImparticionEE.getSelectionModel().getSelectedItem();
        if (selectedParticipacion == null) {
            showAlert("Selección requerida", "Por favor selecciona un registro de la tabla para generar la constancia.");
            return;
        }
        try {
            generadorpdf.GenerarConstanciaEE(selectedParticipacion, docenteDAO.getNombreDeDocenteByID(SessionDetails.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Ocurrió un error al generar la constancia.");
        }
    }

    @FXML
    private void GenerarConstanciaProyecto() {
        Proyecto selectedProyecto = tvProyecto.getSelectionModel().getSelectedItem();
        if (selectedProyecto == null) {
            showAlert("Selección requerida", "Por favor selecciona un registro de la tabla para generar la constancia.");
            return;
        }
        try {
            generadorpdf.GenerarConstanciaProyecto(selectedProyecto, docenteDAO.getNombreDeDocenteByID(SessionDetails.getUserId()));
           // generadorpdf.GenerarConstanciaProyecto(selectedProyecto, docenteDAO.getNombreDeDocenteByID(SessionDetails.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Ocurrió un error al generar la constancia.");
        }
    }
}
