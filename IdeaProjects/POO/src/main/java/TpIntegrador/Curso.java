package TpIntegrador;


import java.util.ArrayList;
import  java.util.List;
public class Curso  {
    private  String titulo;
    private  int cupo;
    private  List<Estudiante> estudiantes ;
    private Profesor profesor;


    public Curso(String titulo, int cupo, Profesor profesor) {
        this.titulo = titulo;
        this.cupo = cupo;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();

    }


    public Curso(String titulo, int cupo) {
        this.titulo = titulo;
        this.cupo = cupo;
        this.estudiantes = new ArrayList<>();
    }

    void agregarEstudiante(Estudiante e){
        if (estudiantes.size()<cupo ){
            estudiantes.add(e);
            e.registrar();
        }else {
            System.out.println("no hay cupos disponibles");
            e.cancelar();
        }
    };


    public void mostrarEstuidante(){

        System.out.println("ALUMNOS ANOTADOS EN " + this.titulo);
        for (Estudiante e : estudiantes){
            System.out.println(e.toString());
        }
    }
}
