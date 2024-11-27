package com.swmg.constanciasswmg.gui;

import com.swmg.constanciasswmg.dao.implementations.SolicitudesDAO;
import com.swmg.constanciasswmg.dao.implementations.TiposConstanciasDAO;
import com.swmg.constanciasswmg.pojo.Solicitudes;
import com.swmg.constanciasswmg.pojo.TipoConstancias;
import com.swmg.constanciasswmg.utils.SessionDetails;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistorialConstanciasController {
    @FXML
    TableView<Solicitudes> tvHistConstancias;
    @FXML
    TableColumn<Solicitudes, Date> colFechaSolicitud;
    @FXML
    TableColumn<Solicitudes, String> colTipoConstancia;
    @FXML
    ComboBox<TipoConstancias> cbTipoConstancia;
    List<Solicitudes> solicitudesList = new ArrayList<>();

    @FXML
    private void initialize() {
        formatTableView();
        fillCbTipoConstancia();
        fillTableView();
    }

    @FXML
    private void filterTableView() {
        TipoConstancias tipoConstancias =  cbTipoConstancia.getSelectionModel().getSelectedItem();
        List<Solicitudes> matchingSolicitudes = new ArrayList<>();

        List<Solicitudes> actual = solicitudesList;

        for (Solicitudes solicitud : actual) {
            if (tipoConstancias.getNombreTipoConstancia().equals(solicitud.getTipoConstancia())) {
                matchingSolicitudes.add(solicitud);
            }
        }

        tvHistConstancias.getItems().clear();
        tvHistConstancias.getItems().setAll(matchingSolicitudes);
    }

    private void fillCbTipoConstancia() {
        TiposConstanciasDAO tiposConstanciasDAO = new TiposConstanciasDAO();
        try {
            cbTipoConstancia.getItems().addAll(tiposConstanciasDAO.getTiposConstancias());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
            solicitudesList = solicitudesDAO.getAllSolicitudesByUserId(SessionDetails.getUserId());
            tvHistConstancias.getItems().addAll(solicitudesList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void resetTable() {
        fillTableView();
    }

    @FXML
    private void onActionReturn() {
        MainStage.changeView("menu-principal-docente-view.fxml", 800, 600);
    }
}
