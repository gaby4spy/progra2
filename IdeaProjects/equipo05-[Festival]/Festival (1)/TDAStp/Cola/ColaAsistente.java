package TDAStp.Cola;


import Sistema.Asistente;

public class ColaAsistente  implements ColaAsistenteTDA {

    //imp estatica
    private Asistente colaAsistente [];
    private int inx;


    @Override
    public void InicializarCola() {
        colaAsistente= new Asistente [100];
        inx=0;
    }

    @Override
    public void Acolar(Asistente x) {
        colaAsistente[inx]=x;
        inx++;

    }

    @Override
    public void Desacolar() {
        if (inx == 0) return;
        for (int i =0; i<inx-1;i++){
            colaAsistente[i]=colaAsistente[i+1];

        }
        inx--;

    }

    @Override
    public boolean ColaVacia() {
        return (inx==0);
    }

    @Override
    public Asistente Primero() {
        return colaAsistente[0];
    }


}
