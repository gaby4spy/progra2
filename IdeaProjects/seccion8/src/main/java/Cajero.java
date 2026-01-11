import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {


        Scanner consola = new Scanner(System.in);
        var menu= """
                1.Consultar Saldo
                2.Retirar
                3.Depositar
                4.Salir
                """;
        var flag=false;

        var saldo=10000;

        while(!flag){
            System.out.println(menu);
            System.out.print("Elija una opcion :");
            var opcion = consola.nextInt();


            if (opcion==1){
                System.out.println("SALDO ACTUAL : " + saldo);
            } else if (opcion==2) {
                System.out.println("INGRESE EL MONTO");
                var ret= consola.nextInt();
                if (ret>saldo){
                    System.out.println("El monto supera el dinero en cuenta");
                }else {
                    saldo-=ret;
                    System.out.println("Saldo actual : " + saldo);
                }

            } else if (opcion==3) {
                System.out.println("INGRESE EL MONTO ");
                var ingreso = consola.nextInt();
                saldo+=ingreso;
                System.out.println(saldo);

            } else if (opcion==4) {
                System.out.println("Saliendo del sistema........");
                flag=true;
            }

        }



    }
}
