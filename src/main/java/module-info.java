module gizi.lovebody {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens gizi.lovebody to javafx.fxml;
    exports gizi.lovebody;
}