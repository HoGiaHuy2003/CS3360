module com.mycompany.cs3360_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
//    requires fontawesomefx;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.mycompany.cs3360_project to javafx.fxml;
    exports com.mycompany.cs3360_project;
    exports com.mycompany.models;
    exports com.mycompany.entities;
}
