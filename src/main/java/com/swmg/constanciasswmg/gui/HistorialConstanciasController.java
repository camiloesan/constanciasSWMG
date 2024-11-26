package com.swmg.constanciasswmg.gui;

import com.swmg.constanciasswmg.dao.implementations.SolicitudesDAO;
import com.swmg.constanciasswmg.pojo.Solicitudes;
import com.swmg.constanciasswmg.utils.SessionDetails;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class HistorialConstanciasController {
    @FXML
    TableView<Solicitudes> tvHistConstancias;
    @FXML
    TableColumn<Solicitudes, String> colFechaSolicitud;
    @FXML
    TableColumn<Solicitudes, String> colTipoConstancia;
    @FXML
    TextField txtFiltro;

    @FXML
    private void initialize() {
//        fill combo box with fecha solicitud - tipo constancia ?
        formatTableView();
        fillTableView();
    }

    private void formatTableView() {
        colFechaSolicitud.setCellValueFactory(new PropertyValueFactory<>("fechaSolicitud"));
        colTipoConstancia.setCellValueFactory(new PropertyValueFactory<>("tipoConstancia"));
    }

    @FXML
    private void fillTableView() {
        SolicitudesDAO solicitudesDAO = new SolicitudesDAO();
        tvHistConstancias.getItems().clear();
        try {
            tvHistConstancias.getItems().addAll(solicitudesDAO.getAllSolicitudesByUserId(SessionDetails.getUserId()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onActionReturn() {
        MainStage.changeView("menu-principal-docente-view.fxml", 800, 600);
    }
}
