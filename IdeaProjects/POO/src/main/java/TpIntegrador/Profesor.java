package TpIntegrador;

public class Profesor  extends  Persona{

    private  String especialidad;
    private Nivel nivel;


    public Profesor(String nombre, int edad, String especialidad, Nivel nivel) {
        super(nombre, edad);
        this.especialidad = especialidad;
        this.nivel = nivel;
    }

    @Override
    public void trabajar() {
        System.out.println("tabajndo en nivel "+ this.nivel);
    }

    public  void  dicarClase(){
        System.out.println("dictando clases en + " +this.especialidad);
    };

    @Override
    public String toString() {
        return "Profesor{" +
                "especialidad='" + especialidad + '\'' +
                ", nivel=" + nivel +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
