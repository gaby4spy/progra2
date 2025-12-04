package Repaso;

import Pilas.PilaTDA;
import Pilas.PilaTF;

public class Pila {

    public  static PilaTDA copiarPila (PilaTDA p1 ,PilaTDA p2){

        while (!p1.PilaVacia()){
            p2.Apilar(p1.Tope());
            p1.Desapilar();
        }
        return p2;
    }
    public static PilaTDA pasarPila(PilaTDA p1  ,PilaTDA p2){
        PilaTDA pilaAux = new PilaTF();
        pilaAux.InicilizarPila();

        while (!p1.PilaVacia()){
            pilaAux.Apilar(p1.Tope());
            p1.Desapilar();
        }

        while (!pilaAux.PilaVacia()){
            p2.Apilar(pilaAux.Tope());
            pilaAux.Desapilar();
        }
        return p2;
    }
    public static void invertirPila(PilaTDA p1){
        PilaTDA aux1 = new PilaTF();
        PilaTDA aux2 = new PilaTF();

        aux1.InicilizarPila();
        aux2.InicilizarPila();


        while (!p1.PilaVacia()){
            aux1.Apilar(p1.Tope());
            p1.Desapilar();
        }

        while (!aux1.PilaVacia()){
            aux2.Apilar(aux1.Tope());
            aux1.Desapilar();
        }

        while (!aux2.PilaVacia()){
            p1.Apilar(aux2.Tope());
            aux2.Desapilar();
        }
    }
    public static int contarElementos(PilaTDA p1){
        if (p1.PilaVacia()){
            return 0;
        }else {
            int valor = p1.Tope();
            p1.Desapilar();
            return 1+contarElementos(p1);


        }
    }
    public static int sumarElmentos(PilaTDA p1){
        if (p1.PilaVacia()){
            return 0;
        }else {
            int valor = p1.Tope();
            p1.Desapilar();
            int suma= valor + sumarElmentos(p1);
            p1.Apilar(valor);
            return suma;

        }
    }
    public static int promedioElementos(PilaTDA p1){
        int cant = 0;
        int total = 0;

        while (!p1.PilaVacia()){
            int valor = p1.Tope();
            cant+=1;
            total+=valor;
            p1.Desapilar();
        }

        return total/cant;
    }





    public static void main(String[] args) {


        PilaTDA p = new PilaTF();
        p.InicilizarPila();
        p.Apilar(1);
        p.Apilar(2);
        p.Apilar(3);


        PilaTDA px = new PilaTF();
        px.InicilizarPila();



    }

}
