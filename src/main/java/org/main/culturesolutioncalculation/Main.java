package org.main.culturesolutioncalculation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            initStage(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public static void reload(Stage stage) {
        try {
            initStage(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initStage(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(root, 1000, 750);

        stage.setTitle("배양액 계산 프로그램");
        stage.setMinWidth(1000);
        stage.setMinHeight(750);

        stage.setScene(scene);
        stage.show();
    }
}