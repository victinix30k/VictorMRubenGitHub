package es.iescanarias.vm.guardarrectangulo.guardarrectangulo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Aplicacion.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 400, 350);
        stage.setTitle("Guardar rectángulo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}