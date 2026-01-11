package TP2.punto6;

public class Main {
    public static void main(String[] args) {

        Figura circulo = new Circulo(22);
        circulo.mostrarDescripcion();
        System.out.println("Area circulo : " + circulo.calcularArea());


        Figura rectangulo = new Rectangulo(20,100);
        rectangulo.mostrarDescripcion();
        System.out.println("Area rectangulo : " + rectangulo.calcularArea());



    }
}
