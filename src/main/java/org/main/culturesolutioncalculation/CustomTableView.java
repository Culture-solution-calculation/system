package org.main.culturesolutioncalculation;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;

public class CustomTableView<S> extends TableView<S> {

    public CustomTableView() {
        setSortPolicy(null);
        setEditable(true);
    }

    // 선택된 컬럼을 반환하는 메서드
    public TableColumn<S, ?> getSelectedColumn() {
        ObservableList<TablePosition> selectedCells = getSelectionModel().getSelectedCells();
        if (!selectedCells.isEmpty()) {
            TablePosition<S, ?> selectedCell = selectedCells.get(0);
            int columnIndex = selectedCell.getColumn();
            return getColumns().get(columnIndex);
        } else {
            return null;
        }
    }

}