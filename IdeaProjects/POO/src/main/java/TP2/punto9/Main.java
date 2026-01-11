package TP2.punto9;

public class Main {
    public static void main(String[] args) {

        Posicion p1  = new Posicion(2,3);

        System.out.println("ANTES " + p1 );
        Posicion p2 =p1.mover(2,1);

        System.out.println("MOVER " +p2 );

        System.out.println("DESPUES " + p1 );

    }
}
