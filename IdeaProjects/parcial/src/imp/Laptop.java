package imp;

public class Laptop extends  DispositivoElectronico{

    int memoriaRam;
    int capacidadAlmacenamiento;

    Laptop(int identificafor,String nombreDispositivo,int tiempoUsoAcumulado,int memoriaRam,int capacidadAlmacenamiento){
        super(identificafor, nombreDispositivo, tiempoUsoAcumulado);

        this.memoriaRam=memoriaRam;
        this.capacidadAlmacenamiento=capacidadAlmacenamiento;
    }

    @Override
    protected String imprimitTipo() {
        return "Laptop";
    }
}
