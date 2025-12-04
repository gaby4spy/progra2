package guiaEjercicios.TP3;

import Colas.ColaPI;
import Conjunto.ConjuntoA;
import Pilas.PilaTDA;
import Pilas.PilaTF;
import  Colas.ColaTDA;
import  Conjunto.ConjuntoTDA;
public class Pila {

    //A
    public static  boolean esCapicua (PilaTDA pila) {
        PilaTDA pilaAux = new PilaTF(); //restura el orden de la pila orginal
        ColaTDA colaAux = new ColaPI();  // estructura para comparar la pila invertida

        pilaAux.InicilizarPila();
        colaAux.InicilizarCola();


        while (!pila.PilaVacia()){
            var valor = pila.Tope();

            pilaAux.Apilar(valor);
            colaAux.Acolar(valor);

            pila.Desapilar();
        }


        boolean capicua = true;

        while (!pilaAux.PilaVacia()){
            if (pilaAux.Tope()!= colaAux.Primero()){
                capicua=false;
            }
            pilaAux.Desapilar();
            colaAux.Desacolar();
        }

        return capicua;
    }

    //B
    public static PilaTDA eliminarRpetidos (PilaTDA pila ){
        ConjuntoTDA cojuntoAux = new ConjuntoA();
        cojuntoAux.InicilizarConjunto();
        ColaTDA colaAux = new ColaPI();
        colaAux.InicilizarCola();

        while (!pila.PilaVacia()){
            cojuntoAux.agregar(pila.Tope());
            colaAux.Acolar(pila.Tope());
            pila.Desapilar();
        }


        while (!colaAux.ColaVacia()){
            var valor = colaAux.Primero();

            if (cojuntoAux.Pertenece(valor)){
                cojuntoAux.Sacar(valor);
                pila.Apilar(valor);
            }
            colaAux.Desacolar();
        }


        return pila;
    }

    //C
    public  static  void rapartirCola (PilaTDA pila ){
        PilaTDA m1 = new PilaTF() ;
        PilaTDA m2= new PilaTF() ;

        PilaTDA aux1= new PilaTF();
        PilaTDA aux2= new PilaTF();
        ColaTDA colaAux = new ColaPI();

        int cantElementos =0;
        m1.InicilizarPila();
        m2.InicilizarPila();
        colaAux.InicilizarCola();
        aux2.InicilizarPila();
        aux1.InicilizarPila();

        while (!pila.PilaVacia()){
            cantElementos+=1;
            colaAux.Acolar(pila.Tope());
            pila.Desapilar();
        }

        int rangoPrimeraTanda = cantElementos /2 -1 ;
        int indiceActual =0;//

        while (!colaAux.ColaVacia()){
            if (indiceActual<=rangoPrimeraTanda){


                aux1.Apilar(colaAux.Primero());
                colaAux.Desacolar();
                indiceActual++;
            }else {
                aux2.Apilar(colaAux.Primero());
                colaAux.Desacolar();
            }
        }



        while (!aux1.PilaVacia()){
            m1.Apilar(aux1.Tope());
            aux1.Desapilar();
        }
        while (!aux2.PilaVacia()){
            m2.Apilar(aux2.Tope());
            aux2.Desapilar();
        }



    }

    //D


    public static ConjuntoTDA elementosRepetidos (PilaTDA pila){
        ConjuntoTDA repetidos = new ConjuntoA();
        ConjuntoTDA visitados = new ConjuntoA();
        PilaTDA pilaAux = new PilaTF();


        repetidos.InicilizarConjunto();
        visitados.InicilizarConjunto();
        pilaAux.InicilizarPila();

        while (!pila.PilaVacia()){
            int valor = pila.Tope();
            if (!visitados.Pertenece(valor)){
                visitados.agregar(valor);
            }else {
                repetidos.agregar(valor);
            }

            pilaAux.Apilar(valor);
            pila.Desapilar();
        }

        return repetidos;
    };


    public static void main(String[] args) {

        PilaTDA pila1 = new PilaTF();
        pila1.InicilizarPila();

        pila1.Apilar(1);
        pila1.Apilar(2);
        pila1.Apilar(3);
        pila1.Apilar(4);
        pila1.Apilar(5);
        pila1.Apilar(6);



        /*System.out.println(esCapicua(pila1)); */
        /*eliminarRpetidos(pila1);*/




         /*rapartirCola(pila1); */



       /* elementosRepetidos(pila1);*/

        rapartirCola(pila1);







    }
}
