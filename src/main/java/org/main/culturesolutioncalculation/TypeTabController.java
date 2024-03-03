package org.main.culturesolutioncalculation;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class TypeTabController {

    @FXML
    private Tab typeTab;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TableView<String[]> tableView;

    @FXML
    private ListView<String> listView;

    private UserInfo userInfo = MainController.getUserInfo();

    public TypeTabController() throws IOException {
    }

    public void initialize() {
        listView.getItems().addAll("네덜란드 배양액", "야마자키 배양액");

        // 네덜란드 배양액을 기본 선택으로 설정
        listView.getSelectionModel().select("네덜란드 배양액");
        updateComboBox("네덜란드 배양액");
        updateTableView("네덜란드 배양액");

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateComboBox(newValue);
            updateTableView(newValue);

        });
    }

    @FXML
    public void prevButton() {
        TabPane tabPane = typeTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(typeTab);
        if (currentIndex > 0) {  // 첫 번째 탭이 아닌 경우에만
            tabPane.getSelectionModel().select(currentIndex - 1);  // 이전 탭으로 이동
        }
    }

    @FXML
    public void saveType() {
        TabPane tabPane = typeTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(typeTab);

        if(userInfo != null) {
            userInfo.setSelectedCulture(listView.getSelectionModel().getSelectedItem());
            userInfo.setSelectedCrop(comboBox.getValue());

            tabPane.getSelectionModel().select(currentIndex + 1);
        } else {
            System.err.println("UserInfo 객체가 초기화되지 않았습니다.");
        }
    }

    private void updateComboBox(String newValue) {
        ObservableList<String> cropList = TypeData.getCropList(newValue);
        comboBox.setItems(cropList);

    }

    private void updateTableView(String newValue) {
        ObservableList<String[]> compositionData = TypeData.getCompositionData(newValue);

        // 테이블 뷰에 컬럼 추가
        tableView.getColumns().clear();
        if (!compositionData.isEmpty()) {
            String[] headers = compositionData.remove(0); // 첫 번째 배열은 헤더
            for (int i = 0; i < headers.length; i++) {
                final int index = i;
                TableColumn<String[], String> column = new TableColumn<>(headers[i]);
                column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[index]));
                tableView.getColumns().add(column);
            }
        }

        tableView.setItems(compositionData);
    }
}
