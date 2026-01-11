public class SumaAcomulativa {
    public static void main(String[] args) {

        final var MAXIMO=5;
        var acomuladorSuma=0;

        var  numero=1;
        while (numero<=MAXIMO){
            System.out.println(numero+ " " + acomuladorSuma);
            acomuladorSuma+=numero++;
            System.out.println(acomuladorSuma);

        }

    }
}
