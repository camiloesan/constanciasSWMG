module com.swmg.constanciasswmg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.swmg.constanciasswmg.gui to javafx.fxml;
    exports com.swmg.constanciasswmg.gui;
}