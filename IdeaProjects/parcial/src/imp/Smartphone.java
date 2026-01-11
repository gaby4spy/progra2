package imp;

public class Smartphone extends  DispositivoElectronico{

    double capactidad;
    double pulgadas;

    Smartphone(int identificafor,String nombreDispositivo,int tiempoUsoAcumulado,double capactidad,double pulgadas){
        super(identificafor, nombreDispositivo, tiempoUsoAcumulado);

        this.capactidad=capactidad;
        this.pulgadas=pulgadas;
    }
    @Override
    protected String imprimitTipo() {
        return "Smarthphone";
    }
}
