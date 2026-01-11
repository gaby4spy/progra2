package Rojas_Gabriel;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private  String nombre;
    private List <Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void  contratarEmpleados (Empleado empleado){
        empleados.add(empleado);
    }

    public  boolean checkEmpleado(String id) {
        for (Empleado i : empleados) {
            if (i.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarEmpleados (){
        System.out.println("EMPELADOS DEL DEPARTAMENTO " + " " + this.nombre );
        for (Empleado i : empleados){
            System.out.println(i.toString());
        }
    }

}
