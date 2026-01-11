package guiaEjercicios.TP4;

import Arbol.ABB;
import Arbol.TDAABB;
import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;

public class EjerABB {

    // Busca un valor en un ABB siguiendo la propiedad de orden
    public static boolean buscarElemento(TDAABB x, int val) {
        if (!x.ArbolVacio()) {
            if (x.Raiz() == val) {
                return true; // Encontrado en la raíz
            } else if (val > x.Raiz()) {
                return buscarElemento(x.HijoDer(), val); // Buscar en subárbol derecho
            } else {
                return buscarElemento(x.HijoIzq(), val); // Buscar en subárbol izquierdo
            }
        }
        return false; // Árbol vacío o no encontrado
    }

    // Verifica si un nodo con cierto valor es una hoja (sin hijos)
    public static boolean esHoja(TDAABB x, int val) {

        if (x.ArbolVacio()) {
            return false;
        }

        // Si encuentro el valor en la raíz, verifico si no tiene hijos
        if (x.Raiz() == val) {
            return x.HijoDer().ArbolVacio() && x.HijoIzq().ArbolVacio();
        }

        // Busco recursivamente hacia donde corresponde
        if (val > x.Raiz()) {
            return esHoja(x.HijoDer(), val);
        } else {
            return esHoja(x.HijoIzq(), val);
        }
    }

    // Calcula la profundidad de un nodo (distancia desde la raíz)
    public static int calcularProfunidad(TDAABB x, int val) {

        TDAABB aux = x;
        int profundiad = 0;

        while (!aux.ArbolVacio()) {
            if (aux.Raiz() == val) {
                return profundiad; // Encontrado
            } else if (val > aux.Raiz()) {
                aux = aux.HijoDer(); // Bajo a la derecha
                profundiad++;
            } else {
                aux = aux.HijoIzq(); // Bajo a la izquierda
                profundiad++;
            }
        }

        return -1; // No encontrado
    }

    // Devuelve el valor menor del ABB (siempre el más a la izquierda)
    public static int menorValor(TDAABB x) {
        TDAABB aux = x;

        while (!aux.HijoIzq().ArbolVacio()) {
            aux = aux.HijoIzq(); // Avanza hacia la izquierda
        }

        return aux.Raiz(); // El menor
    }

    // Cuenta la cantidad total de nodos del árbol
    public static int cantElementos(TDAABB x) {

        if (x.ArbolVacio()) {
            return 0;
        }

        // 1 (raíz) + elementos del hijo izquierdo + elementos del derecho
        return 1 + cantElementos(x.HijoIzq()) + cantElementos(x.HijoDer());
    }

    // Suma todos los valores de un ABB
    public static int sumElementos(TDAABB x) {

        if (x.ArbolVacio()) {
            return 0;
        }

        return x.Raiz() + sumElementos(x.HijoIzq()) + sumElementos(x.HijoDer());
    }

    // Cuenta cuántas hojas tiene el árbol
    public static int cantHojas(TDAABB x) {

        if (x.ArbolVacio()) {
            return 0;
        }

        // Si no tiene hijos → es hoja
        if (x.HijoIzq().ArbolVacio() && x.HijoDer().ArbolVacio()) {
            return 1;
        }

        // Suma de hojas de ambos subárboles
        return cantHojas(x.HijoIzq()) + cantHojas(x.HijoDer());
    }

    // Devuelve el anterior inmediato: el mayor de los menores (predecesor)
    public static int anteiorElemento(TDAABB x, int val) {
        int anterior = -1;
        TDAABB actual = x;

        while (!actual.ArbolVacio()) {
            if (actual.Raiz() == val) {
                return anterior; // Predecesor encontrado
            } else if (val > actual.Raiz()) {
                anterior = actual.Raiz(); // Posible anterior
                actual = actual.HijoDer();
            } else {
                anterior = actual.Raiz();
                actual = actual.HijoIzq();
            }
        }

        return -1;
    }

