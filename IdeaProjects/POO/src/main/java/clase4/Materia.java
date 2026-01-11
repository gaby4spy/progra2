package clase4;

public class Materia {

    private  String nombre;
    private String nroMateria;

    public Materia(){};

    public Materia (String nombre, String nroMateria){
        this.nombre=nombre;
        this.nroMateria=nroMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroMateria() {
        return nroMateria;
    }

    public void setNroMateria(String nroMateria) {
        this.nroMateria = nroMateria;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", nroMateria='" + nroMateria + '\'' +
                '}';
    }
}
