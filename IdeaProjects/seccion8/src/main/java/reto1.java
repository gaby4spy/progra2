public class reto1 {
    public static void main(String[] args) {

        for (var cont =0; cont<=20;cont++){

            if (cont%2==0 && cont<20){
                System.out.print(cont + "-");
            } else if (cont%2==0 && cont==20) {
                System.out.println(cont );
            }

        }
    }
}
