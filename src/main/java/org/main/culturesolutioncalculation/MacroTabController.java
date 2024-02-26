package org.main.culturesolutioncalculation;

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

public class MacroTabController {
    @FXML
    private TableView<ObservableList<String>> tableView;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        if (tableView == null) {
            tableView = new TableView<>();
        }

        String[] columnTitles = {"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
        String[] rowTitles = {"설정농도(mM)", "시비농도(mM)", "질산칼슘", "질산칼륨", "제1인산암모늄", "제1인산칼륨", "황산칼륨", "황산마그네슘", "질산마그네슘", "질산암모늄",
                "질산", "황산", "연산", "수산화칼륨", "초안", "유안", "염안", "황산칼리", "염화칼리", "염화칼슘", "합계"};

        // 분자식에 들어갈 값
        String[] formula = {"", "", "Ca(NO3)2-4H2O", "KNO3", "NH4H2PO4", "KH2PO4", "K2SO4", "MgSO4-7H2O", "Mg(NO3)2-6H2O",
                "NH4NO3", "HNO3", "H2SO4", "H3PO4", "KOH", "NH4NO3", "(NH4)2SO4", "NH4Cl", "K2SO4", "KCL",
                "CaCl2·2H2O", ""};

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

    public void updateTable(Map<String, SettingInfo> groupInfoMap) {
        if (tableView == null) {
            tableView = new TableView<>();
        }

        String[] columnTitles = {"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
        String[] rowTitles = {"설정농도(mM)", "시비농도(mM)", "질산칼슘", "질산칼륨", "제1인산암모늄", "제1인산칼륨", "황산칼륨", "황산마그네슘", "질산마그네슘", "질산암모늄",
                "질산", "황산", "연산", "수산화칼륨", "초안", "유안", "염안", "황산칼리", "염화칼리", "염화칼슘", "합계"};

        // 분자식에 들어갈 값
        String[] formula = {"", "", "Ca(NO3)2-4H2O", "KNO3", "NH4H2PO4", "KH2PO4", "K2SO4", "MgSO4-7H2O", "Mg(NO3)2-6H2O",
                "NH4NO3", "HNO3", "H2SO4", "H3PO4", "KOH", "NH4NO3", "(NH4)2SO4", "NH4Cl", "K2SO4", "KCL",
                "CaCl2·2H2O", ""};

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

        for (int i = 0; i < 21; i++) {
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(rowTitles[i]);
            row.add(formula[i]);
            for (int j = 1; j < columnTitles.length; j++) {
                row.add(""); // 빈 문자열로 초기화
            }
            data.add(row);
        }

        tableView.setItems(data);

        String settingElementUnit = groupInfoMap.get("설정 다량원소 단위").getValue().toString();
        String calciumNitrateFertilizer = groupInfoMap.get("질산칼슘 비료").getValue().toString();

        // 특정 행에 값 설정
        int rowIndex = 4; // 5번째 행
        data.get(rowIndex).set(6, settingElementUnit); // 설정 다량원소 단위 열
        data.get(rowIndex).set(7, calciumNitrateFertilizer); // 질산칼슘 비료 열

        tableView.setItems(data);

        // 출력
        printTableViewData();
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

//public class MacroTabController extends TabController {
//
//    @Override
//    protected String[] getColumnTitles() {
//        return new String[]{"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
//    }
//
//    @Override
//    protected String[] getRowTitles() {
//        return new String[]{"설정농도(mM)", "시비농도(mM)", "질산칼슘", "질산칼륨", "제1인산암모늄", "제1인산칼륨", "황산칼륨", "황산마그네슘", "질산마그네슘", "질산암모늄",
//                "질산", "황산", "연산", "수산화칼륨", "초안", "유안", "염안", "황산칼리", "염화칼리", "염화칼슘", "합계"};
//    }
//
//    @Override
//    public void initialize() {
//        super.initialize(); // 상위 클래스의 메서드 호출
//
//        String[] formulas = {"", "", "Ca(NO3)2-4H2O", "KNO3", "NH4H2PO4", "KH2PO4", "K2SO4", "MgSO4-7H2O", "Mg(NO3)2-6H2O",
//                "NH4NO3", "HNO3", "H2SO4", "H3PO4", "KOH", "NH4NO3", "(NH4)2SO4", "NH4Cl", "K2SO4", "KCL",
//                "CaCl2·2H2O", ""};
//
//        for (int i = 0; i < rowTitles.length; i++) {
//            String[] row = new String[columnTitles.length];
//            row[0] = rowTitles[i];
//            row[1] = formulas[i];
//            tableView.getItems().add(row);
//        }
//    }
//}

