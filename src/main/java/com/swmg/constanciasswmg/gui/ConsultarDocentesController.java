package com.swmg.constanciasswmg.gui;

import com.swmg.constanciasswmg.dao.implementations.DocenteDAO;
import com.swmg.constanciasswmg.pojo.Docente;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class ConsultarDocentesController {
    @FXML
    TableView<Docente> tvDocentes;
    @FXML
    TableColumn<Docente, String> colNombre;
    @FXML
    TableColumn<Docente, String> colApellidos;
    @FXML
    TableColumn<Docente, Integer> colTelefono;
    @FXML
    TableColumn<Docente, String> colEmail;
    @FXML
    TableColumn<Docente, String> colNoTrabajador;


    @FXML
    private void initialize() {
        formatTableView();
        fillTableView();
    }

    private void formatTableView() {
        colNoTrabajador.setCellValueFactory(new PropertyValueFactory<>("noTrabajador"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    private void fillTableView() {
        DocenteDAO docenteDAO = new DocenteDAO();
        tvDocentes.getItems().clear();

        try {
            tvDocentes.getItems().addAll(docenteDAO.selectAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void regresar() {
        MainStage.changeView("menu-principal-admin-view.fxml", 800, 600);
    }
}
