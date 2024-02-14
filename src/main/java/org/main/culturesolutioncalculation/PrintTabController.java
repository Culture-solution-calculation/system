package org.main.culturesolutioncalculation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Map;

public class PrintTabController {

    @FXML
    private Label settingsLabel;

    public void loadSettings() {
        Map<String, String> settings = DatabaseManager.getSettings();

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : settings.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                stringBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }
        // 가져온 설정 값들을 Label에 출력
        settingsLabel.setText(stringBuilder.toString());
    }
}
