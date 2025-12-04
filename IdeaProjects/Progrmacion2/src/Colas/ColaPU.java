package Colas;

public class ColaPU implements ColaTDA {

    int [] arr;
    int inx;
    @Override
    public void InicilizarCola() {
        arr = new  int[100];
        inx=0;
    }

    @Override
    public void Acolar(int x) {
        /*a medida que acola corre todo a la derecha dejando
        el primer indice 0 libre para el ultimo elemento y el ultimo indice va el primer
         */
        for (int i=inx-1;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=x;
        inx++;
    }

    @Override
    public void Desacolar() {
        inx--;
    }

    @Override
    public boolean ColaVacia() {
        return(inx==0);
    }

    @Override
    public int Primero() {
        return arr[inx-1];
    }
}
