module com.example.testeintelij {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.jfoenix;
    requires org.slf4j;
    requires java.sql;

    opens com.example.testeintelij to javafx.fxml;
    exports com.example.testeintelij;

    exports com.example.testeintelij.Visao to javafx.fxml;
    opens com.example.testeintelij.Visao to javafx.base;

    exports com.example.testeintelij.Dominio to javafx.fxml;
    opens com.example.testeintelij.Dominio to javafx.base;

    exports com.example.testeintelij.Persistencia to javafx.fxml;
    opens com.example.testeintelij.Persistencia to javafx.base;
}
