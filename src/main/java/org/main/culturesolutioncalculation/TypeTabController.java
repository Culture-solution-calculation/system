package org.main.culturesolutioncalculation;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TypeTabController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TableView<String[]> tableView;

    @FXML
    private ListView<String> listView;


    public void initialize() {
        listView.getItems().addAll("네덜란드 배양액", "야마자키 배양액", "대한민국 배양액", "기타", "수동");

        // 네덜란드 배양액을 기본 선택으로 설정
        listView.getSelectionModel().select("네덜란드 배양액");
        updateComboBox("네덜란드 배양액");
        updateTableView("네덜란드 배양액");

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateComboBox(newValue);
            updateTableView(newValue);

        });


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



//    @FXML
//    private TableView<String[]> tableView;
//
//    public void initialize() {
//        String[] columnTitles = {"비료염", "딸기(파)", "딸기(순)", "꽃상추(순)", "가지(암)", "가지(암-순)"};
//        String[] rowTitles =  {"EC(dS·m-1)", "NO3(mmol/L)", "NH4", "H2PO4", "K", "Ca", "Mg", "SO4", "Fe(µmol/L)", "Cu",
//                "B", "Mn", "Zn", "Mo"};
//
//    for (int i = 0; i < columnTitles.length; i++) {
//        final int columnIndex = i;
//        TableColumn<String[], String> column = new TableColumn<>(columnTitles[i]);
//
//        // 첫 번째 열 제외하고 편집 가능하도록 함
//        if (i == 0) {
//            column.setCellValueFactory(data -> {
//                String[] row = data.getValue();
//                return new SimpleStringProperty(row[0]);
//            });
//        } else {
//            column.setCellValueFactory(data -> {
//                String[] row = data.getValue();
//                return new SimpleStringProperty(row[columnIndex]);
//            });
//            column.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
//            column.setOnEditCommit(event -> {
//                String[] row = event.getTableView().getItems().get(event.getTablePosition().getRow());
//                row[columnIndex] = event.getNewValue();
//            });
//        }
//        tableView.getColumns().add(column);
//    }
//
//        for (int i = 0; i < 16; i++) {
//        String[] row = new String[11];
//        row[0] = rowTitles[i];
//        tableView.getItems().add(row);
//    }
//
//}
//
