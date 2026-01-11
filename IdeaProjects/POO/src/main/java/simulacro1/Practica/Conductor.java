package simulacro1.Practica;

public class Conductor {
    String nombre;
    int licencia;


    public Conductor(String nombre, int licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }



    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", licencia=" + licencia +
                '}';
    }
}
