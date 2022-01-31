package com.example.w22comp11gcw4regex;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label resultLabel;

    @FXML
    private TextField phoneNumTextField;

    @FXML
    private Label replaceAllLabel;


    @FXML
    private Label formattedPhoneNum;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        phoneNumTextField.textProperty().addListener((obs, oldValue, PhoneNumber) ->{
            if(PhoneNumber.matches("\\(?[2-9][0-9][0-9]\\)?[-\\s]?[2-9]\\d{2}[-\\s]?[0-9]*{4}"))
                resultLabel.setText(String.format("%s is a valid phone number", PhoneNumber));
            else
                resultLabel.setText("Not a valid number");

            //using replaceAll() wi=
            String phoneNumJustNumbers = PhoneNumber.replaceAll("[-\\s\\(\\)\\.]", "");
            replaceAllLabel.setText(String.format("Removing special characters: '%s'", phoneNumJustNumbers));

            String areaCode = phoneNumJustNumbers.substring(0, 3);
            String cityCode = phoneNumJustNumbers.substring(3,6);
            String xxxx = phoneNumJustNumbers.substring(6);
            formattedPhoneNum.setText(String.format("Area Code : %s, City Code: %s, XXXX: %s", areaCode, cityCode, xxxx));
        });
    }
}
