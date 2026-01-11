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

    public void setmemoriaRam(int memoriaRam){
        this.memoriaRam=memoriaRam;
    }

    public int getmemoriaRam(){
        return this.memoriaRam;
    }

    public void setcapacidadAlmacenamiento(int capacidadAlmacenamiento){
        this.capacidadAlmacenamiento=capacidadAlmacenamiento;
    }

    public int getcapacidadAlmacenamiento(){
        return this.memoriaRam;
    }

    public void imprimirDatos() {
        super.imprimirDatos();  // Imprime datos comunes
        System.out.println("Memoria ram" +  memoriaRam);
        System.out.println("capacidad Almacenamiento" +  capacidadAlmacenamiento);

    }
}
