package ejercicio.EnlazadaPila;

import EstructurasEnlazadas.Pila.PilaLD;

import java.util.WeakHashMap;

public class Main {



    public  static PilaLD pasarPila(PilaLD origen ,PilaLD destino){

        PilaLD aux = new PilaLD();
        aux.InicilizarPila();



        while (!origen.PilaVacia()){
            aux.Apilar(origen.Tope());
            origen.Desapilar();
        }

        while (!aux.PilaVacia()){
            destino.Apilar(aux.Tope());
            aux.Desapilar();
        }

        return destino;
    }
    public static void main(String[] args) {

        PilaLD p = new PilaLD();
        PilaLD p1 = new PilaLD();

        p.InicilizarPila();
        p1.InicilizarPila();

        p.Apilar(1);
        p.Apilar(2);
        p.Apilar(3);
        p.Apilar(4);
        p.Apilar(5);

        pasarPila(p,p1);

        System.out.println(    p1.Tope());


    }


}
