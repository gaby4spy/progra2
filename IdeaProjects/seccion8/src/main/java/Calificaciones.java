import java.util.Scanner;

public class Calificaciones {
    public static void main(String[] args) {


        Scanner consola = new Scanner( System.in);

        System.out.println("Ingrese la cantidad de calificaciones :");
        var cantidadCalificaciones = Integer.parseInt(consola.nextLine());
        int [] notas = new int[cantidadCalificaciones];

        var suma =0;
        for (int i =0; i<cantidadCalificaciones; i++){
            System.out.println("Ingrese la nota ");
            var nota = Integer.parseInt(consola.nextLine());
            suma+=nota;
            System.out.println("indices " + i + "=" + nota);

        }
        System.out.println("Promedio " + suma/cantidadCalificaciones);
    }
}
