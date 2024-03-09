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
import org.main.culturesolutioncalculation.model.CropNutrientStandard;
import org.main.culturesolutioncalculation.model.NutrientSolution;
import org.main.culturesolutioncalculation.service.CSVDataReader;

import java.io.IOException;
import java.util.ArrayList;

public class MacroTabController {

    MainController mainController;
    UserInfo userInfo = mainController.getUserInfo();

    @FXML
    private Tab macroTab;
    @FXML
    private TableView<ObservableList<String>> tableView;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    private ObservableList<String> waterData = FXCollections.observableArrayList("0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    public void initialize() {
        initTableView();
    }

    public void initTableView() {
        data.clear();

        // tableView 초기화
        String[] columnTitles = {"다량원소", "NO3", "NH4", "H2PO4", "K", "Ca", "Mg", "SO4", "HCO3", "전기전도도(EC)", "pH"};
        String[] rowTitles = {"기준량", "원수성분", "처방농도"};

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
            if (i == 1) {
                for (String water : waterData) {
                    row.add(water);
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

        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                tableView.edit(tableView.getSelectionModel().getSelectedIndex(), tableView.getFocusModel().getFocusedCell().getTableColumn());
            }
        });
    }

    @FXML
    public void refreshButton(ActionEvent actionEvent) {
        data.clear();

        // tableView 초기화
        String[] columnTitles = {"다량원소", "NO3", "NH4", "H2PO4", "K", "Ca", "Mg", "SO4", "HCO3", "전기전도도(EC)", "pH"};
        String[] rowTitles = {"기준량", "원수성분", "처방농도"};

        tableView = new TableView<>();

        // 기준량
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
            if (i == 0) { // 기준량 행에 값 추가
                for (String value : values) {
                    row.add(value);
                }
            } else if (i == 1) { // 원수성분 행에 값 추가
                for (String water : waterData) {
                    row.add(water);
                }
            } else if (i == 2) {
                for (int k = 1; k < columnTitles.length; k++) {
                    double standardValue = Double.parseDouble(values[k - 1]);
                    double waterValue = Double.parseDouble(waterData.get(k - 1));
                    double prescription = standardValue - waterValue;
                    row.add(String.valueOf(prescription));
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
        String[] values = new String[10];

        // 선택한 배양액 이름에 해당하는 NutrientSolution 객체 가져오기
        CSVDataReader csvDataReader = new CSVDataReader();

        System.out.println(culture);
        NutrientSolution nutrientSolution = csvDataReader.readFile(culture);

        ArrayList<CropNutrientStandard> cropList = nutrientSolution.getCropList();

        CropNutrientStandard selectedCropNutrient = findCropNutrient(cropList, crop);

        if (selectedCropNutrient == null) {
            System.out.println("재배작물 선택 안 되어 있음");
            return values;
        }

        // CropNutrientStandard 객체에서 각 값을 배열에 저장
        values[0] = String.valueOf(selectedCropNutrient.getNO3());
        values[1] = String.valueOf(selectedCropNutrient.getNH4());
        values[2] = String.valueOf(selectedCropNutrient.getH2PO4());
        values[3] = String.valueOf(selectedCropNutrient.getK());
        values[4] = String.valueOf(selectedCropNutrient.getCa());
        values[5] = String.valueOf(selectedCropNutrient.getMg());
        values[6] = String.valueOf(selectedCropNutrient.getSO4());
        // HCO3, EC, pH
        values[7] = "0";
        values[8] = "0";
        values[9] = "0";

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
    public void saveData(ActionEvent actionEvent) {
        ObservableList<String> originalData = tableView.getItems().get(1);
        waterData = FXCollections.observableArrayList(originalData.subList(1, originalData.size()));
        // 테이블 저장 -> 자동계산
    }


    @FXML
    public void prevButton(ActionEvent actionEvent) {
        TabPane tabPane = macroTab.getTabPane();
        int currentIndex = tabPane.getTabs().indexOf(macroTab);
        tabPane.getSelectionModel().select(currentIndex - 1);  // 이전 탭으로 이동
    }

    public void nextButton(ActionEvent event) throws IOException {
        switchScene(event);
    }

    private void switchScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MacroResult.fxml"));
            Parent root = loader.load();

            TabPane tabPane = findTabPane(event);
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