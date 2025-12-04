package Grafos;

import tp.TDAStp.Conjuntoinfo.ConjuntoTDA;

public interface GrafoTDA {
    void InicializarGrafo();
    void AgregarVertice(int v);
    void EliminarVertice(int v);
    void AgregarArista(int v1,int v2,int p);
    int PesoArista(int v1,int v2);
    ConjuntoTDA Vertices();
    boolean ExisteArista(int v1,int v2);
    void EliminarArista (int v1,int v2);


}
