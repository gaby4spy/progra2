package Colas.ColaPrioridad;

//ESTRATEGIA 2 -mas facil
public class ColaPrioridadAO implements ColaPrioridadTDA {
    Elemento[] elementos ;
    int indice;
    @Override
    public void InicializarCola() {
        elementos = new Elemento[100];
        indice=0;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        int j = indice;
        while (j>0 &&  elementos[j-1].prioridad > prioridad){
            elementos[j] = elementos[j-1]; //toma el elemento de la posicion anterior y lo pone en la acutal
            j--;
        }
        elementos[j] = new Elemento();
        elementos[j].valor=x;
        elementos[j].prioridad=prioridad;

        indice++;
    }

    @Override
    public void Desacolar() {

        indice--;

    }

    @Override
    public boolean ColaVacia() {
        return (indice ==0);
    }

    @Override
    public int Primero() {

        return elementos[indice-1].valor;
    }

    @Override
    public int Prioidad() {
        return elementos[indice-1].prioridad;
    }

}
