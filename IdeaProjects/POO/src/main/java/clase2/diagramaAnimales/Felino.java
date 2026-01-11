package clase2.diagramaAnimales;

public class Felino extends  Animal{
    public Felino(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }


    @Override
    public void emitirSonido() {
        System.out.println("maulla");
    }

    @Override
    public void alimentarse() {
        System.out.println("come gato");
    }

    public void  trepar(){
        System.out.println("trepando..");
    };

    public void cazar(){
        System.out.println("cazando..");
    };
}
