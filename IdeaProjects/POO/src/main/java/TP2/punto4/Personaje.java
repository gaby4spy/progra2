package TP2.punto4;

public class Personaje {
    String nombre;
    int vidas;
    SuperPoder superPoder;
    EscudoProtector escudoProtector;


    public Personaje(EscudoProtector escudoProtector, SuperPoder superPoder, int vidas, String nombre) {
        this.escudoProtector = escudoProtector;
        this.superPoder = superPoder;
        this.vidas = vidas;
        this.nombre = nombre;
    }

    public boolean estaVivo(){
        return (vidas>0);
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }


    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", vidas=" + vidas +
                ", superPoder=" + superPoder +
                ", escudoProtector=" + escudoProtector +
                '}';
    }
}
