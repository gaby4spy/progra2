package imp;

public abstract class DispositivoElectronico {
    private int identificafor;
    private String nombreDispositivo;
    private int tiempoUsoAcumulado;

    public  DispositivoElectronico(int identificafor,String nombreDispositivo,int tiempoUsoAcumulado){
        this.identificafor=identificafor;
        this.nombreDispositivo=nombreDispositivo;
        this.tiempoUsoAcumulado=tiempoUsoAcumulado;
    }

   protected abstract String imprimitTipo();



}
