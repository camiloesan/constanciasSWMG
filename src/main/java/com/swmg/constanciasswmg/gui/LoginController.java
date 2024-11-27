package com.swmg.constanciasswmg.gui;

import com.swmg.constanciasswmg.dao.implementations.CuentaDAO;
import com.swmg.constanciasswmg.utils.SessionDetails;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPassword;

    @FXML
    private void onActionButtonLogin() {
        String email = tfEmail.getText();
        String password = tfPassword.getText();
        if (isLoginValid(email, password)) {
            CuentaDAO cuentaDAO = new CuentaDAO();

            int result;
            try {
                result = cuentaDAO.getAccountTypeByEmail(email);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (result == 1) {
                SessionDetails.userType = "administrativo";
                MainStage.changeView("menu-principal-admin-view.fxml", 800, 600);
            } else if (result == 2) {
                try {
                    SessionDetails.userId = cuentaDAO.getDocenteIdByEmail(email);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                SessionDetails.userType = "docente";
                MainStage.changeView("menu-principal-docente-view.fxml", 800, 600);
            } else {
                SessionDetails.userType = "administrativo";
                MainStage.changeView("menu-principal-admin-view.fxml", 800, 600);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Datos incorrectos");
            alert.showAndWait();
        }
    }

    private boolean isLoginValid(String email, String password) {
        CuentaDAO cuentaDAO = new CuentaDAO();

        boolean result;
        try {
            result = cuentaDAO.isLoginValid(email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
