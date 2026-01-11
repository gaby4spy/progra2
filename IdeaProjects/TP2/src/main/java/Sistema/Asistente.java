package Sistema;

public class Asistente {
    public String nombre;
    public int DNI;
    public String tipoEntrada;

    public Asistente(int DNI, String nombre, String tipoEntrada) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.tipoEntrada = tipoEntrada;
    }


    @Override
    public String toString() {
        return "Asistente{" +
                "nombre='" + nombre + '\'' +
                ", DNI=" + DNI +
                ", tipoEntrada='" + tipoEntrada + '\'' +
                '}';
    }
}
