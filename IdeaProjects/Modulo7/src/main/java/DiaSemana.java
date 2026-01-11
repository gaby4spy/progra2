import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);

        System.out.print("Ingrese calificacion :");
        var calificacion = Integer.parseInt(consola.nextLine());

        String nota = "";
        if (calificacion>=9 && calificacion==10){
            nota="A";
        } else if (calificacion>=8 ) {
            nota="b";

        } else if (calificacion>=7 && calificacion<8) {
            nota="c";
        } else if (calificacion>=6) {
            nota="D";

        } else if (calificacion<6 && calificacion>=0) {
            nota="O";
        }
        else {
            nota="FUERA DE RANGO";
        }

        System.out.println(nota);



       /* var dia = 7;

        switch (dia){
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("martes");
                break;
            case 3:
                System.out.println("miercoles");
                break;
            case 4:
                System.out.println("jueves");
                break;
            case 5:
                System.out.println("viernes");
                break;
            case 6:
                System.out.println("sabado");
                break;
            case 7:
                System.out.println("domingo");
                break;
            default:
                System.out.println("Dia invalido");
                break;
        }*/
    }
}
