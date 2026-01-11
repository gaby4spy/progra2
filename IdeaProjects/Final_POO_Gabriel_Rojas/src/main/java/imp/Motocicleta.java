package imp;

public class Motocicleta  extends  Vehiculo{

    private String tipoMotor;
    private  String capacidadTanque;

    public  Motocicleta (int identificador, String marcaVehiculo, int kilometraje , String tipoMotor,String capacidadTanque){
        super(identificador, marcaVehiculo, kilometraje);

        this.tipoMotor=tipoMotor;
        this.capacidadTanque=capacidadTanque;
    }



    @Override
    protected String imprimitTipo() {
        return " Motocicleta";
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(String capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    protected void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("\n Tipo de motor " + tipoMotor +
               "\n capacidad tanque"   + capacidadTanque);
    }

}
