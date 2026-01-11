package TP2.punto9;

public final  class Posicion {
    final int fila ;
    final int columna ;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public Posicion mover (int df,int dc ){
        return new Posicion(df+this.fila,dc+this.columna);
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
