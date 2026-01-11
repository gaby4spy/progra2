package TpIntegrador;

public class Estudiante extends  Persona implements Registrable{
    private String matricula ;
    private Nivel nivel;

    public Estudiante(String nombre, int edad, String matricula, Nivel nivel) {
        super(nombre, edad);
        this.matricula = matricula;
        this.nivel = nivel;
    }

    public  void  estudiar(){
        System.out.println(this.nombre + " esta estudiando");
    };

    @Override
    public void trabajar() {

    }

    public String getMatricula() {
        return matricula;
    }

    public Nivel getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nivel=" + nivel +
                '}';
    }

    @Override
    public void registrar() {
        System.out.println("registrando alumano... " + this.getNombre() + " " + this.nivel);
    }

    @Override
    public void cancelar() {

        System.out.println("cancelando registro..." + this.getNombre() + " " + this.nivel);
    }
}
