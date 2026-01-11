package clase2.Clase;

public class Empleado extends Persona {

    private  int legajo;
    private String cargo;
    private float sueldo;



    public  Empleado (String nombre , int edad , int legajo, String cargo, float sueldo){
        super(nombre, edad);
        this.legajo=legajo;
        this.cargo=cargo;
        this.sueldo=sueldo;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
