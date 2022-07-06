module com.example.gamemechanics04_refactoring_and_minimap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.json;


    opens com.example.gamemechanics04_refactoring_and_minimap to javafx.fxml;
    exports com.example.gamemechanics04_refactoring_and_minimap;
    exports com.example.gamemechanics04_refactoring_and_minimap.gamemechanics04;
    opens com.example.gamemechanics04_refactoring_and_minimap.gamemechanics04 to javafx.fxml;
}