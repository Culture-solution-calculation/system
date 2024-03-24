package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserInfoTabController {
    @FXML
    private Tab userInfoTab;

    @FXML
    private TextField username;
    @FXML
    private TextField address;

    @FXML
    private TextField contact;
    @FXML
    private DatePicker date;
    @FXML
    private TextField scale;
    @FXML
    private TextField cropInput;
    @FXML
    private TextField cultureInput;


    public void initialize() {
        date.setValue(LocalDate.now());
    }

    @FXML
    private void signin() {
        Map<String, String> signinData = new HashMap<>();
        if (username.getText() != null && !username.getText().isEmpty() &&
                address.getText() != null && !address.getText().isEmpty()) {
            signinData.put("username", username.getText());
            signinData.put("address", address.getText());

            System.out.println(signinData);
            // 값 db에 저장 후 아이디 발급
            // saveUserData(signinData);
        } else {
            System.out.println("이름, 주소 입력 X");
        }
    }

    @FXML
    private void login() {
        Map<String, String> loginData = new HashMap<>();

        loginData.put("username", username.getText());
        loginData.put("address", address.getText());
        loginData.put("contact", contact.getText());
        loginData.put("date", date.getValue().toString());
        loginData.put("scale", scale.getText());
        loginData.put("cropInput", cropInput.getText());
        loginData.put("cultureInput", cultureInput.getText());

        System.out.println(loginData);
        // 값 db에 저장 후 분석이력 불러옴
        // saveUserData(loginData);
    }

    @FXML
    private void nextButton() {
        // 다음 탭으로 전환
        TabPane tabPane = userInfoTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(userInfoTab);
        tabPane.getSelectionModel().select(currentIndex + 1);
    }
}
