package com.swmg.constanciasswmg.gui;

import com.swmg.constanciasswmg.dao.implementations.DocenteDAO;
import com.swmg.constanciasswmg.pojo.Docente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegistrarDocenteController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtFirmaDigital;
    @FXML
    private TextField txtEmail;

    @FXML
    private void initialize() {}

    @FXML
    private void guardar() {
        if (!areFieldsValid()) {
            return;
        }

        Docente docente = new Docente();
        docente.setNombre(txtNombre.getText());
        docente.setApellidos(txtApellidos.getText());
        docente.setTelefono(txtTelefono.getText());
        docente.setFirma_digital(txtFirmaDigital.getText());
        docente.setEmail(txtEmail.getText());

        boolean result = false;
        DocenteDAO dao = new DocenteDAO();
        try {
            result = dao.addProfessor(docente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Alert alert;
        if (result) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro de Docente");
            alert.setHeaderText("Registro de Docente");
            alert.setContentText("Docente registrado exitosamente");
            MainStage.changeView("menu-principal-admin-view.fxml", 800, 600);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Error al registrar el docente");
        }
        alert.showAndWait();
    }

    private boolean areFieldsValid() {
        if (txtNombre.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El nombre no puede estar vacio");
            alert.showAndWait();
            return false;
        }

        if (txtApellidos.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Apellidos no puede estar vacio");
            alert.showAndWait();
            return false;
        }

        if (txtTelefono.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Telefono no puede estar vacio");
            alert.showAndWait();
            return false;
        }

        if (txtFirmaDigital.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Firma Digital no puede estar vacio");
            alert.showAndWait();
            return false;
        }

        if (txtEmail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Email no puede estar vacio");
            alert.showAndWait();
            return false;
        }

        if (txtNombre.getText().length() > 64) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El nombre no puede exceder 64 caracteres");
            alert.showAndWait();
            return false;
        }

        if (txtApellidos.getText().length() > 64) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Apellidos no puede exceder 64 caracteres");
            alert.showAndWait();
            return false;
        }

        if (txtTelefono.getText().length() > 10) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Telefono no puede exceder 10 caracteres");
            alert.showAndWait();
            return false;
        }

        if (txtFirmaDigital.getText().length() > 10) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Firma digital no puede exceder 10 caracteres");
            alert.showAndWait();
            return false;
        }

        if (txtEmail.getText().length() > 64) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Email no puede exceder 64 caracteres");
            alert.showAndWait();
            return false;
        }

        return true;
    }

    @FXML
    private void cancelar() {
        MainStage.changeView("menu-principal-admin-view.fxml", 800, 600);
    }
}
