package com.swmg.constanciasswmg.gui;

import javafx.fxml.FXML;

public class MenuPrincipalAdminController {
    @FXML
    private void registrarDocente() {
        MainStage.changeView("registrar-docentes-view.fxml", 800, 600);
    }

    @FXML
    private void consultarDocentes() {
        MainStage.changeView("consultar-docentes-view.fxml", 800, 600);
    }

    @FXML
    private void regresar() {
        MainStage.changeView("login-view.fxml", 800, 600);
    }
}
