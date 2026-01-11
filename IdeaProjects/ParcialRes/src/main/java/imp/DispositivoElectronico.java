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

    protected int getIdentificafor() {
        return identificafor;
    }

    protected void setIdentificafor(int identificafor) {
        this.identificafor = identificafor;
    }

    protected String getNombreDispositivo() {
        return nombreDispositivo;
    }

    protected void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    protected int getTiempoUsoAcumulado() {
        return tiempoUsoAcumulado;
    }

    protected void setTiempoUsoAcumulado(int tiempoUsoAcumulado) {
        this.tiempoUsoAcumulado = tiempoUsoAcumulado;
    }

    protected void imprimirDatos() {
        System.out.println("\nID: " + getIdentificafor() +
                "\n Nombre: " + getNombreDispositivo() +
                "\n Tiempo de uso acumulado: " + getTiempoUsoAcumulado() + " horas"
                + "\nTipo: " + imprimitTipo());

    }



}