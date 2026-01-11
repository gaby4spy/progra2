package imp;

public class Arquero extends  Jugador{
    int golesRecibidos;

    public Arquero(String nombre,String apellido,boolean titular,int edad,int golesRecibidos){
        super(nombre, apellido, titular, edad);
        this.golesRecibidos=golesRecibidos;
    }


}
