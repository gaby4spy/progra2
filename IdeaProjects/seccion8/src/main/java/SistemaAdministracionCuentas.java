import java.util.Scanner;

public class SistemaAdministracionCuentas {
    public static void main(String[] args) {

        var consola=new Scanner(System.in);
        var salir = false;

        //comenzar con la slaida del menu
        System.out.println("  ===Sistema de adminsitracion de cuentas===");
        while (!salir){
            System.out.print("""
                   
                    Menu:
                    1. crear cuetna
                    2. eliminar cuenta
                    3.salir 
                    Escoje una opcion:\s """);

            var opcion = consola.nextInt();
            //evalua cada opcion
            switch (opcion){
                case 1 -> System.out.println("Creando cuenta...\n");
                case 2 -> System.out.println("Creando eliminando...\n");
                case 3 -> {
                    System.out.print("saliendo del sistema");
                    salir=true;

                }
                default -> {
                    System.out.println("opcion invalida");
                }
            }
        }
        System.out.println("\nHASTA LUEGO");
    }
}
