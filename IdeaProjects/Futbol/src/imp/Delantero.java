package imp;

public class Delantero extends  Jugador{
    int cantidadGol;
    public  Delantero (String nombre,String apellido,boolean titular,int edad,int cantidadGol){
        super(nombre, apellido, titular, edad);
        this.cantidadGol=cantidadGol;
    }
}
