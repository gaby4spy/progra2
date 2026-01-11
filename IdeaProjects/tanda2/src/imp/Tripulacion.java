package imp;

public class Tripulacion extends Persona {
    String cargo;

    public Tripulacion (String nombre,String apellido,int dni ,String cargo){
        super(nombre,apellido,dni);
        this.cargo=cargo;

    }



}
