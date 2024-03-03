package org.main.culturesolutioncalculation;

import javafx.application.Platform;
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
import javafx.util.converter.DefaultStringConverter;
import org.main.culturesolutioncalculation.model.CropNutrientStandard;
import org.main.culturesolutioncalculation.model.NutrientSolution;
import org.main.culturesolutioncalculation.service.CSVDataReader;

import java.io.IOException;
import java.util.ArrayList;

public class MicroTabController {
    MainController mainController;
    UserInfo userInfo = mainController.getUserInfo();

    @FXML
    private Tab microTab;
    @FXML
    private TableView<ObservableList<String>> tableView;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        initTableView();
    }

    public void initTableView() {
        // tableView 초기화
        String[] columnTitles = {"미량원소", "Fe", "Cu", "B", "Mn", "Zn", "Mo"};
        String[] rowTitles =  {"기준량", "원수성분", "처방농도"};

        // 기준량 행에 들어갈 값
        String[] values = new String[6];
        data.clear();

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
    public void refreshButton() {
        // tableView 초기화
        String[] columnTitles = {"미량원소", "Fe", "Cu", "B", "Mn", "Zn", "Mo"};
        String[] rowTitles =  {"기준량", "원수성분", "처방농도"};

        tableView = new TableView<>();
        data.clear();

        String[] values = getStandardValues(userInfo.getSelectedCulture(), userInfo.getSelectedCrop());

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

    private String[] getStandardValues(String culture, String crop) {
        String[] values = new String[7];

        // 선택한 배양액 이름에 해당하는 NutrientSolution 객체 가져오기
        CSVDataReader csvDataReader = new CSVDataReader();

        System.out.println(culture);
        NutrientSolution nutrientSolution = csvDataReader.readFile(culture);

        ArrayList<CropNutrientStandard> cropList = nutrientSolution.getCropList();

        CropNutrientStandard selectedCropNutrient = findCropNutrient(cropList, crop);

        if (selectedCropNutrient == null) {
            // 선택한 작물에 해당하는 정보가 없는 경우 처리
            System.out.println("Selected crop information not found.");
            return values;
        }

        // CropNutrientStandard 객체에서 각 값을 배열에 저장
        values[0] = String.valueOf(selectedCropNutrient.getFe());
        values[1] = String.valueOf(selectedCropNutrient.getCu());
        values[2] = String.valueOf(selectedCropNutrient.getB());
        values[3] = String.valueOf(selectedCropNutrient.getMn());
        values[4] = String.valueOf(selectedCropNutrient.getZn());
        values[5] = String.valueOf(selectedCropNutrient.getMo());

        return values;
    }

    private CropNutrientStandard findCropNutrient(ArrayList<CropNutrientStandard> cropList, String crop) {
        if (cropList == null) {
            return null;
        }

        for (CropNutrientStandard cropNutrientStandard : cropList) {
            if (cropNutrientStandard.getCropName().equals(crop)) {
                return cropNutrientStandard;
            }
        }
        return null; // 선택한 작물에 해당하는 정보를 찾을 수 없는 경우 null 반환
    }

    @FXML
    public void prevButton(ActionEvent actionEvent) {
        TabPane tabPane = microTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(microTab);
        tabPane.getSelectionModel().select(currentIndex - 1);  // 이전 탭으로 이동
    }

    public void saveInput(ActionEvent event) {
        switchScene(event);
        // 테이블 저장
    }

    private void switchScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MicroResult.fxml"));
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