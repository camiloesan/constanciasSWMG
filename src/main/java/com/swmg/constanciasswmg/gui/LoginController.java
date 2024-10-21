package com.swmg.constanciasswmg.gui;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField textFieldUser;
    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private void onActionButtonLogin() {

        MainStage.changeView("historial-constancias-view.fxml", 800, 600);
    }
}
