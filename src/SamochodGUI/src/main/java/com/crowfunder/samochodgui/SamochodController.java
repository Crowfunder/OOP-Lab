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

    private int selectedCar;
    private Car car;

    ArrayList<Car> cars = new ArrayList<Car>();

    public void addCarToList(Car newCar) {
        cars.add(newCar);
        carChoiceCombo.setItems(FXCollections.observableArrayList(cars));
        car = newCar;
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
        this.car = new Car(2137, "Papamobile", gearbox, engine, 213.7f);
        this.cars.add(car);
        this.carChoiceCombo.setItems(FXCollections.observableArrayList(cars));
        this.selectedCar = 0;
        this.carChoiceCombo.getSelectionModel().select(selectedCar);
        Refresh();
    }

    @FXML
    public void Refresh() {
        carModelText.setText(car.getModelName());
        carNrRejText.setText(Integer.toString(car.getPlateNumber()));
        carWagaText.setText(Float.toString(car.getWeight()));
        carSpeedText.setText(Double.toString(car.getCurrentSpeed()));
        gearboxNameText.setText(car.gearbox.getName());
        gearboxWeightText.setText(Float.toString(car.getWeight()));
        gearboxPriceText.setText(Float.toString(car.gearbox.getPrice()));
        gearboxCurrentGearText.setText(Float.toString(car.gearbox.getCurrentGear()));
        engineNameText.setText(car.engine.getName());
        enginePriceText.setText(Float.toString(car.engine.getPrice()));
        engineWeightText.setText(Float.toString(car.engine.getWeight()));
        engineRPMText.setText(Float.toString(car.engine.getRpm()));
        clutchNameText.setText(car.gearbox.clutch.getName());
        clutchPriceText.setText(Float.toString(car.gearbox.clutch.getPrice()));
        clutchWeightText.setText(Float.toString(car.gearbox.clutch.getWeight()));
        clutchStateText.setText(car.gearbox.clutch.getClutchState());
        selectedCar = cars.indexOf(car);
        if (car == null) {
            selectedCar = 0;
            car = cars.get(selectedCar);
        }
        carChoiceCombo.getSelectionModel().select(selectedCar);
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
        if (cars.size() > 1) {
            cars.remove(car);
            carChoiceCombo.setItems(FXCollections.observableArrayList(cars));
            carChoiceCombo.getSelectionModel().select(0);
            Refresh();
        }
    }
    @FXML
    public void onCarChoiceCombo(ActionEvent actionEvent) {
        car = (Car) carChoiceCombo.getValue();
        if (car == null) {
            selectedCar = 0;
            car = cars.get(selectedCar);
        } else {
            selectedCar = cars.indexOf(car);
        }
        Refresh();
    }

    @FXML
    public void onCarModelText(ActionEvent actionEvent) {
    }
    @FXML
    public void oncarNrRejText(ActionEvent actionEvent) {
    }
    @FXML
    public void oncarEnableClick(ActionEvent actionEvent) {
        car.startCar();
        Refresh();
    }
    @FXML
    public void oncarDisableClick(ActionEvent actionEvent) {
        car.stopCar();
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
        car.gearbox.setCurrentGear(car.gearbox.getCurrentGear()+1);
        Refresh();
    }
    @FXML
    public void onGearboxGearDownPress(ActionEvent actionEvent) throws GearboxException {
        car.gearbox.setCurrentGear(car.gearbox.getCurrentGear()-1);
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
        car.engine.increaseRPM(100);
        Refresh();
    }
    @FXML
    public void onEngineSpeedDownPress(ActionEvent actionEvent) {
        car.engine.decreaseRPM(100);
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
        car.gearbox.clutch.clutchPress();
        Refresh();
    }
    @FXML
    public void onClutchReleasePress(ActionEvent actionEvent) {
        car.gearbox.clutch.clutchRelease();
        Refresh();
    }

}