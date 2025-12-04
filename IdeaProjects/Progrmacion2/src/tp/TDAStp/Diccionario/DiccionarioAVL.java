package tp.TDAStp.Diccionario;


import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;
import tp.Sistema.Asistente;

public class DiccionarioAVL implements DiccionarioSimpleTDAAVL {

    private class NodoAVL {
        int clave;
        Asistente valor;
        NodoAVL izq, der;
        int altura;
    }

    private NodoAVL raiz;


    public void InicializarDiccionario() {
        raiz = null;
    }

    private int altura(NodoAVL n) {
        return n == null ? 0 : n.altura;
    }

    private int balance(NodoAVL n) {
        return n == null ? 0 : altura(n.izq) - altura(n.der);
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izq;
        NodoAVL T2 = x.der;

        x.der = y;
        y.izq = T2;

        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;

        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.der;
        NodoAVL T2 = y.izq;

        y.izq = x;
        x.der = T2;

        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;

        return y;
    }

    private NodoAVL insertar(NodoAVL nodo, int clave, Asistente valor) {
        if (nodo == null) {
            NodoAVL nuevo = new NodoAVL();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.altura = 1;
            return nuevo;
        }

        if (clave < nodo.clave)
            nodo.izq = insertar(nodo.izq, clave, valor);
        else if (clave > nodo.clave)
            nodo.der = insertar(nodo.der, clave, valor);
        else { // actualizo valor
            nodo.valor = valor;
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        int fb = balance(nodo);

        if (fb > 1 && clave < nodo.izq.clave) return rotarDerecha(nodo);
        if (fb < -1 && clave > nodo.der.clave) return rotarIzquierda(nodo);
        if (fb > 1 && clave > nodo.izq.clave) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }
        if (fb < -1 && clave < nodo.der.clave) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL eliminar(NodoAVL nodo, int clave) {
        if (nodo == null) return null;

        if (clave < nodo.clave) nodo.izq = eliminar(nodo.izq, clave);
        else if (clave > nodo.clave) nodo.der = eliminar(nodo.der, clave);
        else {
            if (nodo.izq == null) nodo = nodo.der;
            else if (nodo.der == null) nodo = nodo.izq;
            else {
                NodoAVL temp = minimo(nodo.der);
                nodo.clave = temp.clave;
                nodo.valor = temp.valor;
                nodo.der = eliminar(nodo.der, temp.clave);
            }
        }

        if (nodo == null) return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        int fb = balance(nodo);

        if (fb > 1 && balance(nodo.izq) >= 0) return rotarDerecha(nodo);
        if (fb > 1 && balance(nodo.izq) < 0) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }
        if (fb < -1 && balance(nodo.der) <= 0) return rotarIzquierda(nodo);
        if (fb < -1 && balance(nodo.der) > 0) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL minimo(NodoAVL nodo) {
        while (nodo.izq != null) nodo = nodo.izq;
        return nodo;
    }

    private NodoAVL buscar(NodoAVL nodo, int clave) {
        if (nodo == null || nodo.clave == clave) return nodo;
        if (clave < nodo.clave) return buscar(nodo.izq, clave);
        else return buscar(nodo.der, clave);
    }


    public void agregar(int clave, Asistente valor) {
        raiz = insertar(raiz, clave, valor);
    }

    public void Eliminar(int clave) {
        raiz = eliminar(raiz, clave);
    }


    public Asistente Recuperar(int clave) {
        NodoAVL n = buscar(raiz, clave);
        if (n == null) throw new RuntimeException("Clave no encontrada");
        return n.valor;
    }


    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoA();
        c.InicilizarConjunto();
        inOrdenAgregar(raiz, c);
        return c;
    }

    private void inOrdenAgregar(NodoAVL nodo, ConjuntoTDA c) {
        if (nodo != null) {
            inOrdenAgregar(nodo.izq, c);
            c.agregar(nodo.clave);
            inOrdenAgregar(nodo.der, c);
        }
    }
}
