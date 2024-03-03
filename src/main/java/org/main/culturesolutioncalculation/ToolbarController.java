package org.main.culturesolutioncalculation;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ToolbarController {
    @FXML
    private Button exitButton;
    @FXML
    private Button initButton;

    private SettingInfo settingInfo = new SettingInfo();

    MainController mainController = new MainController();
    TableData tableData = mainController.getTableData();


    @FXML
    public void onEditButtonClick(ActionEvent event) {
    }

    @FXML
    protected void onExitButtonClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("종료");
        alert.setHeaderText(null);
        alert.setContentText("프로그램을 종료하시겠습니까?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        }
    }

    // 현재 탭만 초기화 ..?
    @FXML
    public void onInitButtonClick() {
        Stage stage = (Stage) initButton.getScene().getWindow();
        Main.reload(stage);
        // 테이블도 초기화
    }

//    private void onPrintButtonClick(ActionEvent event) {
//        // 데이터베이스에서 데이터를 가져옵니다.
//        List<String> printData = DatabaseManager.getPrintData();
//
//        // 가져온 데이터를 텍스트 노드로 만듭니다.
//        StringBuilder textContent = new StringBuilder();
//        for (String data : printData) {
//            textContent.append(data).append("\n");
//        }
//        Text textNode = new Text(textContent.toString());
//        textNode.setFont(Font.font("Arial", 12)); // 폰트 설정 (원하는 대로 변경 가능)
//
//        // 프린터 작업을 생성합니다.
//        PrinterJob printerJob = PrinterJob.createPrinterJob();
//        if (printerJob != null && printerJob.showPrintDialog(null)) {
//            // 노드를 프린트합니다.
//            boolean success = printerJob.printPage(textNode);
//            if (success) {
//                printerJob.endJob();
//                System.out.println("프린트 완료");
//            }
//            else {
//                System.out.println("프린트 X");
//            }
//        }
//    }

    @FXML
    private void onPrintButtonClick(ActionEvent event) {
//        Pane printPane = new Pane();
//
//        // 데이터베이스에서 데이터를 가져옵니다.
//        List<String> printData = DatabaseManager.getPrintData();
//
//        // 가져온 데이터를 팬에 추가합니다.
//        double yOffset = 20.0; // 데이터 간의 세로 간격
//        for (String data : printData) {
//            Text textNode = new Text(data);
//            textNode.setLayoutY(yOffset); // 세로 위치 설정
//            printPane.getChildren().add(textNode);
//            yOffset += 20.0; // 다음 데이터와의 간격 설정
//        }

//        PrinterJob job = PrinterJob.createPrinterJob();
//        if (job != null && job.showPrintDialog(printPane.getScene().getWindow())) {
//            // 노드를 프린트합니다.
//            boolean success = job.printPage(printPane);
//            if (success) {
//                job.endJob();
//                System.out.println("프린트 완료");
//            } else {
//                System.out.println("프린트 실패");
//            }
//        } else {
//            System.out.println("프린터 작업 생성 실패");
//        }
//    }
//        WritableImage image = printPane.snapshot(new SnapshotParameters(), null);
//        ImageView imageView = new ImageView(image);
//        ScrollPane scrollPane = new ScrollPane(imageView);
//
//        Stage previewStage = new Stage();
//        Scene scene = new Scene(scrollPane, 900, 600);
//        previewStage.setScene(scene);
//        previewStage.setTitle("프린트 미리보기");
//        previewStage.show();

    }

    @FXML
    public void onCalcButtonClick(ActionEvent actionEvent) {
        // 설정 정보 가져오기
        Map<String, Integer> totalSetting = settingInfo.getTotalSetting();

        // 다량원소 탭 설정 정보
        Map<String, Integer> macroSettings = new HashMap<>();
        macroSettings.put("설정 다량원소 단위", totalSetting.get("설정 다량원소 단위"));
        macroSettings.put("질산칼슘 비료", totalSetting.get("질산칼슘 비료"));
        macroSettings.put("원수 고려 유무", totalSetting.get("원수 고려 유무"));
        macroSettings.put("원수 입력 단위", totalSetting.get("원수 입력 단위"));

        // 미량원소 탭 설정 정보
        Map<String, Integer> microSettings = new HashMap<>();
        microSettings.put("설정 미량원소 단위", totalSetting.get("설정 미량원소 단위"));
        microSettings.put("철 비료", totalSetting.get("철 비료"));
        microSettings.put("붕소 비료", totalSetting.get("붕소 비료"));
        microSettings.put("망간 비료", totalSetting.get("망간 비료"));
        microSettings.put("몰리브뎀 비료", totalSetting.get("몰리브뎀 비료"));
        microSettings.put("원수 고려 유무", totalSetting.get("원수 고려 유무"));
        microSettings.put("원수 입력 단위", totalSetting.get("원수 입력 단위"));

        // 계산식 설정

        tableData.setMacroSettings(macroSettings);
        tableData.setMicroSettings(microSettings);
    }

}