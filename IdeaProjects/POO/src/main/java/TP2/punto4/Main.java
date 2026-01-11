package TP2.punto4;

import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Random rand  = new Random();
        EscudoProtector[] escudo = EscudoProtector.values();
        SuperPoder[] superpoderes = SuperPoder.values();

        EscudoProtector escudoProtector1 = escudo[rand.nextInt(escudo.length)];
        EscudoProtector escudoProtector2 = escudo[rand.nextInt(escudo.length)];

        SuperPoder superPoder1 = superpoderes[rand.nextInt(superpoderes.length)];
        SuperPoder superPoder2 = superpoderes[rand.nextInt(superpoderes.length)];

        int round =5;


        Personaje p1 = new Personaje(escudoProtector1,superPoder1,100,"iron man");

        Personaje p2 = new Personaje(escudoProtector2,superPoder2,100,"capitan america");


        while (p1.estaVivo() && p2.estaVivo() && round > 0) {
            System.out.println("=== Empieza el round ===");

            // Selecciona un turno aleatorio
            if (rand.nextBoolean()) {
                // Ataca p1
                System.out.println("Ataca: " + p1.nombre);
                System.out.println("\t" + p1.toString());

                int danioCausado = p1.superPoder.getDanio() * p2.getVidas() / 100;
                int danioDisminuido = danioCausado * p2.escudoProtector.getProteccion() / 100;
                int resultadoAtaque = danioCausado - danioDisminuido;

                // Aplica daño al oponente
                p2.setVidas(p2.getVidas() - resultadoAtaque);

                System.out.println("Daño aplicado a " + p2.nombre + ": " + resultadoAtaque);
                System.out.println("\t" + p2.toString());

            } else {
                // Ataca p2
                System.out.println("Ataca: " + p2.nombre);
                System.out.println("\t" + p2.toString());

                int danioCausado = p2.superPoder.getDanio() * p1.getVidas() / 100;
                int danioDisminuido = danioCausado * p1.escudoProtector.getProteccion() / 100;
                int resultadoAtaque = danioCausado - danioDisminuido;

                // Aplica daño al oponente
                p1.setVidas(p1.getVidas() - resultadoAtaque);

                System.out.println("Daño aplicado a " + p1.nombre + ": " + resultadoAtaque);
                System.out.println("\t" + p1.toString());
            }

            round--;
        }


        if (p1.estaVivo() && p2.estaVivo()){
            System.out.println("empate ");
        } else if (p1.estaVivo()) {
            System.out.println("gano " + p1.nombre);
        }else {
            System.out.println("gano " + p2.nombre);
        }


    }
}
