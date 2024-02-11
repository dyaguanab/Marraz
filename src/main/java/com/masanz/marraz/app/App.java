package com.masanz.marraz.app;

import com.masanz.marraz.Main;
import com.masanz.marraz.controller.MainController;
import com.masanz.marraz.db.Conexion;
import com.masanz.marraz.utils.Exec;
import com.masanz.marraz.consts.Consts;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App extends Application {
    public static final URL LOG4J_PROPERTIES = Main.class.getResource("log4j.properties");
    public static final String SYSTEM_PROPERTY = "userApp.hostName";
    private static Logger log = Logger.getLogger(App.class);

    /**
     * Método que inicia la aplicación
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        System.setProperty(SYSTEM_PROPERTY, Exec.getHostName());
        PropertyConfigurator.configure(LOG4J_PROPERTIES);
        log.info("-".repeat(64));
        iniciarConexion(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/masanz/marraz/view/marraz.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Consts.APP_WIDTH, Consts.APP_HEIGHT);
        stage.setTitle(Consts.APP_TITLE);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setOnHiding(windowEvent -> {
            Conexion.getConexion().cerrarConexion();
        });
    }

    /**
     * Método que inicia la conexión con la base de datos
     * @param stage
     */
    private void iniciarConexion(Stage stage){
        while (!Conexion.getConexion().conectar()){
            FileChooser ventana = new FileChooser();
            ventana.setTitle("Selecciona la base de datos: ");
            File file= ventana.showOpenDialog(stage);
            if (file != null){
                Conexion.getConexion().setDbPath(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}