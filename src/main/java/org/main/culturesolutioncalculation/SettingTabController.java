package org.main.culturesolutioncalculation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import org.main.culturesolutioncalculation.DAO.ConfigurationManager;
import org.main.culturesolutioncalculation.DTO.ConfigurationDTO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SettingTabController {
    @FXML
    private RadioButton group1_1, group1_2, group1_3;
    @FXML
    private RadioButton group2_1, group2_2;
    @FXML
    private RadioButton group3_1, group3_2;
    @FXML
    private RadioButton group4_1, group4_2, group4_3;
    @FXML
    private RadioButton group5_1, group5_2;
    @FXML
    private RadioButton group6_1, group6_2;
    @FXML
    private RadioButton group7_1, group7_2;
    @FXML
    private RadioButton group8_1, group8_2;
    @FXML
    private RadioButton group9_1, group9_2;

    private ToggleGroup group1 = new ToggleGroup();
    private ToggleGroup group2 = new ToggleGroup();
    private ToggleGroup group3 = new ToggleGroup();
    private ToggleGroup group4 = new ToggleGroup();
    private ToggleGroup group5 = new ToggleGroup();
    private ToggleGroup group6 = new ToggleGroup();
    private ToggleGroup group7 = new ToggleGroup();
    private ToggleGroup group8 = new ToggleGroup();
    private ToggleGroup group9 = new ToggleGroup();

    // 각 그룹의 이름을 저장
    private Map<RadioButton, String> groupNamesMap = new HashMap<>();

    // 각 그룹의 설정 정보를 저장
    private Map<String, SettingInfo> groupInfoMap = new HashMap<>();

    @FXML
    private void initialize() {
        group1_1.setToggleGroup(group1);
        group1_2.setToggleGroup(group1);
        group1_3.setToggleGroup(group1);

        group2_1.setToggleGroup(group2);
        group2_2.setToggleGroup(group2);

        group3_1.setToggleGroup(group3);
        group3_2.setToggleGroup(group3);

        group4_1.setToggleGroup(group4);
        group4_2.setToggleGroup(group4);
        group4_3.setToggleGroup(group4);

        group5_1.setToggleGroup(group5);
        group5_2.setToggleGroup(group5);

        group6_1.setToggleGroup(group6);
        group6_2.setToggleGroup(group6);

        group7_1.setToggleGroup(group7);
        group7_2.setToggleGroup(group7);

        group8_1.setToggleGroup(group8);
        group8_2.setToggleGroup(group8);

        group9_1.setToggleGroup(group9);
        group9_2.setToggleGroup(group9);

        addRadioButtonsToGroup(group1, "설정 다량원소 단위", group1_1, group1_2, group1_3);
        addRadioButtonsToGroup(group2, "설정 미량원소 단위", group2_1, group2_2);
        addRadioButtonsToGroup(group3, "질산칼슘 비료", group3_1, group3_2);
        addRadioButtonsToGroup(group4, "철 비료", group4_1, group4_2, group4_3);
        addRadioButtonsToGroup(group5, "붕소 비료", group5_1, group5_2);
        addRadioButtonsToGroup(group6, "망간 비료", group6_1, group6_2);
        addRadioButtonsToGroup(group7, "몰리브뎀 비료", group7_1, group7_2);
        addRadioButtonsToGroup(group8, "원수 고려 유무", group8_1, group8_2);
        addRadioButtonsToGroup(group9, "원수 입력 단위", group9_1, group9_2);
    }

    // 라디오 버튼을 그룹에 추가하고 그룹 이름을 맵에 저장
    private void addRadioButtonsToGroup(ToggleGroup group, String groupName, RadioButton... radioButtons) {
        for (RadioButton radioButton : radioButtons) {
            radioButton.setToggleGroup(group);
            groupNamesMap.put(radioButton, groupName);
            radioButton.setOnAction(this::showInputDialog);
        }
    }

    private void showInputDialog(ActionEvent event) {
        RadioButton radioButton = (RadioButton) event.getSource();
        String groupName = groupNamesMap.get(radioButton);

        // 모달 다이얼로그 생성
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle(groupName);

        TextField textField = new TextField();
        dialog.getDialogPane().setContent(textField);

        dialog.getDialogPane().lookupButton(ButtonType.OK).addEventFilter(ActionEvent.ACTION, e -> {
            String radioButtonText = radioButton.getText();
            Integer input = Integer.valueOf(textField.getText());

            // 이전에 저장된 SettingInfo가 있다면 제거
            groupInfoMap.remove(groupName);

            SettingInfo settingInfo = new SettingInfo(groupName, radioButtonText, input);
            groupInfoMap.put(groupName, settingInfo);

            printGroupInfoMap();
        });

        dialog.showAndWait();
    }

    private void printGroupInfoMap() {
        for (Map.Entry<String, SettingInfo> entry : groupInfoMap.entrySet()) {
            String groupName = entry.getKey();
            SettingInfo settingInfo = entry.getValue();
            System.out.println("Group: " + groupName);
            System.out.println("RadioButton: " + settingInfo.getRadioButton());
            System.out.println("Value: " + settingInfo.getValue());
            System.out.println("----");
        }
    }
}