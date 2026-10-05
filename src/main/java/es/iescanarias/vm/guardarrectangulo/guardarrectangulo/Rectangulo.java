package es.iescanarias.vm.guardarrectangulo.guardarrectangulo;

public class Rectangulo {

    private double ancho;
    private double largo;

    public Rectangulo(double ancho, double largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public double getLargo() {
        return largo;
    }

    public double getArea() {
        return ancho * largo;
    }
}