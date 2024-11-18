module com.crowfunder.samochodgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.crowfunder.samochodgui to javafx.fxml;
    exports com.crowfunder.samochodgui;
}