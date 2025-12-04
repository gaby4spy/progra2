package Arbol;

public interface TDAABB {
    // siempre que el �rbol est� inicializado y no est� vac�o
    int Raiz();
    // siempre que el �rbol est� inicializado y no est� vac�o
    TDAABB HijoIzq();
    // siempre que el �rbol est� inicializado y no est� vac�o
    TDAABB HijoDer();
    // siempre que el �rbol est� inicializado
    boolean ArbolVacio();

    void InicializarArbol();
    // siempre que el �rbol est� inicializado
    void AgregarElem(int x);
    // siempre que el �rbol est� inicializado
    void EliminarElem(int x);
}
