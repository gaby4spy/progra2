package t12;

public class Main {

    public static void main(String[] args) {

        Juego p1 = Juego.PIEDRA;
        Juego p2 = Juego.TIJERA;


        if (p1.getEnemigo().equals(p2.getTipo())){
            System.out.println("gano " +" "  + p2.getTipo());
        } else if (p2.getEnemigo().equals(p1.getTipo())) {
            System.out.println("gano" + " "+p1.getTipo());
        }else {
            System.out.println("hubo empate " + p1.getTipo() + " " + p2.getTipo());
        }


    }
}
