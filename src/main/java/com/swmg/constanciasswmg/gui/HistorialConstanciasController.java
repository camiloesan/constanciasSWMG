package com.swmg.constanciasswmg.gui;

import javafx.fxml.FXML;

public class HistorialConstanciasController {
    @FXML
    private void onActionReturn() {
        MainStage.changeView("login-view.fxml", 800, 600);
    }
}
