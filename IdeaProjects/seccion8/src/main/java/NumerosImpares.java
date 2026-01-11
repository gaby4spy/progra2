public class NumerosImpares {
    public static void main(String[] args) {
        var cont=0;

        do {
            if (cont%2!=0){
                System.out.println(cont);
            }
            cont++;
        }while (cont<=20);
    }
}
