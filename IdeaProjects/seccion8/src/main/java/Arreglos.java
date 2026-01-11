import java.util.Scanner;

public class Arreglos {
    public static void main(String[] args) {

        //Arreglos

        //1 declaramos un arraglo

        /*int [] enteros;

        //2 incilizamos el areglo
        enteros = new  int[4];

        //declarar e iniclizar un arreglo
        int [] numeros = new int[2];
        var nros = new  int [2];


        enteros[0]=13;
        enteros[1]=21;
        enteros[3]=63;


        System.out.println( enteros[0]);
        System.out.println(enteros[1]);
        System.out.println(enteros[3]);


        var enteros = new  int []{100,200,300,400,500};
        for (var i =0 ; i<enteros.length;i++){
            System.out.println(enteros[i]);
        }*/


        Scanner consola = new Scanner( System.in);
        System.out.println("Proporcona el largo del arreglo :");

        var larArreglo=Integer.parseInt(consola.nextLine());
        int [] enteros = new int [larArreglo];

        for (int i = 0; i<larArreglo;i++){
            System.out.println("Proporciona enteros");
            enteros[i]= Integer.parseInt(consola.nextLine());
        }

    }
}
