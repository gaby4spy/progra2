package EstructurasEnlazadas.ColasPrioridad;

import Colas.ColaPrioridad.ColaPrioridadAO;
import Colas.ColaPrioridad.ColaPrioridadTDA;

public class ColaPrioridadLD implements ColaPrioridadTDA {

    class  NodoPrioirdad {
        int info;
        int prioridad;
        NodoPrioirdad sig;
    }

    NodoPrioirdad primero;
    @Override
    public void InicializarCola() {
        primero=null;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {

        NodoPrioirdad nuevo = new NodoPrioirdad();
        nuevo.info=x;
        nuevo.prioridad=prioridad;
        if (primero==null || primero.prioridad<prioridad){
            nuevo.sig=primero;
            primero=nuevo;
        }else {
            NodoPrioirdad aux = primero;
            while (aux.sig!=null && aux.sig.prioridad>prioridad){
                aux=aux.sig;
            }
            nuevo.sig=aux.sig;
            aux.sig=nuevo;
        }
    }

    @Override
    public void Desacolar() {
        primero=primero.sig;
    }

    @Override
    public boolean ColaVacia() {
        return (primero==null);
    }

    @Override
    public int Primero() {
        return primero.info;
    }

    @Override
    public int Prioidad() {
        return primero.prioridad;
    }
}
