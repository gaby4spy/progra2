package Colas.ColaPrioridad;

public class ColaPrioridadDA implements ColaPrioridadTDA {

    //IMP 1

    int [] elementos;
    int [] prioridades;
    int indice;
    @Override
    public void InicializarCola() {
        elementos= new int[100];
        prioridades= new  int[100];
        indice = 0;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        int j = indice;
        while (j>0&&prioridades[j-1]>prioridad){
            elementos[j]=elementos[j-1];
            prioridades[j]=prioridades[j-1];
            j--;
        }
        elementos[j]=x;
        prioridades[j]=prioridad;
        indice++;
    }

    @Override
    public void Desacolar() {
        indice--;
    }

    @Override
    public boolean ColaVacia() {
        return (indice==0);

    }

    @Override
    public int Primero() {
        return elementos[indice-1];
    }

    @Override
    public int Prioidad() {
        return prioridades[indice-1];
    }
}
