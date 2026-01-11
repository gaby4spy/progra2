package imp;

public class Jugador extends Persona {
    boolean titular;
    public Jugador (String nombre,String apellido,boolean titular,int edad ){
        super(nombre,apellido,edad);
        this.titular=titular;
    }
}
