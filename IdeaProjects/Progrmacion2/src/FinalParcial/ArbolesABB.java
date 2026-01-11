package FinalParcial;

import Arbol.ABB;
import Arbol.TDAABB;

public class ArbolesABB {
    public static  boolean existeElemento(TDAABB arbol , int valor){
        TDAABB aux = arbol;

        while (!aux.ArbolVacio()){
            if (aux.Raiz()==valor){

                return true;
            }
            if (valor>aux.Raiz()){
                aux=aux.HijoDer();
            }else{
                aux=aux.HijoIzq();
            }
        }

        return false;
    }
    public static boolean esHoja(TDAABB arbol, int valor) {
        TDAABB aux = arbol;

        while (!aux.ArbolVacio()) {
            if (aux.Raiz() == valor) {
                // Si ambos hijos son vacíos, es hoja
                return aux.HijoIzq().ArbolVacio() && aux.HijoDer().ArbolVacio();
            }
            // Seguir buscando según BST
            if (valor > aux.Raiz()) {
                aux = aux.HijoDer();
            } else {
                aux = aux.HijoIzq();
            }
        }

        // No se encontró el valor
        return false;
    }
    public static int profundidad(TDAABB arbol , int valor){
        TDAABB aux = arbol;
        int profundidad=0;

        while (!aux.ArbolVacio()) {
            if (aux.Raiz() == valor) {
                // Si ambos hijos son vacíos, es hoja
                return profundidad;
            }
            // Seguir buscando según BST
            if (valor > aux.Raiz()) {
                aux = aux.HijoDer();
                profundidad++;
            } else {
                aux = aux.HijoIzq();
                profundidad++;
            }
        }

        return -1;
    }
    public static int menorElemento(TDAABB arbol){
        TDAABB aux = arbol;


        while (!aux.HijoIzq().ArbolVacio()) {
            aux=aux.HijoIzq();
        }

       return aux.Raiz();
    }
    public static int cantElementos(TDAABB arbol) {
        if (arbol.ArbolVacio()) {
            return 0; // Si el árbol está vacío, no hay elementos
        } else {
            // 1 (la raíz) + elementos del hijo izquierdo + elementos del hijo derecho
            return 1 + cantElementos(arbol.HijoIzq()) + cantElementos(arbol.HijoDer());
        }
    }
    public static int suElementos(TDAABB arbol) {
        if (arbol.ArbolVacio()) {
            return 0; // Si el árbol está vacío, no hay elementos
        } else {
            // 1 (la raíz) + elementos del hijo izquierdo + elementos del hijo derecho
            return arbol.Raiz() + suElementos(arbol.HijoIzq()) + suElementos(arbol.HijoDer());

        }
    }
    public static int cantHojas(TDAABB arbol){

        if (arbol.ArbolVacio()) {
            return 0;
        }

        // Si no tiene hijos → es hoja
        if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {
            return 1;
        }

        // Suma de hojas de ambos subárboles
        return cantHojas(arbol.HijoIzq()) + cantHojas(arbol.HijoDer());
    }
    public static int altura(TDAABB arbol) {
        if (arbol.ArbolVacio()) {
            return 0;
        } else {
            int altIzq = altura(arbol.HijoIzq());
            int altDer = altura(arbol.HijoDer());
            return 1 + Math.max(altIzq, altDer);
        }
    }
    public static boolean mismaForma(TDAABB a1, TDAABB a2) {
        if (a1.ArbolVacio() && a2.ArbolVacio()) return true;
        if (a1.ArbolVacio() || a2.ArbolVacio()) return false;
        return mismaForma(a1.HijoIzq(), a2.HijoIzq()) && mismaForma(a1.HijoDer(), a2.HijoDer());
    }
    public static boolean arbolesIguales(TDAABB a1, TDAABB a2) {
        if (a1.ArbolVacio() && a2.ArbolVacio()) return true;
        if (a1.ArbolVacio() || a2.ArbolVacio()) return false;
        if (a1.Raiz() != a2.Raiz()) return false;
        return arbolesIguales(a1.HijoIzq(), a2.HijoIzq()) && arbolesIguales(a1.HijoDer(), a2.HijoDer());
    }
    public static int cantEnNivel(TDAABB arbol, int nivel) {
        if (arbol.ArbolVacio()) return 0;
        if (nivel == 0) return 1;
        return cantEnNivel(arbol.HijoIzq(), nivel - 1) + cantEnNivel(arbol.HijoDer(), nivel - 1);
    }
    public static void mostrarInOrden(TDAABB arbol) {
        if (!arbol.ArbolVacio()) {
            mostrarInOrden(arbol.HijoIzq());
            System.out.print(arbol.Raiz() + " ");
            mostrarInOrden(arbol.HijoDer());
        }
    }
    public static void mostrarPreOrden(TDAABB arbol) {
        if (!arbol.ArbolVacio()) {
            System.out.print(arbol.Raiz() + " ");
            mostrarPreOrden(arbol.HijoIzq());
            mostrarPreOrden(arbol.HijoDer());
        }
    }
    public static void mostrarPostOrden(TDAABB arbol) {
        if (!arbol.ArbolVacio()) {
            mostrarPostOrden(arbol.HijoIzq());
            mostrarPostOrden(arbol.HijoDer());
            System.out.print(arbol.Raiz() + " ");
        }
    }
    public static int anteior(TDAABB arbol, int valor){

        TDAABB aux = arbol;
        int anterior=aux.Raiz();
        int actual =aux.Raiz();
        while (!aux.ArbolVacio()){
            if (aux.Raiz()==valor){
                return anterior;
            }
            if (valor>aux.Raiz()){
                anterior=aux.Raiz();
                actual=aux.HijoDer().Raiz();
                aux=aux.HijoDer();
            }else{
                anterior=aux.Raiz();
                actual=aux.HijoIzq().Raiz();
                aux=aux.HijoIzq();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TDAABB arbol1 = new ABB();
        arbol1.InicializarArbol();

        arbol1.AgregarElem(50); 
        arbol1.AgregarElem(30);
        arbol1.AgregarElem(70);
        arbol1.AgregarElem(20);
        arbol1.AgregarElem(40);
        arbol1.AgregarElem(60);
        arbol1.AgregarElem(80);


        System.out.println(anteior(arbol1,60));



    }
}
