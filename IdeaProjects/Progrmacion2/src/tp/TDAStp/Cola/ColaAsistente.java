package tp.TDAStp.Cola;

import tp.Sistema.Asistente;

public class ColaAsistente implements  ColaTDA{
    class  Nodo {
        Asistente info ;
        Nodo sig;
    }

    Nodo primero ;
    Nodo ultimo;
    @Override

    public void InicilizarCola() {

        primero=null;
        ultimo=null;
    }

    @Override
    public void Acolar(Asistente x) {
        Nodo nuevo = new Nodo();
        nuevo.info=x;
        nuevo.sig=null;
        if (ultimo!=null){
            ultimo.sig=nuevo;
        }
        ultimo=nuevo;
        if (primero==null){
            primero=ultimo;
        }

    }

    @Override
    public void Desacolar() {
        primero=primero.sig;
        if (primero==null){
            ultimo=null;
        }
    }

    @Override
    public boolean ColaVacia() {
        return (ultimo==null);
    }

    @Override
    public Asistente Primero() {
        return primero.info;
    }
}
