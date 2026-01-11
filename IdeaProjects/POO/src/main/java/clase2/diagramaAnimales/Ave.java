package clase2.diagramaAnimales;

public class Ave extends  Animal{
    public Ave(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }


    @Override
    public void emitirSonido() {
        System.out.println("sonido ave");
    }

    @Override
    public void alimentarse() {
        System.out.println("pica semillas");
    }

   public void volar(){
        System.out.println("vuelando..");
    }


}
