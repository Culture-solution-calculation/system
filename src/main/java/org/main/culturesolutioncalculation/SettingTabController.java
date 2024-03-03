package org.main.culturesolutioncalculation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;

import java.util.HashMap;
import java.util.Map;

public class SettingTabController {

    private SettingInfo settingInfo = MainController.getSettingInfo();

    @FXML
    private Tab settingTab;
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
    }

    private Map<String, Integer> getSelectedValues() {
        Map<String, Integer> selectedValues = new HashMap<>();

        // 각 라디오 버튼에서 선택된 값을 가져와서 맵에 추가
        selectedValues.put("질산칼슘 비료", getSelectedValue(group1));
        selectedValues.put("철 비료", getSelectedValue(group2));
        selectedValues.put("붕소 비료", getSelectedValue(group3));
        selectedValues.put("망간 비료", getSelectedValue(group4));
        selectedValues.put("몰리브뎀 비료", getSelectedValue(group5));
        selectedValues.put("설정 다량원소 단위", getSelectedValue(group6));
        selectedValues.put("설정 미량원소 단위", getSelectedValue(group7));
        selectedValues.put("원수 입력 단위", getSelectedValue(group9));

        String elementalYnText = getSelectedStringValue(group8);
        selectedValues.put("원수 고려 유무", "고려합니다".equals(elementalYnText) ? 1 : 0);

        return selectedValues;
    }

    private String getSelectedStringValue(ToggleGroup group) {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        return selectedRadioButton != null ? selectedRadioButton.getText() : null;
    }

    private Integer getSelectedValue(ToggleGroup group) {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedId = selectedRadioButton.getId();
            String[] parts = selectedId.split("_");
            return Integer.parseInt(parts[1]);
        } else {
            return null; // 선택된 값이 없을 경우
        }
    }

    @FXML
    public void prevButton() {
        TabPane tabPane = settingTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(settingTab);
        if (currentIndex > 0) {  // 첫 번째 탭이 아닌 경우에만
            tabPane.getSelectionModel().select(currentIndex - 1);  // 이전 탭으로 이동
        }
    }

    @FXML
    public void saveSettingInfo() {
        Map<String, Integer> selectedValues = getSelectedValues();
        settingInfo.setTotalSetting(selectedValues);

        TabPane tabPane = settingTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(settingTab);
        tabPane.getSelectionModel().select(currentIndex + 1);

    }

}