package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class UserHistoryTabController {
    @FXML
    private Tab userHistoryTab;

    @FXML
    public void prevButton() {
        TabPane tabPane = userHistoryTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(userHistoryTab);
        tabPane.getSelectionModel().select(currentIndex - 1);  // 이전 탭으로 이동
    }

    @FXML
    public void nextButton() {
        TabPane tabPane = userHistoryTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(userHistoryTab);
        tabPane.getSelectionModel().select(currentIndex + 1);

    }
}
