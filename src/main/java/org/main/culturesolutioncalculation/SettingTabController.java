package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
    private void saveSettings() throws SQLException {
        Map<String, Integer> selectedValues = getSelectedValues();

        ConfigurationManager configManager = new ConfigurationManager();
        ConfigurationDTO configurationDTO = mapToDTO(selectedValues);

        configManager.setConfiguration(configurationDTO);
    }

    private Map<String, Integer> getSelectedValues() {
        Map<String, Integer> selectedValues = new HashMap<>();

        // 각 라디오 버튼에서 선택된 값을 가져와서 맵에 추가
        selectedValues.put("multiUnitSeq", getSelectedValue(group1));
        selectedValues.put("traceUnitSeq", getSelectedValue(group2));
        selectedValues.put("cnFertilizerSeq", getSelectedValue(group3));
        selectedValues.put("feFertilizerSeq", getSelectedValue(group4));
        selectedValues.put("bFertilizerSeq", getSelectedValue(group5));
        selectedValues.put("mnFertilizerSeq", getSelectedValue(group6));
        selectedValues.put("moFertilizerSeq", getSelectedValue(group7));
        selectedValues.put("inputUnitSeq", getSelectedValue(group8));

        String elementalYnText = getSelectedStringValue(group9);
        selectedValues.put("elementalYn", "고려합니다".equals(elementalYnText) ? 1 : 0);

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

    private ConfigurationDTO mapToDTO(Map<String, Integer> selectedValues) {
        // elementalYn 값 String으로 변경
        return new ConfigurationDTO(
                selectedValues.get("multiUnitSeq"),
                selectedValues.get("traceUnitSeq"),
                selectedValues.get("cnFertilizerSeq"),
                selectedValues.get("feFertilizerSeq"),
                selectedValues.get("bFertilizerSeq"),
                selectedValues.get("mnFertilizerSeq"),
                selectedValues.get("moFertilizerSeq"),
                selectedValues.get("inputUnitSeq"),
                selectedValues.get("elementalYn").toString()
        );
    }

}
