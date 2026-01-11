public class ManejoSubcadenas {
    public static void main(String[] args) {

        var cad1= "random";
        var cad2= "random";
        var cad3= String.join("-",cad1,cad2);



        var nombre ="Ubaldo Acosta Soto";
        var empresa="Global Mentoring";
        var dominio="com.mx";
        var cadena3=String.join("-",nombre,empresa,dominio);



        System.out.println(nombre.toUpperCase().concat(" ").concat(empresa.toUpperCase()));
        System.out.println();
        System.out.println( nombre.indexOf("Acosta"));
        System.out.println();
        System.out.println(cadena3.toLowerCase().replace(" ","@").replace(".","--"));




    }
}
