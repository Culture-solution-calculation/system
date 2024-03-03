package org.main.culturesolutioncalculation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

import java.util.Map;
public class MicroResultController {
    MainController mainController = new MainController();
    TableData tableData = mainController.getTableData();

    @FXML
    private TableView<ObservableList<String>> tableView;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Map<String, Integer> microSettings = tableData.getMicroSettings();
        if (microSettings == null) {
            initTableView();
        } else {
            showResultTable(microSettings);
        }
    }

    public void initTableView() {
        // tableView 초기화
        if (tableView == null) {
            tableView = new TableView<>();
        }

        String[] columnTitles = {"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
        String[] rowTitles =  {"설정농도(mM)", "시비농도(mM)", "질산(액상)", "인산(액상)", "중탄산칼륨", "황산망간", "황산구리", "황산아연", "붕산", "붕사",
                "몰리브덴산암모늄", "몰리브덴산나트륨", "킬레이트 철(pH 7까지)", "킬레이트 철(pH 8까지)", "킬레이트 철(pH 전 영역)", "합계"};

        // 분자식에 들어갈 값
        String[] formula = {"", "", "HNO3", "H3PO4", "KHCO3", "MnSO4·H2O", "CuSO4·5H2O", "ZnSO4·7H2O", "H3BO3", "Na2B4O·7H2O",
                "(NH4)2Mo7O24·4H2O", "Na2MoO4·2H2O", "Fe-EDTA", "Fe-DTPA", "Fe-EDDHA", ""};

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

        for (int i = 0; i < 16; i++) {
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(rowTitles[i]);
            row.add(formula[i]);
            for (int j = 1; j < columnTitles.length; j++) {
                row.add(""); // 빈 문자열로 초기화
            }
            data.add(row);
        }

        tableView.setItems(data);
    }

    private void showResultTable(Map<String, Integer> microSettings) {
        initTableView();

        String settingElementUnit = String.valueOf(microSettings.get("설정 미량원소 단위").intValue());
        String ironFertilizer = String.valueOf(microSettings.get("철 비료").intValue());
        String boronFertilizer = String.valueOf(microSettings.get("붕소 비료").intValue());
        String manganeseFertilizer = String.valueOf(microSettings.get("망간 비료").intValue());
        String molybdenumFertilizer = String.valueOf(microSettings.get("몰리브뎀 비료").intValue());

        // 특정 행에 값 설정
        int rowIndex = 4; // 5번째 행
        data.get(rowIndex).set(3, settingElementUnit); // 설정 다량원소 단위 열
        data.get(rowIndex).set(4, ironFertilizer); // 질산칼슘 비료 열
        data.get(rowIndex).set(5, boronFertilizer); // 붕소 비료 열
        data.get(rowIndex).set(6, manganeseFertilizer); // 망간 비료 열
        data.get(rowIndex).set(7, molybdenumFertilizer); // 몰리브뎀 비료 열

        tableView.setItems(data);

    }

    @FXML
    public void prevButton(ActionEvent event) {
        TabPane tabPane = findTabPane(event);
        if (tabPane != null) {
            int currentIndex = tabPane.getSelectionModel().getSelectedIndex();
            tabPane.getSelectionModel().select(currentIndex - 1);
        }
    }


    @FXML
    public void nextButton(ActionEvent event) {
        TabPane tabPane = findTabPane(event);
        if (tabPane != null) {
            int currentIndex = tabPane.getSelectionModel().getSelectedIndex();
            tabPane.getSelectionModel().select(currentIndex + 1);
        }
    }

    private TabPane findTabPane(ActionEvent event) {
        Node source = (Node) event.getSource();
        if (source != null) {
            Node parent = source.getParent();
            while (parent != null && !(parent instanceof TabPane)) {
                parent = parent.getParent();
            }
            return (TabPane) parent;
        }
        return null;
    }

}