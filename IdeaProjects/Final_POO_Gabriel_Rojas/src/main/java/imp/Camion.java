package imp;

public class Camion extends  Vehiculo{

    private  double capacidadCarga;


    public  Camion(int identificador, String marcaVehiculo, int kilometraje,double capacidadCarga){
        super(identificador, marcaVehiculo, kilometraje);
        this.capacidadCarga=capacidadCarga;
    }
    @Override
    protected String imprimitTipo() {
        return "Camion";
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }


    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }


    protected void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("capacidad carga " +  capacidadCarga);
    }



}
