package clase2.diagramaAnimales;

public class AveMigratoria extends Ave{
    public AveMigratoria(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }


    public  void migrar(){
        System.out.println("migrar..");
    }
}
