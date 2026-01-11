package TDAStp.AVL;

public interface TDAABB {
    // siempre que el árbol esté inicializado y no esté vacío
    int Raiz();

    // siempre que el árbol esté inicializado y no esté vacío
    TDAABB HijoIzq();

    // siempre que el árbol esté inicializado y no esté vacío
    TDAABB HijoDer();

    // siempre que el árbol esté inicializado
    boolean ArbolVacio();

    // siempre que el árbol esté inicializado
    void InicializarArbol();

    // siempre que el árbol esté inicializado
    void AgregarElem(int x);

    void EliminarElem(int x);
}
