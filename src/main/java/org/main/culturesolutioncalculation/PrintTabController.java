package org.main.culturesolutioncalculation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.main.culturesolutioncalculation.DAO.ConfigurationManager;
import org.main.culturesolutioncalculation.DTO.ConfigurationDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class PrintTabController {
    MainController mainController = new MainController();
    UserInfo userInfo = mainController.getUserInfo();

    @FXML
    private Label settingsLabel;

    @FXML
    private Label customerNameLabel;
    @FXML
    private Label processingDateLabel;
    @FXML
    private Label sampleNumberLabel;
    @FXML
    private Label selectedCultureLabel;
    @FXML
    private Label selectedCropLabel;

    @FXML
    public void load() {
        try {
            customerNameLabel.setText(userInfo.getCustomerName());
            processingDateLabel.setText(userInfo.getProcessingDate().toString());
            sampleNumberLabel.setText(userInfo.getSampleNumber());
            selectedCultureLabel.setText(userInfo.getSelectedCulture());
            selectedCropLabel.setText(userInfo.getSelectedCrop());
        } catch (NullPointerException e) {
            System.out.println("값이 입력되지 않았습니다.");
        }
    }

    public void loadSettings() throws SQLException {
//        ConfigurationManager configManager = new ConfigurationManager();
//        try {
//            ConfigurationDTO configurationDTO = configManager.getConfiguration();
//
//            String elementalYnLabel = configurationDTO.getElementalYn().equals("1") ? "Y" : "N";
//
//            // ConfigurationDTO에서 설정 값을 추출하여 Label에 출력
//            String settingsText = "Multi Unit Sequence: " + configurationDTO.getMultiUnitSeq() + "\n" +
//                    "Trace Unit Sequence: " + configurationDTO.getTraceUnitSeq() + "\n" +
//                    "CN Fertilizer Sequence: " + configurationDTO.getCnFertilizerSeq() + "\n" +
//                    "Fe Fertilizer Sequence: " + configurationDTO.getFeFertilizerSeq() + "\n" +
//                    "B Fertilizer Sequence: " + configurationDTO.getBFertilizerSeq() + "\n" +
//                    "Mn Fertilizer Sequence: " + configurationDTO.getMnFertilizerSeq() + "\n" +
//                    "Mo Fertilizer Sequence: " + configurationDTO.getMoFertilizerSeq() + "\n" +
//                    "Input Unit Sequence: " + configurationDTO.getInputUnitSeq() + "\n" +
//                    "Elemental YN: " + elementalYnLabel;
//
//            // 설정 값을 Label에 출력
//            settingsLabel.setText(settingsText);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}

