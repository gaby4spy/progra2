package TP2.punto6;

public class Rectangulo extends  Figura {
    int alto;
    int ancho;

    public Rectangulo(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override

    public double calcularArea() {
        return alto*ancho;
    }
}
