package es.iescanarias.vm.guardarrectangulo.guardarrectangulo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorPrincipal{

    @FXML
    private TextField txtBase;

    @FXML
    private TextField txtAltura;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLeer;

    @FXML
    private Label lblResultado;

    private final String NOMBRE_ARCHIVO = "rectangulo.txt";

    @FXML
    protected void onGuardarClick() {
        String baseStr = txtBase.getText().trim();
        String alturaStr = txtAltura.getText().trim();

        if (baseStr.isEmpty() || alturaStr.isEmpty()) {
            if (lblResultado != null) {
                lblResultado.setText("Por favor, rellena tanto la base como la altura.");
            }
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            writer.write(baseStr + ";" + alturaStr);
            
            if (lblResultado != null) {
                lblResultado.setText("Guardado con éxito en '" + NOMBRE_ARCHIVO + "' (" + baseStr + " ; " + alturaStr + ")");
            }
        } catch (IOException e) {
            if (lblResultado != null) {
                lblResultado.setText("Error al guardar el archivo: " + e.getMessage());
            }
        }
    }

    @FXML
    protected void onLeerClick() {
        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists()) {
            if (lblResultado != null) {
                lblResultado.setText("El archivo '" + NOMBRE_ARCHIVO + "' no existe todavía.");
            }
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea = reader.readLine();

            if (linea != null && !linea.trim().isEmpty()) {
                String[] datos = linea.split(";");
                if (datos.length >= 2) {
                    txtBase.setText(datos[0]);
                    txtAltura.setText(datos[1]);
                    if (lblResultado != null) {
                        lblResultado.setText("Datos leídos correctamente: Base=" + datos[0] + ", Altura=" + datos[1]);
                    }
                } else if (lblResultado != null) {
                    lblResultado.setText("Contenido leído: " + linea);
                }
            } else if (lblResultado != null) {
                lblResultado.setText("El archivo está vacío.");
            }
        } catch (IOException e) {
            if (lblResultado != null) {
                lblResultado.setText("Error al leer el archivo: " + e.getMessage());
            }
        }
    }
}