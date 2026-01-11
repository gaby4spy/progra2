import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        var random = new Random();

        //---
        var numeroSecretro = random.nextInt(50)+1;
        var intentos=0;
        var adivinanza=0;
        final var INTENTOS_MAXIMOS=5;

        while (adivinanza!=numeroSecretro &&intentos<INTENTOS_MAXIMOS){
            System.out.println(numeroSecretro);
            System.out.println("Adivina el nro secrecto (1-50)");
            adivinanza=consola.nextInt();


            //ayuda
            if(adivinanza<numeroSecretro){
                System.out.println("EL NUMERO ES MAYOR");

            } else if (adivinanza>numeroSecretro) {
                System.out.println("el nro es menor");
            }
            else {
                System.out.println("acerto");
            }

            intentos++;

            if (intentos==5){
                System.out.println("se acabo los intentos");
            }
        }





    }
}
