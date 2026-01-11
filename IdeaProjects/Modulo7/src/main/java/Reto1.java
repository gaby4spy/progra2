import java.util.Scanner;

public class Reto1 {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        var montoMinimo = 1000;


        System.out.print("INGRESE EL MONTO :");
        var monto = Integer.parseInt(consola.nextLine());
        System.out.print("ES MIEMBRO DE LA TIENDA true/false :");
        var miembro = Boolean.parseBoolean(consola.nextLine());

        if (monto>montoMinimo && miembro==true){
            var descuento = monto*0.1;
            var total = monto -descuento;
            System.out.println("\ndescuento del 10% :"+"\n\tdescuento:" +descuento +"\n\ttotal a pagar : " +  total);

        } else if (miembro==true) {
            var descuento = monto*0.05;
            var total = monto -descuento;
            System.out.println("\ndescuento del 5% :" +"\n\tdescuento:"+descuento +"\n\t total a pagar : " +  total);
        }else {
            System.out.println("descuento del 0");
        }
    }

}