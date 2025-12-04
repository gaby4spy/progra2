package Repaso;

import Colas.ColaPI;
import Colas.ColaPU;
import Colas.ColaTDA;
import Pilas.PilaTDA;
import Pilas.PilaTF;

public class Cola {

    public  static  void pasarCola(ColaTDA c1 , ColaTDA c2){
        while (!c1.ColaVacia()){
            int valor = c1.Primero();
            c2.Acolar(valor);
            c1.Desacolar();
        }
    }
    public static  void  invertirCola(ColaTDA c1){
        PilaTDA pAux = new PilaTF();
        pAux.InicilizarPila();

        while (!c1.ColaVacia()){
            pAux.Apilar(c1.Primero());
            c1.Desacolar();
        }

        while (!pAux.PilaVacia()){
            c1.Acolar(pAux.Tope());
            pAux.Desapilar();
        }
    }
    public static void invertirCola2(ColaTDA c1){
        if (!c1.ColaVacia()){
            int valor = c1.Primero();
            c1.Desacolar();
            invertirCola2(c1);
            c1.Acolar(valor);
        }
    }
    public static boolean coincide(ColaTDA c1, ColaTDA c2 ){
        ColaTDA cAux1= new ColaPI();
        ColaTDA cAux2= new ColaPI();


        cAux1.InicilizarCola();
        cAux2.InicilizarCola();
        int tamanio1= 0;
        int tamanio2=0;

        while (!c1.ColaVacia()){
            int valor = c1.Primero();
            cAux1.Acolar(valor);
            tamanio1+=1;
            c1.Desacolar();
        }


        while (!c2.ColaVacia()){
            int valor = c2.Primero();
            cAux2.Acolar(valor);
            tamanio2+=1;
            c2.Desacolar();
        }

        if (tamanio2>tamanio1){
            return false;
        }

        int diferencia = tamanio1-tamanio2;
        boolean coincide = true;

        int pos =0;
        while (!cAux1.ColaVacia()){
            if (pos>=diferencia){
                c1.Acolar(cAux1.Primero());
            }
            pos+=1;
            cAux1.Desacolar();
        }



        while (!c1.ColaVacia() && !cAux2.ColaVacia()){
            int val1= c1.Primero();
            int val2= cAux2.Primero();

            if (val1!=val2){
                coincide=false;
            }

            c1.Desacolar();
            cAux2.Desacolar();
        }
        return coincide;

    }
    public  static  boolean esCapicua (ColaTDA c1){
        PilaTDA pilaAux = new PilaTF();
        ColaTDA colaAux = new ColaPI();

        pilaAux.InicilizarPila();
        colaAux.InicilizarCola();

        while (!c1.ColaVacia()){
            pilaAux.Apilar(c1.Primero());
            colaAux.Acolar(c1.Primero());
            c1.Desacolar();
        }

        boolean capicua= true;
        while (!pilaAux.PilaVacia()){
            int val1= pilaAux.Tope();
            int val2= colaAux.Primero();

            if (val1!=val2){
                capicua=false;
            }
            c1.Acolar(val2);
            pilaAux.Desapilar();
            colaAux.Desacolar();

        }

        return capicua;
    }
    public static  boolean esInverso (ColaTDA c1, ColaTDA c2){
        PilaTDA pilaAux= new PilaTF();
        ColaTDA colaAux1 = new ColaPI();
        ColaTDA colaAux2 = new ColaPI();

        pilaAux.InicilizarPila();
        colaAux1.InicilizarCola();
        colaAux2.InicilizarCola();


        while (!c1.ColaVacia()){
            colaAux1.Acolar(c1.Primero());
            pilaAux.Apilar(c1.Primero());
            c1.Desacolar();
        }


        boolean esInverso=true;

        while (!pilaAux.PilaVacia()){
            int valor1= pilaAux.Tope();
            int valor2 = c2.Primero();

            if (valor1!=valor2){
                esInverso=false;
            }

            colaAux2.Acolar(valor2);

            c2.Desacolar();
            colaAux2.Acolar(valor2);
            pilaAux.Desapilar();
        }


        while (!colaAux1.ColaVacia()){
            c1.Acolar(colaAux1.Primero());
            colaAux1.Desacolar();
        }

        while (!colaAux2.ColaVacia()){
            c2.Acolar(colaAux2.Primero());
            colaAux2.Desacolar();
        }
        return esInverso;
    }

    public static void main(String[] args) {
        ColaTDA c = new ColaPU();
        c.InicilizarCola();

        ColaTDA c1 = new ColaPU();
        c1.InicilizarCola();

        c.Acolar(12);
        c.Acolar(111);
        c.Acolar(1);



        c1.Acolar(1);
        c1.Acolar(2);
        c1.Acolar(12);


        System.out.println(esInverso(c,c1));



    }
}
