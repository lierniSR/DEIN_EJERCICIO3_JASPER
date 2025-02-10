package es.liernisarraoa.ejercicio3.Controlador;

import es.liernisarraoa.ejercicio3.Conexion.ConexionDB;
import es.liernisarraoa.ejercicio3.Propiedades.Propiedades;
import es.liernisarraoa.ejercicio3.Supermercado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

public class SupermercadoControlador {
    private final Propiedades propiedades = new Propiedades();
    /**
     * Función que muestra un mensaje de alerta al usuario
     *
     * @param mensaje de error a mostrar
     */
    public void alerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Función que es ejecuta cuando se pulsa el botón. Abre el informe de productos
     *
     * @param actionEvent
     */
    @FXML
    public void informeProducto(ActionEvent actionEvent) {
        LocalDate fechaActual = LocalDate.now();
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = "C:\\DM2\\DEIN\\ProyectoFXJasper\\Ejercicio3\\src\\main\\resources\\es\\liernisarraoa\\ejercicio3\\reportes\\ProductosInforme.jasper";

            // Cargar el archivo Jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Configurar conexión a la base de datos
            String dbUrl = "jdbc:mariadb://localhost:3306/supermercado";
            String dbUser  = propiedades.getProperty("db.usuario");
            String dbPassword = propiedades.getProperty("db.contrasenia");

            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);


            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void informeSecciones(ActionEvent event) {
        ConexionDB connection;
        try {
            connection = new ConexionDB(); // Instanciar la conexión con la base de datos
            JasperReport report = (JasperReport) JRLoader.loadObject(Supermercado.class.getResource("reportes/InformeSecciones.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, connection.getConexion());
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true); // Mostrar el informe al usuario
        } catch (JRException | SQLException e) {
            System.err.println(e.getMessage());
            alerta("Error en el informe.");
        }
    }

    @FXML
    void informeTablaProductos(ActionEvent event) {
        ConexionDB connection;
        try {
            connection = new ConexionDB(); // Instanciar la conexión con la base de datos
            JasperReport report = (JasperReport) JRLoader.loadObject(Supermercado.class.getResource("reportes/InformeTablaProductos.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, connection.getConexion());
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true); // Mostrar el informe al usuario
        } catch (JRException | SQLException e) {
            System.err.println(e.getMessage());
            alerta("Error en el informe.");
        }
    }

    @FXML
    void informeGraficos(ActionEvent event) {
        LocalDate fechaActual = LocalDate.now();
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = "C:\\DM2\\DEIN\\ProyectoFXJasper\\Ejercicio3\\src\\main\\resources\\es\\liernisarraoa\\ejercicio3\\reportes\\ProductosInforme.jasper";

            // Cargar el archivo Jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Configurar conexión a la base de datos
            String dbUrl = "jdbc:mariadb://localhost:3306/supermercado";
            String dbUser  = propiedades.getProperty("db.usuario");
            String dbPassword = propiedades.getProperty("db.contrasenia");

            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), connection);


            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}