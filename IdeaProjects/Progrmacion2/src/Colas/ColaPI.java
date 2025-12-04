package Colas;

public class ColaPI implements  ColaTDA {

    //IMP MAS FACIL
    int [] arr;
    int inx;

    @Override
    public void InicilizarCola() {
        arr = new int[100];
        inx=0;
    }

    @Override
    public void Acolar(int x) {
        //el ultimo elemento va a parar a la ultima posicion
        arr[inx]=x;
        inx++;
    }

    @Override
    public void Desacolar() {
        //cuando se saque un elemento queda el indice 0 vacio (el primero)
        // por lo que se debe hacer un corrimiento de derecha a izquierda
        for (int i=0; i<inx-1;i++){
            arr[i]=arr[i+1];
        }
        inx--;




    }

    @Override
    public boolean ColaVacia() {
        return (inx==0);
    }

    @Override
    public int Primero() {
        return arr[0];
    }


}
