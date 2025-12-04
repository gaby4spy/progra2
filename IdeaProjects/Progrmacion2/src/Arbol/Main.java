package Arbol;

public class Main {


    public static boolean estaElementoIterativo(TDAABB arbol, int x) {
        TDAABB actual = arbol; // empezamos desde el árbol completo

        while (!actual.ArbolVacio()) {
            int valorRaiz = actual.Raiz();

            if (valorRaiz == x) {
                return true; // encontramos el elemento
            } else if (x < valorRaiz) {
                actual = actual.HijoIzq(); // vamos al subárbol izquierdo
            } else {
                actual = actual.HijoDer(); // vamos al subárbol derecho
            }
        }



        return false;  
    }

    public static void recorrerSubIzq(TDAABB a){
        TDAABB aux = a.HijoIzq();
        while (!aux.ArbolVacio()){
            System.out.println(aux.Raiz()); // imprime el valor
            aux = aux.HijoIzq();           // avanza hacia el hijo izquierdo
        }
    }


    public static  void  mostrarElementos (TDAABB a){

        while (!a.ArbolVacio()){
            System.out.println(a.Raiz());
            a.EliminarElem(a.Raiz());
        }

    }

    public  static  boolean  esHoja(TDAABB a , int elemento){
        TDAABB actual = a;

        boolean flag = false;
        while (!actual.ArbolVacio()){
            int valorRaiz= actual.Raiz();


            if (valorRaiz==elemento){
                if (actual.HijoDer().ArbolVacio()  && actual.HijoIzq().ArbolVacio() ){
                    flag=true;
                }
            } else if (elemento<valorRaiz) {
                actual = actual.HijoIzq();

            }else {
                actual = actual.HijoDer(); // vamos al subárbol derecho
            }
        }


        return flag;
    }



    public static void main(String[] args) {
        /*TDAABB j = new ABB();
        j.InicializarArbol();

        j.AgregarElem(40);
        j.AgregarElem(30);
        j.AgregarElem(50);
        j.AgregarElem(20);
        j.AgregarElem(35);
        j.AgregarElem(32);
        j.AgregarElem(25);
        j.AgregarElem(10);
        j.AgregarElem(5);


        System.out.println(  esHoja(j,30));




        /*TDAABB nodoActual = j; // raíz
        int profundidad = 0;

        int valor=10;
        while (!nodoActual.ArbolVacio()) {
            if (nodoActual.Raiz() == valor) {
                System.out.println("encontrado");
                System.out.println("profundidad: " + profundidad); // esto da 1
                return;
            } else if (valor > nodoActual.Raiz()) {
                nodoActual = nodoActual.HijoDer();
            } else {
                nodoActual = nodoActual.HijoIzq();
            }
            profundidad += 1;
        }

        j.EliminarElem(40);

        TDAABB nodoActual = j; // raíz
        while (!nodoActual.ArbolVacio()) {
            System.out.println("RAIZ: " + nodoActual.Raiz());

            if (!nodoActual.HijoDer().ArbolVacio()) {
                System.out.println("HIJO DERECHO: " + nodoActual.HijoDer().Raiz());
            } else {
                System.out.println("HIJO DERECHO: null");
            }

            if (!nodoActual.HijoIzq().ArbolVacio()) {
                System.out.println("HIJO IZQUIERDO: " + nodoActual.HijoIzq().Raiz());
            } else {
                System.out.println("HIJO IZQUIERDO: null");
            }

            nodoActual = nodoActual.HijoIzq();


        }*/




        ABB b = new ABB();
        b.InicializarArbol();

        b.AgregarElem(30);
        b.AgregarElem(20);
        b.AgregarElem(10);


        System.out.println(b.raiz.dato);

        System.out.println("==========");

            AVL arbol1 = new AVL();
            arbol1.InicializarArbol();
            arbol1.AgregarElem(30);
            arbol1.AgregarElem(20);
            arbol1.AgregarElem(10);

        System.out.println(arbol1.raiz.dato);
        System.out.println(arbol1.HijoDer().Raiz());



    }
}
