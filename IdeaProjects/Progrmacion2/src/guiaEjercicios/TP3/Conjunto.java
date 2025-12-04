package guiaEjercicios.TP3;


import Colas.ColaPI;
import Colas.ColaTDA;
import Conjunto.*;

import  Colas.ColaPrioridad.*;
import Pilas.PilaTDA;
import Pilas.PilaTF;

public class Conjunto {



    //D
    public static boolean conjuntosIguales (ConjuntoTDA c1 ,ConjuntoTDA c2){

        ColaPrioridadAO colaAux1 = new ColaPrioridadAO();
        ColaPrioridadAO colaAux2 = new ColaPrioridadAO();

        colaAux1.InicializarCola();
        colaAux2.InicializarCola();

        while (!c1.ConjuntoVacio()){
            int valor = c1.Elegir();
            colaAux1.AcolarPrioridad(valor,valor);
            c1.Sacar(valor);
        }


        while (!c2.ConjuntoVacio()){
            int valor = c2.Elegir();
            colaAux2.AcolarPrioridad(valor,valor);
            c2.Sacar(valor);
        }

        boolean sonIdenticos = true;

        while (!colaAux1.ColaVacia() && !colaAux2.ColaVacia()){

            int val1= colaAux1.Primero();
            int val2= colaAux2.Primero();

            if (val1!=val2){
                sonIdenticos=false;
            }

            c1.agregar(val1);
            c2.agregar(val2);
            colaAux1.Desacolar();
            colaAux2.Desacolar();
        }





        return sonIdenticos;
    }

    //E
    public static int cantidadElementos(ConjuntoTDA c){
        int cantidad=0;
        ConjuntoTDA conjuntoAux = new ConjuntoA();
        conjuntoAux.InicilizarConjunto();

        while (!c.ConjuntoVacio()){
            int valor = c.Elegir();
            conjuntoAux.agregar(valor);
            cantidad+=1;

            c.Sacar(valor);
        }


        while (!conjuntoAux.ConjuntoVacio()){
            int valor= conjuntoAux.Elegir();

            c.agregar(valor);

            conjuntoAux.Sacar(valor);
        }
        return cantidad;
    }


    //F

    public static  ConjuntoTDA elementosComunes (PilaTDA p , ColaTDA c ){
        ConjuntoTDA comunes = new ConjuntoA();
        ConjuntoTDA cAux1 = new ConjuntoA();
        ConjuntoTDA  cAux2 = new ConjuntoA();

        PilaTDA pilaAux = new PilaTF();
        ColaTDA colaAux = new ColaPI();


        comunes.InicilizarConjunto();
        cAux1.InicilizarConjunto();
        cAux2.InicilizarConjunto();

        pilaAux.InicilizarPila();
        colaAux.InicilizarCola();

        while (!p.PilaVacia()){
            int valor = p.Tope();
            cAux1.agregar(valor);
            pilaAux.Apilar(valor);
            p.Desapilar();
        }

        while (!c.ColaVacia()){
            int valor = c.Primero();
            cAux2.agregar(valor);
            colaAux.Acolar(valor);
            c.Desacolar();
        }


        while (!cAux1.ConjuntoVacio()){
            int valor  = cAux1.Elegir();

            if (cAux2.Pertenece(valor)){
                comunes.agregar(valor);
                cAux1.Sacar(valor);
            }else {
                cAux1.Sacar(valor);
            }


        }

        //restaura la estrcutura orgiinal


        while (!pilaAux.PilaVacia()){
            p.Apilar(pilaAux.Tope());
            pilaAux.Desapilar();
        }

        while (!colaAux.ColaVacia()){
            c.Acolar(colaAux.Primero());
            colaAux.Desacolar();
        }

        return  comunes ;

    }

    public static void main(String[] args) {

        ConjuntoTDA conjuntoA = new ConjuntoA();
        ConjuntoTDA conjuntoB = new ConjuntoA();

        conjuntoA.InicilizarConjunto();
        conjuntoB.InicilizarConjunto();


        conjuntoA.agregar(1);
        conjuntoA.agregar(2);
        conjuntoA.agregar(3);
        conjuntoA.agregar(4);
        conjuntoA.agregar(5);
        conjuntoA.agregar(6);


        conjuntoB.agregar(1);
        conjuntoB.agregar(2);
        conjuntoB.agregar(3);
        conjuntoB.agregar(4);
        conjuntoB.agregar(5);
        conjuntoB.agregar(6);



        PilaTF pil = new PilaTF();
        ColaTDA c = new ColaPI();

        pil.InicilizarPila();
        c.InicilizarCola();

        pil.Apilar(8);
        pil.Apilar(1);
        pil.Apilar(2);
        pil.Apilar(552);


        c.Acolar(1);

        c.Acolar(552);
        System.out.println("CONJUNTOS SON IDENTICOS  : " + conjuntosIguales(conjuntoA, conjuntoB));
        System.out.println("CANTIDAD ELEMENTOS " + cantidadElementos(conjuntoA));
        System.out.println("CONJUNTO DE ELEMENTOS COMUNES " + elementosComunes(pil,c));



        ConjuntoTDA conA = new ConjuntoA();
        ConjuntoTDA conB = new ConjuntoA();

        conA.InicilizarConjunto();
        conB.InicilizarConjunto();

        conA.agregar(1);
        conA.agregar(2);
        conA.agregar(3);
        conA.agregar(4);

        conB.agregar(3);
        conB.agregar(4);
        conB.agregar(5);
        conB.agregar(6);









    }
}
