public class Cadenas {
    public static void main(String[] args) {
        System.out.println("Manejo de cadenas en Java");

        var cadena1 ="Hola";
        System.out.println( cadena1);
        var cadena2= new  String("Mundo");
        System.out.println(cadena2);
        var cadena3= (cadena1 + " " + cadena2);
        System.out.println(cadena3);
        var cadena4 = """
                esto es un texto
                multilinea
                msd lineas
                """;

    }
}
