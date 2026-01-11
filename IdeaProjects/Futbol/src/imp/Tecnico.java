package imp;

public class Tecnico  extends  Persona{

    int aniosExperiencia;
    boolean extranjero;

    public  Tecnico (String nombre,String apellido ,int edad ,int aniosExperiencia,boolean extranjero){
        super(nombre, apellido, edad);
        this.extranjero=extranjero;
        this.aniosExperiencia=aniosExperiencia;
    }
}
