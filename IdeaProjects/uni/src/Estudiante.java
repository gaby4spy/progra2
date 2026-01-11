public class Estudiante extends Persona{
    String email;
    Carrera carrera;

    public Estudiante(String nombre,String apellido,String email , Carrera carrera){
        super(nombre,apellido);
        this.email=email;
        this.carrera=carrera;
    }
    public void mostrarDetalles(){
        this.carrera.mostraInfo();
    }

}
