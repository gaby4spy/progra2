package clase5;

import java.util.Random;

public class Main {

    public  static void  Pelea (Heroe heroe ,Monstruo monstruo,Villano villano,int danioHeroe ,int danioMonstruo ,int danioVillano){
        System.out.println("Empienza la pelea!!!");
        while (heroe.estaVivo() && monstruo.estaVivo()&& villano.estaVivo()){
            Random rand = new Random();
            int turno = rand.nextInt(3);
            int enemigo=rand.nextInt();

            if (turno == 0 && heroe.estaVivo()) {
                System.out.println("\t==== Héroe ataca ====");
                if (enemigo % 2 == 0 && villano.estaVivo()) {
                    System.out.println("Atacando villano....");
                    villano.recibirDanio(danioHeroe);
                } else if (monstruo.estaVivo()) {
                    System.out.println("Atacando monstruo....");
                    monstruo.recibirDanio(danioHeroe);
                }

            } else if (turno == 1 && villano.estaVivo()) {
                System.out.println("\t==== Villano ataca ====");
                if (enemigo % 2 != 0 && monstruo.estaVivo()) {
                    System.out.println("Atacando monstruo....");
                    monstruo.recibirDanio(danioVillano);
                } else if (heroe.estaVivo()) {
                    System.out.println("Atacando héroe....");
                    heroe.recibirDanio(danioVillano);
                }

            } else if (turno == 2 && monstruo.estaVivo()) {
                System.out.println("\t==== Monstruo ataca ====");
                if (enemigo % 2 == 0 && villano.estaVivo()) {
                    System.out.println("Atacando villano....");
                    villano.recibirDanio(danioMonstruo);
                } else if (heroe.estaVivo()) {
                    System.out.println("Atacando héroe....");
                    heroe.recibirDanio(danioMonstruo);
                }
            }
        }

        // Determinar ganador
        if (heroe.estaVivo()) {
            System.out.println("Ganador héroe");
        } else if (villano.estaVivo()) {
            System.out.println("Ganador villano");
        } else if (monstruo.estaVivo()) {
            System.out.println("Ganador monstruo");
        } else {
            System.out.println("Todos murieron, empate trágico...");
        }
    }
    public static void main(String[] args) {

        Random rand = new Random();
        int vidaHeroe = rand.nextInt(101);
        int vidaVillano = rand.nextInt(101);
        int vidaMonstruo = rand.nextInt(101);


        Heroe h1 = new Heroe(vidaHeroe);
        Monstruo m1 = new Monstruo(vidaMonstruo);
        Villano v1 = new Villano(vidaVillano);
        Pelea(h1,m1 ,v1,5,5,5);




    }
}