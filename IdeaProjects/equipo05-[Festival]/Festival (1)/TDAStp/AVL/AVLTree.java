package TDAStp.AVL;


public class AVLTree implements TDAABB {
    private AVLNode raiz;

    @Override
    public int Raiz() {
        return raiz.dato;
    }

    @Override
    public AVLTree HijoIzq() {
        AVLTree izq = new AVLTree();
        izq.raiz = raiz.izquierdo;
        return izq;
    }

    @Override
    public AVLTree HijoDer() {
        AVLTree der= new AVLTree();
        der.raiz=raiz.derecho;
        return der;
    }

    @Override
    public boolean ArbolVacio() {
        return raiz==null;
    }

    @Override
    public void InicializarArbol() {
        raiz=null;

    }

    // Inserta un valor entero en el AVL
    public void AgregarElem(int x) {
        raiz = insertar(x, raiz);
    }

    @Override
    public void EliminarElem(int x) {
        raiz = eliminar(raiz, x);

    }

    // Inserción recursiva con reequilibrio
    private AVLNode insertar(int x, AVLNode t) {
        if (t == null) {
            t = new AVLNode(x, null, null);
        } else if (x < t.dato) {
            t.izquierdo = insertar(x, t.izquierdo);

            // desequilibrio hacia la izquierda
            if (altura(t.izquierdo) - altura(t.derecho) == 2) {
                if (x < t.izquierdo.dato) {
                    // Caso 1: rotación simple derecha (Left-Left)
                    t = rotacionHijoIzquierdo(t);
                } else {
                    // Caso 2: rotación doble derecha (Left-Right)
                    t = rotacionDobleHijoIzquierdo(t);
                }
            }
        } else if (x > t.dato) {
            t.derecho = insertar(x, t.derecho);

            // desequilibrio hacia la derecha
            if (altura(t.derecho) - altura(t.izquierdo) == 2) {
                if (x > t.derecho.dato) {
                    // Caso 4: rotación simple izquierda (Right-Right)
                    t = rotacionHijoDerecho(t);
                } else {
                    // Caso 3: rotación doble izquierda (Right-Left)
                    t = rotacionDobleHijoDerecho(t);
                }
            }
        } // Si x == t.dato, ignoramos (no se permiten duplicados)

        // Actualiza altura
        t.altura = max(altura(t.izquierdo), altura(t.derecho)) + 1;
        return t;
    }






    // Máximo entre dos enteros
    private int max(int izquierdaAltura, int derechaAltura) {
        if (izquierdaAltura > derechaAltura) {
            return izquierdaAltura;
        } else {
            return derechaAltura;
        }
    }




    // Rotación simple derecha (sobre t) => sube t.izquierdo
    private AVLNode rotacionHijoIzquierdo(AVLNode t) {
        AVLNode aux2 = t.izquierdo;
        t.izquierdo = aux2.derecho;
        aux2.derecho = t;

        t.altura = max(altura(t.izquierdo), altura(t.derecho)) + 1;
        aux2.altura = max(altura(aux2.izquierdo), t.altura) + 1;
        return aux2;
    }


    // Rotación simple izquierda (sobre t) => sube t.derecho
    private AVLNode rotacionHijoDerecho(AVLNode t) {
        AVLNode aux2 = t.derecho;
        t.derecho = aux2.izquierdo;
        aux2.izquierdo = t;

        t.altura = max(altura(t.izquierdo), altura(t.derecho)) + 1;
        aux2.altura = max(altura(aux2.derecho), t.altura) + 1;
        return aux2;
    }

    // Rotación doble derecha (Left-Right): primero izq-izq del hijo, luego der-der del t
    private AVLNode rotacionDobleHijoIzquierdo(AVLNode aux) {
        aux.izquierdo = rotacionHijoDerecho(aux.izquierdo); //rotacion izquierda
        return rotacionHijoIzquierdo(aux); //rotacion derecha
    }

    // Rotación doble izquierda (Right-Left): primero der-der del hijo, luego izq-izq del t
    private AVLNode rotacionDobleHijoDerecho(AVLNode aux) {
        aux.derecho = rotacionHijoIzquierdo(aux.derecho); // rotacion simple derecha
        return rotacionHijoDerecho(aux); // rotacion simple izquierda
    }

    // Altura segura (árbol vacío = -1)
    private int altura(AVLNode nodo) {
        if (nodo == null) {
            return -1;
        } else {
            return nodo.altura;
        }
    }























    // ==== Métodos de utilidad para pruebas/visualización ====

    private AVLNode eliminar(AVLNode nodo, int x) {
        if (nodo == null) return null;

        if (x < nodo.dato)
            nodo.izquierdo = eliminar(nodo.izquierdo, x);
        else if (x > nodo.dato)
            nodo.derecho = eliminar(nodo.derecho, x);
        else {
            if (nodo.izquierdo == null)
                return nodo.derecho;
            else if (nodo.derecho == null)
                return nodo.izquierdo;
            else {
                AVLNode reemplazo = nodo.derecho;
                while (reemplazo.izquierdo != null)
                    reemplazo = reemplazo.izquierdo;
                nodo.dato = reemplazo.dato;
                nodo.derecho = eliminar(nodo.derecho, reemplazo.dato);
            }
        }
        nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;
        return balancear(nodo);
    }

    private AVLNode balancear(AVLNode nodo) {
        int balance = altura(nodo.izquierdo) - altura(nodo.derecho);
        if (balance == 2) {
            if (altura(nodo.izquierdo.izquierdo) >= altura(nodo.izquierdo.derecho))
                nodo = rotacionHijoIzquierdo(nodo);
            else
                nodo = rotacionDobleHijoIzquierdo(nodo);
        } else if (balance == -2) {
            if (altura(nodo.derecho.derecho) >= altura(nodo.derecho.izquierdo))
                nodo = rotacionHijoDerecho(nodo);
            else
                nodo = rotacionDobleHijoDerecho(nodo);
        }
        return nodo;
    }
}
