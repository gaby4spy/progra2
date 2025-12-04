package Recursivo;

import Pilas.PilaTDA;
import Pilas.PilaTF;

public class Main {


    public  static   int  sumaPila (PilaTDA pila ){

        if (pila.PilaVacia()){
            return 0;
        }else {
            int valor = pila.Tope();// 5
            pila.Desapilar(); // 4,3,2,1
            int sumaResto = sumaPila(pila);// 4,3,2,1
            return valor + sumaResto;
        }


    }


    public static int suma(int nro ){
        if(nro==1){
            return nro;
        }else {
            return nro + suma(nro-1);
        }
    }


    public  static  void  invertirPila (PilaTDA pila){
        if (!pila.PilaVacia()){
            int valor = pila.Tope();
            pila.Desapilar();
            invertirPila(pila);
            pila.Apilar(valor);
        }
    }

    public static int  contarPares (PilaTDA pila ){
        if (pila.PilaVacia()){
            return 0 ;
        }

        int valor = pila.Tope();
        int cuenta =0;
        if (valor%2==0){
            cuenta+=1;
        }
        contarPares(pila);
        return cuenta;

    }

    public static int contarElmentos (PilaTDA p){

        if (p.PilaVacia()){
            return 0;
        }else {
            p.Desapilar();
            return  1+ contarElmentos(p);
        }
    }


    public static boolean buscarElemento(PilaTDA p, int v) {
        if (p.PilaVacia()) {
            return false; // caso base: no está
        }
        if (p.Tope() == v) {
            return true;  // encontramos el valor
        }
        p.Desapilar();
        return buscarElemento(p, v); // usar el resultado de la llamada recursiva
    }

    public static void main(String[] args) {

        PilaTDA p1 = new PilaTF();
        p1.InicilizarPila();
        p1.Apilar(1);
        p1.Apilar(2);


        System.out.println(buscarElemento(p1,2));
    }
}
