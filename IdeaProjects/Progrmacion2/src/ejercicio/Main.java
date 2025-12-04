package ejercicio;

import Colas.ColaPrioridad.ColaPrioridadAO;
import Colas.ColaPrioridad.ColaPrioridadTDA;
import Conjunto.*;
import Pilas.PilaTF;

public class Main {

    static int []   proceso (PilaTF pila ){


        ConjuntoTDA conjunto = new ConjuntoA();
        conjunto.InicilizarConjunto();

        ColaPrioridadTDA colaPrioridad = new ColaPrioridadAO();
        colaPrioridad.InicializarCola();


        int indx =0;
        int cantElemento=0;



        while (!pila.PilaVacia()){
            conjunto.agregar(pila.Tope());
            pila.Desapilar();
        }

        while (!conjunto.ConjuntoVacio()){
            int valor = conjunto.Elegir();
            colaPrioridad.AcolarPrioridad(valor,valor);
            conjunto.Sacar(valor);
            cantElemento++;
        }



        int [] vector = new int[cantElemento];


        while (!colaPrioridad.ColaVacia()){
            vector[indx]=colaPrioridad.Primero();
            colaPrioridad.Desacolar();
            indx+=1;
        }

        return vector;
    };

    public static void main(String[] args) {
        PilaTF pila = new PilaTF();
        pila.InicilizarPila();
        pila.Apilar(3);
        pila.Apilar(6);
        pila.Apilar(6);
        pila.Apilar(8);
        pila.Apilar(9);
        pila.Apilar(8);
        pila.Apilar(9);



        var vector = proceso(pila);

        for (int i : vector){
            System.out.println(i);
        };
    }
}
