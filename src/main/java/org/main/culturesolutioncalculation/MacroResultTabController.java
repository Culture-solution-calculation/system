package org.main.culturesolutioncalculation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

import java.util.Map;

public class MacroResultTabController {
    MainController mainController = new MainController();
    TableData tableData = mainController.getTableData();

    @FXML
    private Tab macroResultTab;

    @FXML
    private TableView<ObservableList<String>> tableView;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Map<String, Integer> macroSettings = tableData.getMacroSettings();
        if (macroSettings == null) {
            initTableView();
        } else {
            showResultTable(macroSettings);
        }
    }

    private void initTableView() {
        // tableView 초기화
        if (tableView == null) {
            tableView = new TableView<>();
        }

        String[] columnTitles = {"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
        String[] rowTitles = {"설정농도(mM)", "시비농도(mM)", "질산칼슘 4수염", "질산칼슘 10수염", "질산칼륨", "질산암모늄", "제1인산암모늄", "제1인산칼륨", "황산칼륨", "황산마그네슘",
                "황산암모늄", "질산", "황산", "인산", "염화칼륨", "합계"};

        // 분자식에 들어갈 값
        String[] formula = {"", "", "Ca(NO3)2·4H2O", "5[Ca(NO3)2·2H2O]NH4NO3", "KNO3", "NH4NO3", "NH4H2PO4", "KH2PO4", "K2SO4", "MgSO4·7H2O",
                "Mg(NO3)2·6H2O", "HNO3", "H2SO4", "H3PO4", "KOH", ""};

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
            row.add(formula[i]);
            for (int j = 2; j < columnTitles.length; j++) {
                row.add(""); // 빈 문자열로 초기화
            }
            data.add(row);
        }

        tableView.setItems(data);
    }


    private void showResultTable(Map<String, Integer> macroSettings) {
        initTableView();

        Integer settingElementUnit = macroSettings.get("설정 다량원소 단위").intValue();
        Integer calciumNitrateFertilizer = macroSettings.get("질산칼슘 비료").intValue();

        // 특정 행에 값 설정
        int rowIndex = 4; // 5번째 행
        data.get(rowIndex).set(6, String.valueOf(settingElementUnit)); // 설정 다량원소 단위 열
        data.get(rowIndex).set(7, String.valueOf(calciumNitrateFertilizer)); // 질산칼슘 비료 열


        tableView.setItems(data);
    }

    @FXML
    public void prevButton(ActionEvent actionEvent) {
        TabPane tabPane = macroResultTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(macroResultTab);
        tabPane.getSelectionModel().select(currentIndex - 1);  // 이전 탭으로 이동
    }

    @FXML
    public void nextButton(ActionEvent event) {
        TabPane tabPane = macroResultTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(macroResultTab);
        tabPane.getSelectionModel().select(currentIndex + 1);
    }
}
