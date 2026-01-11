import java.util.Scanner;

public class conversion {
    public static void main(String[] args) {

        /*
         * Recordemos que cuando realizamos entradas de datos con tipos como int o double,
         * y luego queremos leer un String (texto) con nextLine(), es importante tener en cuenta
         * que métodos como nextInt() o nextDouble() no consumen el carácter de salto de línea (Enter).
         *
         * Esto puede causar que la siguiente llamada a nextLine() lea una cadena vacía.
         *
         * Para evitar este problema, una buena práctica es leer todos los datos con nextLine()
         * (que sí consume todo el texto ingresado y el salto de línea), y luego convertir
         * ese texto al tipo de dato que necesitemos (por ejemplo, a int o double).
         *
         * Hay dos formas de hacer esta conversión:
         *
         * 1. Leer la entrada con nextLine(), guardarla en una variable de tipo String,
         *    y luego convertirla con Integer.parseInt() o similar.
         *
         * 2. Hacer la conversión directamente en una sola línea:
         *    Integer.parseInt(scanner.nextLine()).
         */

        Scanner consola = new Scanner(System.in);

        System.out.print("Ingrese un numero :");
        var numeroTexto = consola.nextLine();
        var converInt= Integer.parseInt(numeroTexto);
        System.out.println(converInt);

        System.out.print("Ingrese un numero :");
        var converDirecta= Integer.parseInt(consola.nextLine());
        System.out.println(converDirecta);

        var num = 199.999;

        System.out.printf("Salario : $ %.2f%n",num);

        var v ="12456786";


    }
}
