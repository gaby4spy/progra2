package guiaEjercicios.TP3;

import Colas.ColaPI;
import Colas.ColaTDA;
import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;

public class Cola {


    //A
    public  static  void eliminarRepeticionesCola(ColaTDA c) {

        ConjuntoTDA visitados= new ConjuntoA();
        ColaTDA colaAux = new ColaPI();


        visitados.InicilizarConjunto();
        colaAux.InicilizarCola();

        while (!c.ColaVacia()){
            int valor = c.Primero();

            colaAux.Acolar(valor);
            visitados.agregar(valor);

            c.Desacolar();
        }


        while (!colaAux.ColaVacia()){
            int valor = colaAux.Primero();
            if (visitados.Pertenece(valor)){
                c.Acolar(valor);
                colaAux.Desacolar();
            }else {
                colaAux.Desacolar();
            }

            visitados.Sacar(valor);
        }





    }

    //B
    public static void repartirCola(ColaTDA cola){
        ColaTDA m1 = new ColaPI(); //primera mitad
        ColaTDA m2 = new ColaPI(); // seg mitad
        ColaTDA aux = new ColaPI(); //conserva la estrcutura orgiginal


        m1.InicilizarCola();
        m2.InicilizarCola();
        aux.InicilizarCola();

        int cantElmentos=0;

        while (!cola.ColaVacia()){
            aux.Acolar(cola.Primero());
            cantElmentos+=1;
            cola.Desacolar();
        }


        int inxVal=cantElmentos/2-1;
        int inxAct=0;

        while (!aux.ColaVacia()){

            cola.Acolar(aux.Primero()); //restaura la estructura orginal
            if (inxAct<=inxVal){ //verifica si estamos en el rango que corresponde a m1 caso contrario empieza a agregar m2
                aux.Primero();
                m1.Acolar(aux.Primero());
            }else {
                aux.Primero();
                m2.Acolar(aux.Primero());
            }
            inxAct+=1;
            aux.Desacolar();
        }

    }


    //C


    public static ConjuntoTDA repetidos (ColaTDA cola ){
        ColaTDA  colaAux = new ColaPI();
        ConjuntoTDA visitados = new ConjuntoA();
        ConjuntoTDA repetidos  = new ConjuntoA();


        colaAux.InicilizarCola();
        visitados.InicilizarConjunto();
        repetidos.InicilizarConjunto();

        while (!cola.ColaVacia()){
            int valor  = cola.Primero();

            if (!visitados.Pertenece(valor)){
                visitados.agregar(valor);
            }else {
                repetidos.agregar(valor);
            }
            colaAux.Acolar(valor);
            cola.Desacolar();


        }



        return repetidos;
    }

    public static void main(String[] args) {


        ColaTDA col = new ColaPI();
        col.InicilizarCola();
        col.Acolar(1);
        col.Acolar(2);
        col.Acolar(3);
        col.Acolar(4);
        col.Acolar(5);
        col.Acolar(6);


       /* eliminarRepeticionesCola(col); */

        /*repartirCola(col); */

       /*repetidos(col);*/

    }
}
