package com.crowfunder.samochodgui;

import com.crowfunder.car.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class SamochodController {

    public TextField carModelText;
    public TextField carNrRejText;
    public TextField carWagaText;
    public TextField carSpeedText;
    public TextField gearboxNameText;
    public TextField gearboxWeightText;
    public TextField gearboxPriceText;
    public TextField gearboxCurrentGearText;
    public TextField engineNameText;
    public TextField enginePriceText;
    public TextField engineWeightText;
    public TextField engineRPMText;
    public TextField clutchNameText;
    public TextField clutchPriceText;
    public TextField clutchWeightText;
    public TextField clutchStateText;
    public ComboBox carChoiceCombo;
    public ImageView carImageView;

    private Car car;

    ArrayList<Car> cars = new ArrayList<Car>();

    public void addCarToList(Car car) {
        this.cars.add(car);
        Refresh();
    }

    @FXML
    public void initialize() {
        System.out.println("HelloController initialized");
        Image carImage = new Image(getClass().getResource("images/car.png").toExternalForm());
        carImageView.setImage(carImage);
        carImageView.setFitWidth(60);
        carImageView.setFitHeight(40);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);
        Engine engine = new Engine(2600, "Papanginx", 400.0F, 3000.0F);
        Clutch clutch = new Clutch("Papaclutch", 20.0F, 900.0F);
        Gearbox gearbox = new Gearbox("Papabox", 700.0F, 200.0F, 6, clutch);
        Car defcar = new Car(2137, "Papamobile", gearbox, engine);
        cars.add(defcar);
        car = defcar;
        Refresh();
    }

    public void Refresh() {
        carModelText.setText(this.car.getModelName());
        carNrRejText.setText(Integer.toString(this.car.getPlateNumber()));
        carWagaText.setText(Float.toString(this.car.getWeight()));
        carSpeedText.setText(Double.toString(this.car.getCurrentSpeed()));
        gearboxNameText.setText(this.car.gearbox.getName());
        gearboxWeightText.setText(Float.toString(this.car.getWeight()));
        gearboxPriceText.setText(Float.toString(this.car.gearbox.getPrice()));
        gearboxCurrentGearText.setText(Float.toString(this.car.gearbox.getCurrentGear()));
        engineNameText.setText(this.car.engine.getName());
        enginePriceText.setText(Float.toString(this.car.engine.getPrice()));
        engineWeightText.setText(Float.toString(this.car.engine.getWeight()));
        engineRPMText.setText(Float.toString(this.car.engine.getRpm()));
        clutchNameText.setText(this.car.gearbox.clutch.getName());
        clutchPriceText.setText(Float.toString(this.car.gearbox.clutch.getPrice()));
        clutchWeightText.setText(Float.toString(this.car.gearbox.clutch.getWeight()));
        clutchStateText.setText(this.car.gearbox.clutch.getClutchState());
        carChoiceCombo.setItems(FXCollections.observableArrayList(cars));
    }

    @FXML
    public void onCarModelText(ActionEvent actionEvent) {
    }
    @FXML
    public void oncarNrRejText(ActionEvent actionEvent) {
    }
    @FXML
    public void oncarEnableClick(ActionEvent actionEvent) {
        this.car.startCar();
        Refresh();
    }
    @FXML
    public void oncarDisableClick(ActionEvent actionEvent) {
        this.car.stopCar();
        Refresh();
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
        Refresh();
    }
    @FXML
    public void onGearboxGearDownPress(ActionEvent actionEvent) throws GearboxException {
        this.car.gearbox.setCurrentGear(this.car.gearbox.getCurrentGear()-1);
        Refresh();
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
        Refresh();
    }
    @FXML
    public void onEngineSpeedDownPress(ActionEvent actionEvent) {
        this.car.engine.decreaseRPM(100);
        Refresh();
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
        Refresh();
    }
    @FXML
    public void onClutchReleasePress(ActionEvent actionEvent) {
        this.car.gearbox.clutch.clutchRelease();
        Refresh();
    }
    @FXML
    public void onCarAddPress(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Dodaj nowy samochód");
        DodajSamochodController nk = loader.getController();
        nk.setMainController(this);
        stage.show();
    }
    @FXML
    public void onCarDeletePress(ActionEvent actionEvent) {

    }
    @FXML
    public void onCarChoiceCombo(ActionEvent actionEvent) {
        car = (Car) carChoiceCombo.getValue();
        Refresh();
    }
}