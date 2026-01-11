package clase2.diagramaAnimales;

public class Reptiles extends  Animal{
    public Reptiles(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }


    @Override
    public void emitirSonido() {
        System.out.println("sisea");
    }

    @Override
    public void alimentarse() {
        System.out.println("engulle presa");
    }

    public void cambiarPiel(){
        System.out.println("cambiar piel..");
    }
}
