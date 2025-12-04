package Conjunto;

public interface ConjuntoTDA {
    void  InicilizarConjunto();
    void agregar (int x);
    int Elegir ();
    boolean ConjuntoVacio();
    void Sacar(int x) ;
    boolean Pertenece(int x);
}
