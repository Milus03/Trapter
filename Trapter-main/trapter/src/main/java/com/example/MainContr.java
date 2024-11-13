package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class ControllerMain {

    @FXML
    private TextField resultField;

    @FXML
    private TextField inputA;

    @FXML
    private TextField inputB;

    @FXML
    private TextField inputC;

    @FXML
    private TextField inputD;

    @FXML
    void onCalculate(ActionEvent event) {
        try {
            calculateResult();
        } catch (Exception e) {
            resultField.setText("Calculation Error");
            System.out.println(e);
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void displayInfo(ActionEvent event) {
        Alert infoPopup = new Alert(Alert.AlertType.NONE);
        infoPopup.setContentText("Készitő: Reiter Milán, 2024-11-13, Szoftver I/2/N");
        infoPopup.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        infoPopup.showAndWait();
    }

    @FXML
    void onExit(ActionEvent event) {
        System.exit(0);
    }

    public void calculateResult() {
        String textA = inputA.getText();
        String textB = inputB.getText();
        String textC = inputC.getText();
        String textD = inputD.getText();

        double valA = Double.parseDouble(textA);
        double valB = Double.parseDouble(textB);
        double valC = Double.parseDouble(textC);
        double valD = Double.parseDouble(textD);

        double sumAC = valA + valC;
        double diffAC = 4 * (valA - valC);
        double multiplier = sumAC / diffAC;
        double complexCalculation = (valA + valB - valC + valD) * (valA - valB - valC + valD) *
                                     (valA + valB - valC - valD) * (-valA + valB + valC + valD);
        double squareRoot = Math.sqrt(complexCalculation);

        Double finalResult = multiplier * squareRoot;
        System.out.println(finalResult);
        resultField.setText(String.valueOf(finalResult));
    }
}

