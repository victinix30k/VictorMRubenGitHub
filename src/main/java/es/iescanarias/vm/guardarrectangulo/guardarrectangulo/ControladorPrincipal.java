package es.iescanarias.vm.guardarrectangulo.guardarrectangulo;

import java.io.IOException;
import java.nio.file.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorPrincipal {
    private static final Path ARCHIVO = Paths.get("rectangulo.txt");

    @FXML private TextField Svancho;
    @FXML private TextField SVLargo;
    @FXML private Button GuardarRec;
    @FXML private Button LeerRec;
    @FXML private TextArea Result;

    @FXML
    private void onGuardarClick() {
        try {
            double ancho = Double.parseDouble(Svancho.getText().trim());
            double largo = Double.parseDouble(SVLargo.getText().trim());
            Rectangulo r = new Rectangulo(ancho, largo);

            Files.writeString(ARCHIVO, ancho + ";" + largo);
            Result.setText("Guardado.\nArea: " + r.getArea()
                    + "\nPerimetro: " + r.getPerimetro());
        } catch (NumberFormatException e) {
            Result.setText("Error: ancho y largo deben ser numeros.");
        } catch (IOException e) {
            Result.setText("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    private void onLeerClick() {
        try {
            String[] partes = Files.readString(ARCHIVO).trim().split(";");
            Rectangulo r = new Rectangulo(
                    Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));

            Svancho.setText(String.valueOf(r.getAncho()));
            SVLargo.setText(String.valueOf(r.getLargo()));
            Result.setText("Leido.\nAncho: " + r.getAncho()
                    + "\nLargo: " + r.getLargo()
                    + "\nArea: " + r.getArea()
                    + "\nPerimetro: " + r.getPerimetro());
        } catch (NoSuchFileException e) {
            Result.setText("Aun no hay nada guardado.");
        } catch (IOException | RuntimeException e) {
            Result.setText("Error al leer: " + e.getMessage());
        }
    }
}