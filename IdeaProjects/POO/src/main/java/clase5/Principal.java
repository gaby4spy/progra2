package clase5;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner consola  = new Scanner(System.in);
        Random rand = new Random();
        DiaSemana [] dias = DiaSemana.values();
        DiaSemana diaSecreto = dias[rand.nextInt(dias.length)];

        System.out.println(diaSecreto);
        int intentos =3;
        boolean flag =false;

        while (!flag  && intentos>0){
            System.out.print("adivine el dia comprendido entre LUNES Y DOMINGO : ");
            var respuesta = consola.nextLine();



            try {
                DiaSemana diaUsuario = DiaSemana.valueOf(respuesta.toUpperCase());
                if (diaUsuario==diaSecreto){
                    flag=true;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Eso no es un día válido. Intenta de nuevo.");
            }

            intentos--;
        }
        if (flag){
            System.out.println("adivino");
        }else {
            System.out.println("se acavaron los intentos ");
        }


    }
}
