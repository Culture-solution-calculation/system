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

    private UserInfo userInfo = MainController.getUserInfo();


    public void initialize() {
        date.setValue(LocalDate.now());
    }

    @FXML
    private void saveUserInfo() {
        if(userInfo != null) {
            userInfo.setCustomerName(username.getText().toString());
            userInfo.setAddress(address.getText().toString());
            userInfo.setContact(contact.getText().toString());
            userInfo.setProcessingDate(date.getValue());
            userInfo.setScale(scale.getText().toString());

        } else {
            System.err.println("UserInfo 객체가 초기화되지 않았습니다.");
        }
        TabPane tabPane = userInfoTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(userInfoTab);
        tabPane.getSelectionModel().select(currentIndex + 1);
    }
}
