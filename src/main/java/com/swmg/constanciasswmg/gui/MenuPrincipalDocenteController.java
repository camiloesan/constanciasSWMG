package com.swmg.constanciasswmg.gui;

import javafx.fxml.FXML;

public class MenuPrincipalDocenteController {
    @FXML
    private void consultarHistorial() {
        MainStage.changeView("historial-constancias-view.fxml", 800, 600);
    }

    @FXML
    private void regresar() {
        MainStage.changeView("login-view.fxml", 800, 600);
    }

    @FXML
    private void generarConstancia() {
//        MainStage.changeView("historial-constancias-view.fxml", 800, 600);
    }
}
