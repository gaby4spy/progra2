package clase4;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;                // Nombre de la carrera (Ej: Ingeniería en Sistemas)
    private String codigo;                // Código interno (Ej: ING-SIS-01)
    private int duracionAnios;            // Duración estimada en años
    private String tituloOtorgado;
    private List<Materia> materias;


    public Carrera(String nombre, String tituloOtorgado, int duracionAnios, String codigo) {
        this.nombre = nombre;
        this.tituloOtorgado = tituloOtorgado;
        this.duracionAnios = duracionAnios;
        this.codigo = codigo;
        this.materias=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", duracionAnios=" + duracionAnios +
                ", tituloOtorgado='" + tituloOtorgado + '\'' +
                '}';
    }

    public void agregarMateria(Materia materia){
       this.materias.add(materia);
    };

    public void mostrarInfo(){
        System.out.println(toString());

        for (Materia materia : materias){
            System.out.println("\t" + materia.toString());
        }
    }
}
