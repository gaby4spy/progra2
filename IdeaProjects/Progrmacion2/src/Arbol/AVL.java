package Arbol;

public class AVL implements TDAABB {
    NodoAVL raiz;

    @Override
    public int Raiz() {
        return raiz.dato;
    }

    @Override
    public TDAABB HijoIzq() {
        return raiz.hijoIzq;
    }

    @Override
    public TDAABB HijoDer() {
        return raiz.hijoDer;
    }

    @Override
    public boolean ArbolVacio() {
        return raiz == null;
    }

    @Override
    public void InicializarArbol() {
        raiz = null;
    }


    // INSERCIÓN

    @Override
    public void AgregarElem(int x) {
        raiz = insertar(raiz, x);
    }

    private NodoAVL insertar(NodoAVL nodo, int x) {
        if (nodo == null) {
            NodoAVL nuevo = new NodoAVL();
            nuevo.dato = x;
            nuevo.hijoIzq = new AVL();
            nuevo.hijoIzq.InicializarArbol();
            nuevo.hijoDer = new AVL();
            nuevo.hijoDer.InicializarArbol();
            nuevo.altura = 0;
            return nuevo;
        }

        if (x < nodo.dato) {
            nodo.hijoIzq = insertarEnSub((AVL) nodo.hijoIzq, x);
        } else if (x > nodo.dato) {
            nodo.hijoDer = insertarEnSub((AVL) nodo.hijoDer, x);
        }

        // actualizar altura
        int altIzq = alturaSub(nodo.hijoIzq);
        int altDer = alturaSub(nodo.hijoDer);
        nodo.altura = Math.max(altIzq, altDer) + 1;

        // balancear
        return balancear(nodo);
    }

    private AVL insertarEnSub(AVL sub, int x) {
        sub.raiz = insertar(sub.raiz, x);
        return sub;
    }

    private int alturaSub(TDAABB sub) {
        if (sub.ArbolVacio()) return -1;
        return ((NodoAVL)((AVL) sub).raiz).altura;
    }

    private int factorBalance(NodoAVL n) {
        return alturaSub(n.hijoIzq) - alturaSub(n.hijoDer);
    }

    private int RaizValor(TDAABB a) {
        if (a.ArbolVacio()) return -9999;
        return a.Raiz();
    }


    // ROTACIONES

    private NodoAVL rotacionDerecha(NodoAVL y) {
        if (y == null || ((AVL) y.hijoIzq).ArbolVacio()) return y;

        AVL xAVL = (AVL) y.hijoIzq;
        NodoAVL x = xAVL.raiz;
        AVL T2 = (AVL) x.hijoDer;

        x.hijoDer = new AVL();
        ((AVL) x.hijoDer).raiz = y;
        y.hijoIzq = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        if (x == null || ((AVL) x.hijoDer).ArbolVacio()) return x;

        AVL yAVL = (AVL) x.hijoDer;
        NodoAVL y = yAVL.raiz;
        AVL T2 = (AVL) y.hijoIzq;

        y.hijoIzq = new AVL();
        ((AVL) y.hijoIzq).raiz = x;
        x.hijoDer = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    private void actualizarAltura(NodoAVL n) {
        n.altura = Math.max(alturaSub(n.hijoIzq), alturaSub(n.hijoDer)) + 1;
    }

    private AVL rotacionDerechaSub(AVL sub) {
        sub.raiz = rotacionDerecha(sub.raiz);
        return sub;
    }

    private AVL rotacionIzquierdaSub(AVL sub) {
        sub.raiz = rotacionIzquierda(sub.raiz);
        return sub;
    }

    private NodoAVL balancear(NodoAVL n) {
        int fb = factorBalance(n);

        // LL
        if (fb > 1 && RaizValor(n.hijoIzq) > n.dato)
            return rotacionDerecha(n);

        // RR
        if (fb < -1 && RaizValor(n.hijoDer) < n.dato)
            return rotacionIzquierda(n);

        // LR
        if (fb > 1 && RaizValor(n.hijoIzq) < n.dato) {
            n.hijoIzq = rotacionIzquierdaSub((AVL) n.hijoIzq);
            return rotacionDerecha(n);
        }

        // RL
        if (fb < -1 && RaizValor(n.hijoDer) > n.dato) {
            n.hijoDer = rotacionDerechaSub((AVL) n.hijoDer);
            return rotacionIzquierda(n);
        }

        return n;
    }


    // ELIMINAR

    @Override
    public void EliminarElem(int x) {
        raiz = eliminar(raiz, x);
    }

    private NodoAVL eliminar(NodoAVL nodo, int x) {
        if (nodo == null) return null;

        if (x < nodo.dato)
            nodo.hijoIzq = insertarEnSub((AVL) nodo.hijoIzq, x);
        else if (x > nodo.dato)
            nodo.hijoDer = insertarEnSub((AVL) nodo.hijoDer, x);
        else {
            if (((AVL) nodo.hijoIzq).ArbolVacio())
                return ((AVL) nodo.hijoDer).raiz;
            else if (((AVL) nodo.hijoDer).ArbolVacio())
                return ((AVL) nodo.hijoIzq).raiz;

            nodo.dato = menorValor(((AVL) nodo.hijoDer).raiz);
            nodo.hijoDer = insertarEnSub((AVL) nodo.hijoDer, nodo.dato);
        }

        actualizarAltura(nodo);
        return balancear(nodo);
    }

    private int menorValor(NodoAVL n) {
        while (!((AVL) n.hijoIzq).ArbolVacio()) {
            n = ((AVL) n.hijoIzq).raiz;
        }
        return n.dato;
    }
}
