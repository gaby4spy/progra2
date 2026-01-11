package Rojas_Gabriel;

public abstract class Empleado {

   private String nombre;
   private String id ;
   private double salarioBase;
   private static int contadorEmpleados ;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        contadorEmpleados+=1;

    }


    public  static  int getContadorEmpleados (){
        return contadorEmpleados;
    }

    public abstract   double calcularSalario ();
    public static  String generarID(){

        return String.valueOf((int) contadorEmpleados);
    }

    public void setId(String id) {
        this.id = id;
    }


    public double getSalarioBase() {
        return salarioBase;
    }

    public String getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }
}
