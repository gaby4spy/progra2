package imp;


public class Tablet extends  DispositivoElectronico{
    int resolucionPantalla;

    Tablet (int identificafor,String nombreDispositivo,int tiempoUsoAcumulado,int resolucionPantalla){
        super(identificafor, nombreDispositivo, tiempoUsoAcumulado);

        this.resolucionPantalla=resolucionPantalla;
    }
    @Override
    protected String imprimitTipo() {
        return "Tablet";
    }

    public void setResolucionPantalla(int resolucionPantalla ){
        this.resolucionPantalla=resolucionPantalla;
    }

    public int getResolucionPantalla(){
        return this.resolucionPantalla;
    }


    public void imprimirDatos() {
        super.imprimirDatos();  // Imprime datos comunes
        System.out.println("resolucion: " + resolucionPantalla);

    }

}
