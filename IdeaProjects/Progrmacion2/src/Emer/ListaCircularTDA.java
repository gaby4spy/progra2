package Emer;

public interface ListaCircularTDA {
    void InicializarLista();
    void Agregar(int x);     // agrega un elemento al final de la lista circular
    boolean ListaVacia();
    int Primero();           // devuelve el primer elemento
    void Eliminar(int x);    // elimina la primera aparición
    void Avanzar();          // avanza el puntero al siguiente nodo
}

