public class Docente extends Persona {
    int legajoDocente;

    public Docente(String nombre,String apellido,int legajoDocente){
        super(nombre,apellido);
        this.legajoDocente=legajoDocente;
    }
}
