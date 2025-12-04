package guiaEjercicios.TP1;

import  Colas.ColaPI;
import  Pilas.PilaTF;
public class Cola {

    //A
    public static void pasarCola(ColaPI c1, ColaPI c2){
        while (!c1.ColaVacia()){
            c2.Acolar(c1.Primero());
            c1.Desacolar();
        }
    }
    //B
    public static void invertirContenido1 (ColaPI c1){
        PilaTF pilaAux = new PilaTF();
        pilaAux.InicilizarPila();
        while (!c1.ColaVacia()){
            pilaAux.Apilar(c1.Primero());
            c1.Desacolar();
        }

        while (!pilaAux.PilaVacia()){
            c1.Acolar(pilaAux.Tope());
            pilaAux.Desapilar();
        }

    };

    //C
    public static void  invertirContenido2(ColaPI c1){
        if (!c1.ColaVacia()){
            int x = c1.Primero();
            c1.Desacolar();

            invertirContenido2(c1);

            c1.Acolar(x);
        }

    }

    //D
    public static boolean coincideFinal(ColaPI c1 ,ColaPI c2){
        ColaPI aux1 = new ColaPI();
        ColaPI aux2= new ColaPI();

        aux1.InicilizarCola();
        aux2.InicilizarCola();
        int tamanioC1=0;
        int tamanioC2=0;


        while (!c1.ColaVacia()  ){
            aux1.Acolar(c1.Primero());
            tamanioC1+=1;
            c1.Desacolar();
        }

        while ( !c2.ColaVacia()){
            aux2.Acolar(c2.Primero());
            tamanioC2+=1;
            c2.Desacolar();
        }

        if (tamanioC2>tamanioC1)return false;

        int saltear=tamanioC1-tamanioC2;
        for (int i =0; i<saltear;i++){
            c1.Acolar(aux1.Primero());
            aux1.Desacolar();
        }

        boolean coinciden = true;
        while (!aux1.ColaVacia()){
            int x1=aux1.Primero();
            int x2=aux2.Primero();

            if (x1!=x2){
                coinciden=false;
            }

            c1.Acolar(x1);
            c2.Acolar(x2);

            aux1.Desacolar();
            aux2.Desacolar();
        }

        return coinciden;

    };
    //E
    public static boolean esCapicua(ColaPI c1){
        PilaTF aux = new PilaTF(); //invierte el contenido
        ColaPI colAux= new ColaPI(); //permite volver a su orden orig
        aux.InicilizarPila();
        colAux.InicilizarCola();

        while (!c1.ColaVacia()){
            aux.Apilar(c1.Primero());
            colAux.Acolar(c1.Primero());
            c1.Desacolar();
        }


        boolean capicua= true;

        while (!colAux.ColaVacia()){

            int val1=colAux.Primero();
            int val2=aux.Tope();

            if (val1!=val2){
                capicua=false;
            }
            c1.Acolar(colAux.Primero());
            colAux.Desacolar();
            aux.Desapilar();


        }

        return capicua;
    };
    //F
    public static boolean esInverso(ColaPI c1,ColaPI c2 ){
        PilaTF pilaAux = new PilaTF();
        ColaPI colaAux1 = new ColaPI();
        ColaPI colaAux2 = new ColaPI();

        pilaAux.InicilizarPila();
        colaAux1.InicilizarCola();
        colaAux2.InicilizarCola();

        //paso los elementos
        while (!c1.ColaVacia()){
            pilaAux.Apilar(c1.Primero());//permite comparar
            colaAux1.Acolar(c1.Primero());//vuelve estado original

            c1.Desacolar();
        }

        //compara

        boolean inverso = true;

        //va comparondo los valores de la cola c2 y pilaAux
        while (!c2.ColaVacia()){
            int val1= pilaAux.Tope();
            int val2=c2.Primero();

            colaAux2.Acolar(c2.Primero());
            if (val1!=val2){
                inverso=false;
            }
            pilaAux.Desapilar();
            c2.Desacolar();
        }


        //vuelve c1 y c2 a su orden original
        while (!colaAux1.ColaVacia()){
            c1.Acolar(colaAux1.Primero());
            colaAux1.Desacolar();
        }

        while (!colaAux2.ColaVacia()){
            c2.Acolar(colaAux2.Primero());
            colaAux2.Desacolar();
        }




        return inverso;
    }




    public static void main(String[] args) {

        //BASE
        ColaPI cola1 = new ColaPI();
        ColaPI cola2 = new ColaPI();

        cola1.InicilizarCola();
        cola2.InicilizarCola();


        cola1.Acolar(8);
        cola1.Acolar(2);
        cola1.Acolar(3);



        cola2.Acolar(3);
        cola2.Acolar(2);
        cola2.Acolar(1);

        //test funcionaldiades
        /*ejer1
        pasarCola(cola1,cola2);
        System.out.println(    cola2.Primero()); */

        /*ejer2
        System.out.println("Primer elemento sin invertir : "+ cola1.Primero());
        invertirContenido1(cola1);
        System.out.println("Primer al invertir la cola : "+ cola1.Primero());*/


        /*ejer3
        invertirContenido2(cola1);
        System.out.println(cola1.Primero());*/

        //System.out.println(coincideFinal(cola1,cola2));


        // System.out.println(esCapicua(cola1));

        //System.out.println(cola1.Primero());

        System.out.println(esInverso(cola1,cola2));
    }
}
