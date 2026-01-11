import java.util.Random;
import java.util.Scanner;

public class reto {
    public static void main(String[] args) {
        var random= new Random();
        Scanner cosola = new Scanner(System.in);


        var id=random.nextInt(9999)+1;
        var idFormatedado= String.format("%04d",id);
        System.out.println(idFormatedado);

        System.out.print("Ingrese su nombre");
        var nombre = cosola.nextLine();
        System.out.print("Ingrese su apellido");
        var apellido= cosola.nextLine();
        System.out.print("Ingrese su año de nacimiento");
        var anioNacimiento=cosola.nextLine();
        var usuario=nombre.toUpperCase().substring(0,2) + apellido.toUpperCase().substring(0,2) + anioNacimiento.substring(2) + idFormatedado;

        var msj= """
               Info : \s
               Nombre:%s
               Apellido:%s
               \tUsuario:%s
               """.formatted(nombre,apellido,usuario)
               ;


        System.out.println(msj);

    }
}
