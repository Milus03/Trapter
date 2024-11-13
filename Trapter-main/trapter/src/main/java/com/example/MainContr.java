package com.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class MainContr {

    @FXML
    private TextField areaField;

    @FXML
    private TextField sideA;

    @FXML
    private TextField sideB;

    @FXML
    private TextField sideC;

    @FXML
    private TextField sideD;

    @FXML
    void handleCalculate(ActionEvent event) {
        try {
            computeArea();
        } catch (Exception e) {
            areaField.setText("Error");
            System.out.println(e);
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void showInfo(ActionEvent event) {
        Alert infoAlert = new Alert(Alert.AlertType.NONE);
        infoAlert.setContentText("Created by: Orosz Olivér Arnold, 2024-11-12, Szoft I/2/N");
        infoAlert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        infoAlert.showAndWait();
    }

    @FXML
    void handleExit(ActionEvent event) {
        System.exit(0);
    }

    public void computeArea() {
        String aString = sideA.getText();
        String bString = sideB.getText();
        String cString = sideC.getText();
        String dString = sideD.getText();

        double a = Double.parseDouble(aString);
        double b = Double.parseDouble(bString);
        double c = Double.parseDouble(cString);
        double d = Double.parseDouble(dString);

        double sumAC = a + c;
        double diffAC = 4 * (a - c);
        double factor = sumAC / diffAC;
        double calculation = (a + b - c + d) * (a - b - c + d) * (a + b - c - d) * (-a + b + c + d);
        double sqrtResult = Math.sqrt(calculation);

        Double areaResult = factor * sqrtResult;
        System.out.println(areaResult);
        areaField.setText(String.valueOf(areaResult));
    }
}
