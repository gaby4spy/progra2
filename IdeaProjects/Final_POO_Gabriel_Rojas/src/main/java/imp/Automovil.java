package imp;

public class Automovil  extends  Vehiculo{
    private  int capacidadMotor;
    private  int numeroPuertas;



    public  Automovil(int identificador,String marcaVehiculo,int kilometraje,int capacidadMotor,int numeroPuertas){
        super(identificador, marcaVehiculo, kilometraje);
        this.capacidadMotor=capacidadMotor;
        this.numeroPuertas=numeroPuertas;
    }
    @Override
    protected String imprimitTipo() {
        return " Automovil";
    }

    public int getCapacidadMotor() {
        return capacidadMotor;
    }

    public void setCapacidadMotor(int capacidadMotor) {
        this.capacidadMotor = capacidadMotor;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    protected void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("\n capacidad motor " +  capacidadMotor +
        "\n numero puertas " + numeroPuertas
        );

    }

}
