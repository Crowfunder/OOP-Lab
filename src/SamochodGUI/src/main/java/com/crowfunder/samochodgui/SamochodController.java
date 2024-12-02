package com.crowfunder.samochodgui;

import com.crowfunder.car.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class SamochodController {

    Car car = new Car(23, "aughh",  new Gearbox("grbx", 20, 100, 6, new Clutch("clutch", 10, 200)), new Engine(100, "nginx", 20, 1000), new Position(0,0));

    ArrayList<Car> cars = new ArrayList<Car>();

    @FXML
    public void onCarModelText(ActionEvent actionEvent) {
    }
    @FXML
    public void onsamochodNrRejText(ActionEvent actionEvent) {
    }
    @FXML
    public void onSamochodEnableClick(ActionEvent actionEvent) {
        this.car.startCar();
    }
    @FXML
    public void onSamochodDisableClick(ActionEvent actionEvent) {
        this.car.stopCar();
    }
    @FXML
    public void onGearboxNameText(ActionEvent actionEvent) {
    }
    @FXML
    public void onGearboxWeightText(ActionEvent actionEvent) {
    }
    @FXML
    public void onGearboxText(ActionEvent actionEvent) {
    }
    @FXML
    public void onGearboxCurrentGearText(ActionEvent actionEvent) {
    }
    @FXML
    public void onGearboxGearUpPress(ActionEvent actionEvent) throws GearboxException {
        this.car.gearbox.setCurrentGear(this.car.gearbox.getCurrentGear()+1);
    }
    @FXML
    public void onGearboxGearDownPress(ActionEvent actionEvent) throws GearboxException {
        this.car.gearbox.setCurrentGear(this.car.gearbox.getCurrentGear()-1);
    }
    @FXML
    public void onEngineNameText(ActionEvent actionEvent) {
    }
    @FXML
    public void onEnginePriceText(ActionEvent actionEvent) {
    }
    @FXML
    public void onEngineWeightText(ActionEvent actionEvent) {
    }
    @FXML
    public void onEngineRPMText(ActionEvent actionEvent) {
    }
    @FXML
    public void onEngineSpeedUpPress(ActionEvent actionEvent) {
        this.car.engine.increaseRPM(100);
    }
    @FXML
    public void onEngineSpeedDownPress(ActionEvent actionEvent) {
        this.car.engine.decreaseRPM(100);
    }
    @FXML
    public void onClutchNameText(ActionEvent actionEvent) {
    }
    @FXML
    public void onClutchPriceText(ActionEvent actionEvent) {
    }
    @FXML
    public void onClutchWeightText(ActionEvent actionEvent) {
    }
    @FXML
    public void onClutchPressPress(ActionEvent actionEvent) {
        this.car.gearbox.clutch.clutchPress();
    }
    @FXML
    public void onClutchReleasePress(ActionEvent actionEvent) {
        this.car.gearbox.clutch.clutchRelease();
    }
    @FXML
    public void onCarAddPress(ActionEvent actionEvent) {
    }
    @FXML
    public void onCarDeletePress(ActionEvent actionEvent) {

    }
    @FXML
    public void onCarChoiceCombo(ActionEvent actionEvent) {
    }
}