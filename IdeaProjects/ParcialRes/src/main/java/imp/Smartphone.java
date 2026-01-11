package imp;

public class Smartphone extends  DispositivoElectronico{

    double capactidad;
    double pulgadas;

    Smartphone(int identificafor,String nombreDispositivo,int tiempoUsoAcumulado, double capacidad, double pulgadas){
        super(identificafor,nombreDispositivo,tiempoUsoAcumulado);

        this.capactidad=capactidad;
        this.pulgadas=pulgadas;
    }
    @Override
    protected String imprimitTipo() {
        return "Smarthphone";
    }

    public void setCapactidad(double capactidad){
        this.capactidad=capactidad;
    }

    public double getCapactidad(){
        return  this.capactidad;
    }

    public void setPulgadas(double pulgadas){
        this.pulgadas=pulgadas;
    }

    public double getPulgadas(){
        return this.pulgadas;
    }

    public void imprimirDatos() {
        super.imprimirDatos();  // Imprime datos comunes
        System.out.println("Capacidad: " + capactidad + " GB");
        System.out.println("Pulgadas: " + pulgadas);
    }


}
