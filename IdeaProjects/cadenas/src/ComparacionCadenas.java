import java.util.Scanner;

public class ComparacionCadenas {
    public static void main(String[] args) {
        //comparacion de cadenas(pool de cadenas)

        Scanner consola = new Scanner(System.in);

        System.out.print("ingrese su edad");
        var edad = Integer.parseInt(consola.nextLine());
        System.out.println(edad+1);

    }
}
