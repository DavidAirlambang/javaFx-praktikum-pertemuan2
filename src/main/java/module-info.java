module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pertemuan2.tugas to javafx.fxml;
    opens com.pertemuan2.tugas.model to javafx.fxml;
    exports com.pertemuan2.tugas;
    exports com.pertemuan2.tugas.model;
}