package org.main.culturesolutioncalculation;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

import java.util.Map;
public class MicroTabController {
    @FXML
    private TableView<ObservableList<String>> tableView;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        if (tableView == null) {
            tableView = new TableView<>();
        }

        String[] columnTitles = {"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
        String[] rowTitles =  {"설정농도(mM)", "시비농도(mM)", "질산(액상)", "인산(액상)", "중탄산칼륨", "황산망간", "황산구리", "황산아연", "붕산", "붕사",
                "몰리브덴산암모늄", "몰리브덴산나트륨", "킬레이트 철(pH 7까지)", "킬레이트 철(pH 8까지)", "킬레이트 철(pH 전 영역)", "합계"};

        // 분자식에 들어갈 값
        String[] formula = {"", "", "HNO3", "H3PO4", "KHCO3", "MnSO4·H2O", "CuSO4·5H2O", "ZnSO4·7H2O", "H3BO3", "Na2B4O·7H2O",
                "(NH4)2Mo7O24·4H2O", "Na2MoO4·2H2O", "Fe-EDTA", "Fe-DTPA", "Fe-EDDHA", ""};

        // TableView 초기화
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

    public void updateTable(Map<String, Integer> totalSetting) {
//        if (tableView == null) {
//            initialize();
//        }
//
//        String settingElementUnit = groupInfoMap.get("설정 미량원소 단위").getValue().toString();
//        String ironFertilizer = groupInfoMap.get("철 비료").getValue().toString();
//        String boronFertilizer = groupInfoMap.get("붕소 비료").getValue().toString();
//        String manganeseFertilizer = groupInfoMap.get("망간 비료").getValue().toString();
//        String molybdenumFertilizer = groupInfoMap.get("몰리브뎀 비료").getValue().toString();
//
//        // 특정 행에 값 설정
//        int rowIndex = 4; // 5번째 행
//        data.get(rowIndex).set(3, settingElementUnit); // 설정 다량원소 단위 열
//        data.get(rowIndex).set(4, ironFertilizer); // 질산칼슘 비료 열
//        data.get(rowIndex).set(5, boronFertilizer); // 붕소 비료 열
//        data.get(rowIndex).set(6, manganeseFertilizer); // 망간 비료 열
//        data.get(rowIndex).set(7, molybdenumFertilizer); // 몰리브뎀 비료 열
//
//        tableView.setItems(null); // 기존 데이터를 제거합니다.
//        tableView.setItems(data);
//
//        Platform.runLater(() -> {
//            tableView.refresh();
//        });
//
//        printTableViewData();
    }

    public void printTableViewData() {
        ObservableList<ObservableList<String>> items = tableView.getItems();

        System.out.println("TableView 데이터:");

        for (ObservableList<String> row : items) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}

//public class MicroTabController extends TabController {
//
//    @Override
//    protected String[] getColumnTitles() {
//        return new String[]{"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
//    }
//
//    @Override
//    protected String[] getRowTitles() {
//        return new String[]{"설정농도(mM)", "시비농도(mM)", "질산(액상)", "인산(액상)", "중탄산칼륨", "황산망간", "황산구리", "황산아연", "붕산", "붕사",
//                "몰리브덴산암모늄", "몰리브덴산나트륨", "킬레이트 철(pH 7까지)", "킬레이트 철(pH 8까지)", "킬레이트 철(pH 전 영역)", "합계"};
//    }
//
//    @Override
//    public void initialize() {
//        super.initialize(); // 상위 클래스의 메서드 호출
//
//        String[] formulas = {"", "", "HNO3", "H3PO4", "KHCO3", "MnSO4·H2O", "CuSO4·5H2O", "ZnSO4·7H2O", "H3BO3", "Na2B4O·7H2O",
//                            "(NH4)2Mo7O24·4H2O", "Na2MoO4·2H2O", "Fe-EDTA", "Fe-DTPA", "Fe-EDDHA", ""};
//
//        for (int i = 0; i < rowTitles.length; i++) {
//            String[] row = new String[columnTitles.length];
//            row[0] = rowTitles[i];
//            row[1] = formulas[i];
//            tableView.getItems().add(row);
//        }
//    }
//}
