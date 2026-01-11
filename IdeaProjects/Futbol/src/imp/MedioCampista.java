package imp;

public class MedioCampista extends Jugador{
    int asistencia;
    public MedioCampista(String nombre,String apellido,boolean titular,int edad,int asistencia){
        super(nombre, apellido, titular, edad);
        this.asistencia=asistencia;
    }
}
