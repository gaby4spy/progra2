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
}
