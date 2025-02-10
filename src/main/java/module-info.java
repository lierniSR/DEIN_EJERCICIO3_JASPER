module es.liernisarraoa.ejercicio3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;
    requires org.slf4j;
    requires jasperreports;


    opens es.liernisarraoa.ejercicio3 to javafx.fxml;
    exports es.liernisarraoa.ejercicio3;
    exports es.liernisarraoa.ejercicio3.Controlador;
    opens es.liernisarraoa.ejercicio3.Controlador to javafx.fxml;
}