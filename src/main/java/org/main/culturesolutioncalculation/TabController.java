package org.main.culturesolutioncalculation;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

// enter 키 없이 다른 셀 눌러서 반영 가능하도록
public abstract class TabController {
    @FXML
    protected TableView<String[]> tableView;

    protected String[] columnTitles;
    protected String[] rowTitles;

    protected abstract String[] getColumnTitles();

    protected abstract String[] getRowTitles();

    public void initialize() {
        columnTitles = getColumnTitles();
        rowTitles = getRowTitles();

        for (int i = 0; i < columnTitles.length; i++) {
            final int columnIndex = i;
            TableColumn<String[], String> column = new TableColumn<>(columnTitles[i]);

            // 첫 번째 열 제외하고 편집 가능하도록 함
            if (i == 0) {
                column.setCellValueFactory(data -> {
                    String[] row = data.getValue();
                    return new SimpleStringProperty(row[0]);
                });
            } else {
                column.setCellValueFactory(data -> {
                    String[] row = data.getValue();
                    return new SimpleStringProperty(row[columnIndex]);
                });
                column.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
                column.setOnEditCommit(event -> {
                    String[] row = event.getTableView().getItems().get(event.getTablePosition().getRow());
                    row[columnIndex] = event.getNewValue();
                });
            }
            tableView.getColumns().add(column);
        }

        tableView.setEditable(true);
        tableView.setSortPolicy(null);

        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                tableView.edit(tableView.getSelectionModel().getSelectedIndex(), tableView.getFocusModel().getFocusedCell().getTableColumn());
            }
        });
    }

    // 합계 버튼, 계산 따로 빼기
    // (열 이름, 값) 저장
    @FXML
    protected abstract void saveData();
}