    // Genera un conjunto con los elementos mayores a un valor
    // (Recorrido inorden para mantener orden creciente)
    public static void generarConjunto(TDAABB x, int valor, ConjuntoTDA c) {
        if (!x.ArbolVacio()) {

            generarConjunto(x.HijoIzq(), valor, c);

            if (x.Raiz() > valor) {
                c.agregar(x.Raiz());
            }

            generarConjunto(x.HijoDer(), valor, c);
        }
    }

    // Recorrido INORDEN: izquierda - raíz - derecha (devuelve orden creciente)
    public static void inOrden(TDAABB x) {
        TDAABB aux = x;
        if (!aux.ArbolVacio()) {
            inOrden(aux.HijoIzq());
            System.out.println(aux.Raiz());
            inOrden(aux.HijoDer());
        }
    }

    // Recorrido PREORDEN: raíz - izquierda - derecha
    public static void preOrder(TDAABB x) {
        TDAABB aux = x;
        if (!aux.ArbolVacio()) {
            System.out.println(x.Raiz());
            preOrder(x.HijoIzq());
            preOrder(x.HijoDer());
        }
    }

    // Recorrido POSTORDEN: izquierda - derecha - raíz
    public static void postOrder(TDAABB x) {
        TDAABB aux = x;

        if (!aux.ArbolVacio()) {
            postOrder(aux.HijoIzq());
            postOrder(aux.HijoDer());
            System.out.println(aux.Raiz());
        }
    }

    // Compara si dos ABB son completamente iguales (estructura + valores)
    public static boolean sonIguales(TDAABB x, TDAABB z) {

        if (x.ArbolVacio() && z.ArbolVacio()) {
            return true; // Ambos vacíos
        }

        if (x.ArbolVacio() || z.ArbolVacio()) {
            return false; // Uno vacío, otro no
        }

        if (x.Raiz() != z.Raiz()) {
            return false; // Valores diferentes
        }

        // Comparar estructura y valores recursivamente
        boolean igualesIzq = sonIguales(x.HijoIzq(), z.HijoIzq());
        boolean igualesDer = sonIguales(x.HijoDer(), z.HijoDer());

        return igualesIzq && igualesDer;
    }

    // Verifica si ambos árboles tienen la misma estructura, NO los mismos valores
    public static boolean mismaEstructura(TDAABB x, TDAABB z) {

        if (x.ArbolVacio() && z.ArbolVacio()) {
            return true;
        }

        if (x.ArbolVacio() || z.ArbolVacio()) {
            return false;
        }

        // Compara forma del árbol, no valores
        boolean izq = mismaEstructura(x.HijoIzq(), z.HijoIzq());
        boolean der = mismaEstructura(x.HijoDer(), z.HijoDer());

        return izq && der;
    }

    // ===============================
    // PRUEBAS
    // ===============================
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

        var res = buscarElemento(a1, 99);
        System.out.println(res);

        var res2 = esHoja(a1, 8);
        System.out.println(res2);

        var res3 = calcularProfunidad(a1, 50);
        System.out.println("PROFUNDIDAD DEL NODO " + res3);

        var res4 = menorValor(a1);
        System.out.println(res4);

        var res5 = cantElementos(a1);
        System.out.println(res5);

        var res6 = sumElementos(a1);
        System.out.println(res6);

        var res7 = cantHojas(a1);
        System.out.println("CANT HOJAS " + res7);

        var res8 = anteiorElemento(a1, 50);
        System.out.println(res8);

        ConjuntoTDA con = new ConjuntoA();
        con.InicilizarConjunto();
        generarConjunto(a1, 50, con);

        System.out.println("respuesta");
        while (!con.ConjuntoVacio()) {
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

        System.out.println(sonIguales(a1, a2));

        System.out.println("22222222222222====");

        System.out.println(mismaEstructura(a1, a2));
    }
}
