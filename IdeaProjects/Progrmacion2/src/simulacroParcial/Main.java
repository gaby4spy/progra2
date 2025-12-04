package simulacroParcial;

import Colas.ColaPrioridad.ColaPrioridadAO;
import Colas.ColaPrioridad.ColaPrioridadTDA;
import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;
import Pilas.PilaTDA;
import Pilas.PilaTF;

public class Main {



    public static int sumatoriaPila(PilaTDA pila) {
        if (pila.PilaVacia()) {
            return 0;
        }

        int valor = pila.Tope();
        pila.Desapilar();
        int suma = valor + sumatoriaPila(pila);
        pila.Apilar(valor);
        return suma;
    }

    public static void comibarPilas (PilaTF pila1 , PilaTF pila2) {
        ConjuntoTDA conjuntoAux = new ConjuntoA();
        ColaPrioridadTDA colaPriordad = new ColaPrioridadAO();
        PilaTDA pilaFinal = new PilaTF();

        conjuntoAux.InicilizarConjunto();
        colaPriordad.InicializarCola();
        pilaFinal.InicilizarPila();


        while (!pila1.PilaVacia()){
            conjuntoAux.agregar(pila1.Tope());
            pila1.Desapilar();
        }

        while (!pila2.PilaVacia()){
            conjuntoAux.agregar(pila2.Tope());
            pila2.Desapilar();
        }


        while (!conjuntoAux.ConjuntoVacio()){
            int valor= conjuntoAux.Elegir();
            int prioridad =valor;
            colaPriordad.AcolarPrioridad(valor,prioridad);
            conjuntoAux.Sacar(valor);
        }

        while (!colaPriordad.ColaVacia()){
            pilaFinal.Apilar(colaPriordad.Primero());
            colaPriordad.Desacolar();
        }


        while (!pilaFinal.PilaVacia()){
            System.out.println(pilaFinal.Tope());
            pilaFinal.Desapilar();
        }
    }

    public static void main(String[] args) {

        PilaTF p1 = new PilaTF();
        PilaTF p2 = new PilaTF();

        p1.InicilizarPila();
        p2.InicilizarPila();

        // Pila 1
        p1.Apilar(20); // <-- repetido con pila2
        p1.Apilar(18);
        p1.Apilar(18); // repetido interno
        p1.Apilar(15);
        p1.Apilar(12);
        p1.Apilar(10); // <-- repetido con pila2
        p1.Apilar(8);
        p1.Apilar(5);
        p1.Apilar(3);
        p1.Apilar(1);  // <-- repetido con pila2

        // Pila 2
        p2.Apilar(50);
        p2.Apilar(44);
        p2.Apilar(30);
        p2.Apilar(30); // repetido interno
        p2.Apilar(25);
        p2.Apilar(20); // <-- repetido con pila1
        p2.Apilar(10); // <-- repetido con pila1
        p2.Apilar(4);
        p2.Apilar(2);
        p2.Apilar(1);  // <-- repetido con pila1

       /* comibarPilas(p1,p2);*/


        System.out.println(sumatoriaPila(p1));


    }
}
