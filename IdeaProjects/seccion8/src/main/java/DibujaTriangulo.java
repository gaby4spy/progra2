import java.util.Scanner;

public class DibujaTriangulo {
    public static void main(String[] args) {


        Scanner consola = new Scanner(System.in);

        System.out.print("Proporcione el nro de lineas");
        var lines = Integer.parseInt(consola.nextLine());


        for (var i =1; i<=lines;i++){
            System.out.println("*".repeat(i));
        }


        for (var i =1; i<=10;i++){
            if (i%2==0){
                continue;
            }
            System.out.println(i);
        }
    }
}
