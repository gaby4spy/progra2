package imp;

public class Pasajero extends Persona {

    String asiento;
    public Pasajero (String nombre,String apellido,int dni,String asiento){
        super(nombre,apellido,dni);
        this.asiento=asiento;
    }

    public void mostrarInfo(){
        System.out.println("================INFO PASAJEROS ============");
        System.out.println("NOMBRE :" + this.nombre);
        System.out.println("APELLIDO :" + this.apellido);
        System.out.println("ASIENTO :" +this.asiento);
        System.out.println("==============================");
    }
}
