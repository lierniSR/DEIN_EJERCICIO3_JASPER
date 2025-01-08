module es.liernisarraoa.ejercicio3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.liernisarraoa.ejercicio3 to javafx.fxml;
    exports es.liernisarraoa.ejercicio3;
}