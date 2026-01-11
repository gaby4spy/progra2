package clase4;


import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private static   List<Materia> materias;


    public  Persona (){};

    public Persona(String nombre , String apellido ,int dni){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        materias = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    public void  agregarMateria(Materia materia){
        materias.add(materia);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }

    public void mostrarInfo(){
        System.out.println("========DATOS ALUMNO========");
        System.out.println(toString());
        System.out.println("========MATERIAS========");
        for (Materia i : materias){
            System.out.println(i.toString());
        }

    }



}
