module com.masanz.marraz.marraz {
    requires log4j;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.masanz.marraz.controller to javafx.fxml;
    opens com.masanz.marraz.app to javafx.fxml;
    exports com.masanz.marraz;
    exports com.masanz.marraz.app;
    exports com.masanz.marraz.controller;
}