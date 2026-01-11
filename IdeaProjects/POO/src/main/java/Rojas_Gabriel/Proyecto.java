package Rojas_Gabriel;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private  String nombre;
    private List <Empleado> miembro;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.miembro=new ArrayList<>();
    }

    public void agregarMiembro (Empleado empleado){
        miembro.add(empleado);
    }


    //METODO NUEVO AGREGADO PUNTO 3
    public void mostrarMiembro (){
        System.out.println("miembros proyecto " + this.nombre);
        for (Empleado i : miembro){
            System.out.println(i.toString());
        }
    }

}
