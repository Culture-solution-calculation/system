package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

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


    private UserInfo userInfo = MainController.getUserInfo();


    public void initialize() {
        date.setValue(LocalDate.now());
    }

    @FXML
    private void nextButton() {
        userInfo.setCustomerName(username.getText().toString());
        userInfo.setAddress(address.getText().toString());
        userInfo.setContact(contact.getText().toString());
        userInfo.setProcessingDate(date.getValue());
        userInfo.setScale(scale.getText().toString());
        userInfo.setScale(cropInput.getText().toString());
        userInfo.setScale(cultureInput.getText().toString());

        TabPane tabPane = userInfoTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(userInfoTab);
        tabPane.getSelectionModel().select(currentIndex + 1);

        // userInfo 값 db에 저장
    }
}
