package clase2.diagramaAnimales;

public class Main {
    public static void main(String[] args) {

        Felino gato = new Felino("Mishka", 3, 4.5f);
        Reptiles serpiente = new Reptiles("Nagini", 5, 2.8f);
        Ave ave = new Ave("Piolín", 2, 0.3f);
        AveMigratoria aveMigratoria = new AveMigratoria("Albatros", 7, 1.6f);


        System.out.println("======Felino======");

        System.out.println( gato.getNombre());
        gato.emitirSonido();
        gato.alimentarse();
        gato.trepar();
        gato.cazar();


        System.out.println("====== Reptil======");
        System.out.println( serpiente.getNombre());

        serpiente.emitirSonido();
        serpiente.alimentarse();
        serpiente.cambiarPiel();


        System.out.println("======Ave======");
        System.out.println( ave.getNombre());
        ave.volar();
        ave.emitirSonido();
        ave.alimentarse();

        System.out.println("======AveMigratoria ======");

        System.out.println(aveMigratoria.getNombre());
        aveMigratoria.volar();
        aveMigratoria.emitirSonido();
        aveMigratoria.alimentarse();
        aveMigratoria.migrar();

    }

}
