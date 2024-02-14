module org.main.culturesolutioncalculation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.main.culturesolutioncalculation to javafx.fxml;
    exports org.main.culturesolutioncalculation;
}