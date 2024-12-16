package com.crowfunder.samochodgui;

import com.crowfunder.car.Car;
import com.crowfunder.car.Clutch;
import com.crowfunder.car.Engine;
import com.crowfunder.car.Gearbox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajSamochodController {
    @FXML
    private TextField carModelText;
    @FXML
    private TextField registrationTextField;
    @FXML
    private TextField carMaxSpeedText;
    @FXML
    private TextField rpmTextField;

    @FXML
    private Button createButton;
    @FXML
    private Button cancelButton;

    private SamochodController MainController;

    public void onCreatePressed() {
        String model = carModelText.getText();
        int registration;
        int rpm;
        try {
            registration = Integer.parseInt(registrationTextField.getText());
            rpm = Integer.parseInt(rpmTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }
        Engine engine = new Engine(rpm, "NginX", 500.0F, 2000.0F);
        Clutch clutch = new Clutch("cltch", 100.0F, 500.0F);
        Gearbox gearbox = new Gearbox("grbx", 400.0F, 1000.0F, 6, clutch);
        Car car = new Car(registration, model, gearbox, engine);
        MainController.addCarToList(car);
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.close();
    }

    public void setMainController(SamochodController MainController) {
        this.MainController = MainController;
    }

    private void onCancelPressed() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
