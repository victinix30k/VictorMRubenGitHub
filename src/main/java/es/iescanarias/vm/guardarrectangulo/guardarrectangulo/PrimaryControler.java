package es.iescanarias.vm.guardarrectangulo.guardarrectangulo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryControler {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
