package org.main.culturesolutioncalculation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;

import java.io.IOException;
import java.util.Map;

public class MacroTabController {
    @FXML
    private Tab macroTab;
    @FXML
    private TableView<ObservableList<String>> tableView;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    public void initialize() {
        initTableView();
    }

    private void initTableView() {
        if (tableView == null) {
            tableView = new TableView<>();
        }
        // tableView 초기화
        String[] columnTitles = {"다량원소", "NO3", "NH4", "H2PO4", "K", "Ca", "Mg", "SO4"};
        String[] rowTitles = {"기준량", "원수성분", "처방농도"};

        // 기준량 행에 들어갈 값
        // 불러와서 데이터 잘라야 함 ..
        String[] values = {"11.5", "1", "1", "5.5", "3.25", "1.25", "1.5"};

        for (int i = 0; i < columnTitles.length; i++) {
            final int columnIndex = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(columnTitles[i]);

            column.setCellValueFactory(cellData -> {
                ObservableValue<String> cellValue = new SimpleStringProperty(cellData.getValue().get(columnIndex));
                return cellValue;
            });
            column.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
            column.setOnEditCommit(event -> {
                ObservableList<String> row = event.getRowValue();
                row.set(columnIndex, event.getNewValue());
            });

            tableView.getColumns().add(column);
        }

        for (int i = 0; i < rowTitles.length; i++) {
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(rowTitles[i]);
            if (i == 0) { // 두 번째 행에 값 추가
                for (String value : values) {
                    row.add(value);
                }
            } else {
                for (int j = 1; j < columnTitles.length; j++) {
                    row.add("");
                }
            }
            data.add(row);
        }

        tableView.setEditable(true);
        tableView.setItems(data);
    }
    @FXML
    public void prevButton(ActionEvent actionEvent) {
        TabPane tabPane = macroTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(macroTab);
        tabPane.getSelectionModel().select(currentIndex - 1);  // 이전 탭으로 이동
    }

    public void saveInput(ActionEvent event) {
        switchScene(event);
        // 테이블 저장
    }

    private void switchScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MacroResult.fxml"));
            Parent root = loader.load();

            TabPane tabPane = findTabPane(event);
            // 현재 선택된 탭을 새로운 내용으로 대체
            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
            selectedTab.setContent(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TabPane findTabPane(ActionEvent event) {
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        if (scene != null) {
            VBox root = (VBox) scene.getRoot(); // Main.fxml의 root인 VBox를 찾음
            for (Node node : root.getChildren()) {
                if (node instanceof TabPane) {
                    return (TabPane) node;
                }
            }
        }
        return null;
    }
}
