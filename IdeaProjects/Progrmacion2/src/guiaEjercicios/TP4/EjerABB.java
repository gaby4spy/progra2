package guiaEjercicios.TP4;

import Arbol.ABB;
import Arbol.TDAABB;
import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;

public class EjerABB {

    public  static  boolean buscarElemento(TDAABB x , int val){
        if (!x.ArbolVacio()){
            if (x.Raiz()==val){
                return true;
            } else if (val>x.Raiz()) {
                return buscarElemento(x.HijoDer(), val);
            }else {
                return buscarElemento(x.HijoIzq(), val);
            }
        }
        return false;
    }
    public  static  boolean esHoja(TDAABB x , int val){

        if (x.ArbolVacio()) {
            return false;
        }


        if (x.Raiz() == val) {
            return x.HijoDer().ArbolVacio() && x.HijoIzq().ArbolVacio();
        }

        if (val > x.Raiz()) {
            return esHoja(x.HijoDer(), val);
        } else {
            return esHoja(x.HijoIzq(), val);
        }
    }
    public  static int calcularProfunidad(TDAABB x , int val ){

        TDAABB aux =x;
        int profundiad =0;

        while (!aux.ArbolVacio()){
            if (aux.Raiz()==val){
                return profundiad;
            } else if (val>aux.Raiz()) {
                aux=aux.HijoDer();
                profundiad+=1;
            }else {
                aux=aux.HijoIzq();
                profundiad+=1;
            }
        }

        return -1;
    }
    public static int menorValor(TDAABB x ){
        TDAABB aux = x;

        while (!aux.HijoIzq().ArbolVacio()){
            aux=aux.HijoIzq();

        }

        return aux.Raiz();
    }
    public static int cantElementos(TDAABB x){


        if (x.ArbolVacio()) {
            return 0;
        }

        return 1 + cantElementos(x.HijoIzq()) + cantElementos(x.HijoDer());
    }
    public static int sumElementos(TDAABB x){


        if (x.ArbolVacio()) {
            return 0;
        }

        return x.Raiz() + sumElementos(x.HijoIzq()) + sumElementos(x.HijoDer());
    }
    public static int cantHojas(TDAABB x){

        if (x.ArbolVacio()) {
            return 0;
        }
        if (x.HijoIzq().ArbolVacio() && x.HijoDer().ArbolVacio()) {
            return 1;
        }

        return cantHojas(x.HijoIzq()) + cantHojas(x.HijoDer());
    }
    public static int anteiorElemento(TDAABB x , int val){
        int anterior=-1;
        TDAABB actual = x;

        while (!actual.ArbolVacio()){
            if (actual.Raiz()==val){
                return anterior;
            }else if (val>actual.Raiz()){
                anterior=actual.Raiz();
                actual=actual.HijoDer();
            }else {
                anterior=actual.Raiz();
                actual=actual.HijoIzq();
            }
        }


        return -1;
    }
    public static void generarConjunto(TDAABB x ,int valor, ConjuntoTDA c){
        if (!x.ArbolVacio()) {

            generarConjunto(x.HijoIzq(), valor, c);

            if (x.Raiz() > valor) {
                c.agregar(x.Raiz());
            }

            generarConjunto(x.HijoDer(), valor, c);
        }


    }

    public  static void inOrden(TDAABB x) {
        TDAABB aux= x;
        if (!aux.ArbolVacio()){
            inOrden(aux.HijoIzq());
            System.out.println(aux.Raiz());
            inOrden(aux.HijoDer());
        }
    }
    public  static void preOrder(TDAABB x) {
        TDAABB aux= x;
        if (!aux.ArbolVacio()){
            System.out.println(x.Raiz());
            preOrder(x.HijoIzq());
            preOrder(x.HijoDer());



        }
    }
    public static void postOrder(TDAABB x ){
        TDAABB aux = x;

        if (!aux.ArbolVacio()){
            postOrder(aux.HijoIzq());
            postOrder(aux.HijoDer());
            System.out.println(aux.Raiz());
        }
    }
    public static boolean sonIguales(TDAABB x , TDAABB z){
        // Caso 1: ambos vacíos → iguales
        if (x.ArbolVacio() && z.ArbolVacio()) {
            return true;
        }

        // Caso 2: uno vacío y el otro no → diferentes
        if (x.ArbolVacio() || z.ArbolVacio()) {
            return false;
        }

        // Caso 3: comparar la raíz
        if (x.Raiz() != z.Raiz()) {
            return false;
        }

        // Caso 4: comparar recursivamente los hijos
        boolean igualesIzq = sonIguales(x.HijoIzq(), z.HijoIzq());
        boolean igualesDer = sonIguales(x.HijoDer(), z.HijoDer());

        return igualesIzq && igualesDer;

    }
    public static boolean mismaEstructura(TDAABB x , TDAABB z){
        // Caso 1: ambos vacíos → misma estructura
        if (x.ArbolVacio() && z.ArbolVacio()) {
            return true;
        }

        // Caso 2: uno vacío y el otro no → distinta estructura
        if (x.ArbolVacio() || z.ArbolVacio()) {
            return false;
        }

        // Caso 3: comparar recursivamente hijo izquierdo y derecho
        boolean izq = mismaEstructura(x.HijoIzq(), z.HijoIzq());
        boolean der = mismaEstructura(x.HijoDer(), z.HijoDer());

        return izq && der;

    }
    public static void main(String[] args) {

        ABB a1 = new ABB();
        ABB a2 = new ABB();
        a1.InicializarArbol();
        a2.InicializarArbol();

        a1.AgregarElem(50);
        a1.AgregarElem(40);
        a1.AgregarElem(60);
        a1.AgregarElem(30);
        a1.AgregarElem(45);
        a1.AgregarElem(55);
        a1.AgregarElem(70);


        a2.AgregarElem(50);
        a2.AgregarElem(40);
        a2.AgregarElem(60);
        a2.AgregarElem(30);
        a2.AgregarElem(45);






        var res = buscarElemento(a1,99);
        System.out.println(res);


        var res2= esHoja(a1,8);
        System.out.println(res2);

        var res3= calcularProfunidad(a1,50);
        System.out.println("PROFUNDIDAD DEL NODO " + res3);

        var res4= menorValor(a1);
        System.out.println(res4);

        var res5= cantElementos(a1);
        System.out.println(res5);

        var res6=sumElementos(a1);
        System.out.println(res6);

        var res7= cantHojas(a1);
        System.out.println("CANT HOJAS " + res7);

        var res8=anteiorElemento(a1,50);
        System.out.println(res8);


        ConjuntoTDA con = new ConjuntoA();
        con.InicilizarConjunto();
        generarConjunto(a1,50,con);


        System.out.println("respuesta");
        while (!con.ConjuntoVacio()){
            int elemento = con.Elegir();
            System.out.println(elemento);
            con.Sacar(elemento);
        }


        System.out.println("=============");

        inOrden(a1);

        System.out.println("=============");
        preOrder(a1);

        System.out.println("=============");
        postOrder(a1);


        System.out.println("======?");



        System.out.println(  sonIguales(a1,a2));

        System.out.println("22222222222222====");


        System.out.println(mismaEstructura(a1,a2));
    }

}
