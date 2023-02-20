module com.example.project_8_human_vs_goblins_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project_8_human_vs_goblins_gui to javafx.fxml;
    exports com.example.project_8_human_vs_goblins_gui;
}