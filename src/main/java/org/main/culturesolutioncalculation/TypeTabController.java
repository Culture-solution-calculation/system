package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TypeTabController extends TabController{

    @FXML
    private CustomTableView<String[]> tableView;

    @FXML
    private ComboBox<String> comboBox;

    @Override
    protected String[] getColumnTitles() {
        return new String[]{"비료염", "딸기(파)", "딸기(순)", "꽃상추(순)", "가지(암)", "가지(암-순)"};
    }

    @Override
    protected String[] getRowTitles() {
        return new String[]{"EC(dS·m-1)", "NO3(mmol/L)", "NH4", "H2PO4", "K", "Ca", "Mg", "SO4", "Fe(µmol/L)", "Cu",
                "B", "Mn", "Zn", "Mo"};
    }

    @Override
    public void initialize() {
        super.initialize();

        for (int i = 0; i < rowTitles.length; i++) {
            String[] row = new String[columnTitles.length];
            row[0] = rowTitles[i];
            tableView.getItems().add(row);
        }

        // ComboBox 이벤트 리스너
        comboBox.setOnAction(event -> {
            String selectedCrop = comboBox.getValue();

            if (selectedCrop != null && !selectedCrop.isEmpty()) {
                addColumnForCrop(selectedCrop);
            }
        });

    }
    @FXML
    protected void saveData() {
        // 데이터 저장
    }

    private void addColumnForCrop(String crop) {
        TableColumn<String[], String> column = new TableColumn<>(crop);
        tableView.getColumns().add(column);
    }

    @FXML
    private void deleteColumnForCrop() {
        TableColumn<?, ?> selectedColumn = tableView.getSelectedColumn();
        if (selectedColumn != null) {
            if (tableView.getColumns().indexOf(selectedColumn) != 0) {
                tableView.getColumns().remove(selectedColumn);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("알림");
                alert.setHeaderText(null);
                alert.setContentText("첫 번째 열은 삭제할 수 없습니다.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("알림");
            alert.setHeaderText(null);
            alert.setContentText("삭제할 컬럼을 선택하세요.");
            alert.showAndWait();
        }
    }

}
