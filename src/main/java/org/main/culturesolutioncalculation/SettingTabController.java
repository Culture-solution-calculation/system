package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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


    @FXML
    public void initialize() {
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

    @FXML
    private void saveSettings() {
        Map<String, Integer> selectedValues = new HashMap<>();
        saveGroupSelection(group1, "설정_다량원소_단위", selectedValues);
        saveGroupSelection(group2, "설정_미량원소_단위", selectedValues);
        saveGroupSelection(group3, "질산칼숨_비료", selectedValues);
        saveGroupSelection(group4, "철_비료", selectedValues);
        saveGroupSelection(group5, "붕소_비료", selectedValues);
        saveGroupSelection(group6, "망간_비료", selectedValues);
        saveGroupSelection(group7, "몰리브뎀_비료", selectedValues);
        saveGroupSelection(group8, "원수_고려_유무", selectedValues);
        saveGroupSelection(group9, "원수_입력_단위", selectedValues);

        // 데이터베이스에 저장
//        DatabaseManager.insertSettings(selectedValues);
    }

    // 계산하기 위해 값 변환 필요
    // ex) 고려 여부 yn
    private void saveGroupSelection(ToggleGroup group, String groupName, Map<String, Integer> selectedValues) {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedId = selectedRadioButton.getId();
            String[] parts = selectedId.split("_");

            Integer selectedValue = Integer.parseInt(parts[1]);
            selectedValues.put(groupName, selectedValue);
            System.out.println(groupName + " 선택된 값: " + selectedValue);
        } else {
            // 선택된 값이 없을 경우 처리
            selectedValues.put(groupName, null);
            System.out.println(groupName + "에서 아무것도 선택되지 않았습니다.");
        }
    }
}
