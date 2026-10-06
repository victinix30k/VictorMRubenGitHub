module es.iescanarias.vm.guardarrectangulo.guardarrectangulo {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.iescanarias.vm.guardarrectangulo.guardarrectangulo to javafx.fxml;
    exports es.iescanarias.vm.guardarrectangulo.guardarrectangulo;
}