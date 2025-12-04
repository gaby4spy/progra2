package guiaEjercicios.TP1;

import  Conjunto.ConjuntoA;
import  Colas.ColaPrioridad.ColaPrioridadAO;
public class Cojunto {

    public  static  boolean contieneCojunto(ConjuntoA cj1, ConjuntoA cj2){
        ColaPrioridadAO colaAux1 = new ColaPrioridadAO();
        ColaPrioridadAO colaAux2 = new ColaPrioridadAO();

        colaAux1.InicializarCola();
        colaAux2.InicializarCola();



        while (!cj1.ConjuntoVacio() || !cj2.ConjuntoVacio()){
            int valor1=cj1.Elegir();
            int valor2=cj2.Elegir();


            if (!cj1.ConjuntoVacio()){
                colaAux1.AcolarPrioridad(valor1,valor1);
                cj1.Sacar(valor1);
            }

            if (!cj2.ConjuntoVacio()){
                colaAux2.AcolarPrioridad(valor2,valor2);
                cj2.Sacar(valor2);
            }

        }


        boolean contiene=true;


        while (!colaAux1.ColaVacia() || !colaAux2.ColaVacia()){
            if (!colaAux1.ColaVacia() && !colaAux2.ColaVacia() && colaAux1.Primero()!=colaAux2.Primero()){
                contiene=false;

                cj1.agregar(colaAux1.Primero());
                colaAux1.Desacolar();

                cj2.agregar(colaAux1.Primero());
                colaAux2.Desacolar();
            }

            if (!colaAux1.ColaVacia()){
                int val= colaAux1.Primero();
                cj1.agregar(val);
                colaAux1.Desacolar();
            }
            if (!colaAux2.ColaVacia()){
                int val= colaAux2.Primero();
                cj2.agregar(val);
                colaAux2.Desacolar();
            }
        }



        return contiene;
    }
    public static void main(String[] args) {

        ConjuntoA conjunt1= new ConjuntoA();
        conjunt1.InicilizarConjunto();
        conjunt1.agregar(1);
        conjunt1.agregar(2);
        conjunt1.agregar(3);
        conjunt1.agregar(4);
        conjunt1.agregar(5);

        ConjuntoA conjunt2= new ConjuntoA();
        conjunt2.InicilizarConjunto();
        conjunt2.agregar(1);
        conjunt2.agregar(2);
        conjunt2.agregar(3);
        conjunt2.agregar(4);
        conjunt2.agregar(5);

        if(contieneCojunto(conjunt1,conjunt2)){
            System.out.println("el conjunto A contiene al B");
        }else {
            System.out.println("el conjunto A NO contiene al B");
        }



    }
}
