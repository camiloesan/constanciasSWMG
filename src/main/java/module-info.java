module com.swmg.constanciasswmg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires mysql.connector.j;

    opens com.swmg.constanciasswmg.gui to javafx.fxml;
    opens com.swmg.constanciasswmg.pojo to javafx.base;
    exports com.swmg.constanciasswmg.gui;
}