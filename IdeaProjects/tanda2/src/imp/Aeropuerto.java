package imp;

public class Aeropuerto {
    String nombre;
    int nroAeropuerto;
    Ciudad ciudad;

    public  Aeropuerto (String nombre,int nroAeropuerto,Ciudad ciudad){
        this.ciudad=ciudad;
        this.nroAeropuerto=nroAeropuerto;
        this.nombre=nombre;
    }

    public void mostrarInfo(){
        this.ciudad.mostrarInfo();
        System.out.println("NRO AEROPUERTO :" + this.nroAeropuerto);
        System.out.println("Nombre Aeropuerto: " + this.nombre);
    }
}
