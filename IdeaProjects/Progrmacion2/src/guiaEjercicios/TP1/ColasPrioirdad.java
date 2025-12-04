package guiaEjercicios.TP1;

import Colas.ColaPrioridad.*;
public class ColasPrioirdad {


    /*
    * a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva
    * cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
    * son más prioritarios que los de la CP2.*/


    //A
    public  static  ColaPrioridadAO combinarColasPrioridad(ColaPrioridadAO CP1 ,ColaPrioridadAO CP2){
        ColaPrioridadAO nuevaColaPrioridad = new ColaPrioridadAO();
        nuevaColaPrioridad.InicializarCola();

        while (!CP1.ColaVacia() || !CP2.ColaVacia()){
            if (!CP1.ColaVacia() && !CP2.ColaVacia() && CP2.Prioidad() == CP1.Prioidad()){

                nuevaColaPrioridad.AcolarPrioridad(CP2.Primero(), CP2.Prioidad());
                CP2.Desacolar();
            }
            if (!CP2.ColaVacia()){
                nuevaColaPrioridad.AcolarPrioridad(CP2.Primero(), CP2.Prioidad());
                CP2.Desacolar();
            }

            if (!CP1.ColaVacia()){
                nuevaColaPrioridad.AcolarPrioridad(CP1.Primero() ,CP1.Prioidad());
                CP1.Desacolar();
            }


        }

        return nuevaColaPrioridad;

    }
    //B
    public  static boolean esColaIdentica (ColaPrioridadAO CP1 ,ColaPrioridadAO CP2){

        boolean indentico=true;
        while (!CP1.ColaVacia() || !CP2.ColaVacia()){


            if (!CP1.ColaVacia() && !CP2.ColaVacia()  && CP2.Primero()!=CP1.Primero() || CP1.Prioidad()!=CP2.Prioidad()){
                indentico=false;
                CP1.Desacolar();
                CP2.Desacolar();

            }

            if (!CP1.ColaVacia()){
                CP1.Desacolar() ;
            }

            if (!CP2.ColaVacia()){
                CP2.Desacolar() ;
            }

        }

        return indentico;
    }

    public static void main(String[] args) {

        ColaPrioridadAO col1 = new ColaPrioridadAO();
        col1.InicializarCola();
        col1.AcolarPrioridad(4, 10);
        col1.AcolarPrioridad(10, 9);
        col1.AcolarPrioridad(2, 8);
        col1.AcolarPrioridad(1, 7);
        col1.AcolarPrioridad(3, 6);
        col1.AcolarPrioridad(7, 5);
        col1.AcolarPrioridad(8, 4);
        col1.AcolarPrioridad(5, 3);
        col1.AcolarPrioridad(6, 2);
        col1.AcolarPrioridad(9, 1);



        ColaPrioridadAO col2 = new ColaPrioridadAO();
        col2.InicializarCola();


        col2.AcolarPrioridad(14, 10);
        col2.AcolarPrioridad(20, 9);
        col2.AcolarPrioridad(12, 8);
        col2.AcolarPrioridad(11, 7);
        col2.AcolarPrioridad(13, 6);
        col2.AcolarPrioridad(17, 5);
        col2.AcolarPrioridad(18, 4);
        col2.AcolarPrioridad(15, 3);
        col2.AcolarPrioridad(16, 2);
        col2.AcolarPrioridad(19, 1);


       // ColaPrioridadAO col3 = combinarColasPrioridad(col1,col2);

        if( esColaIdentica(col1,col2)){
            System.out.println("las colas son identicas");
        }else {
            System.out.println("las colas no son identicas");
        }



    }
}
