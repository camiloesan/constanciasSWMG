module com.swmg.constanciasswmg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.swmg.constanciasswmg to javafx.fxml;
    exports com.swmg.constanciasswmg;
}