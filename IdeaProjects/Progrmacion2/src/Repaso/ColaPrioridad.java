package Repaso;

import Colas.ColaPrioridad.ColaPrioridadAO;
import Colas.ColaPrioridad.ColaPrioridadTDA;

public class ColaPrioridad {

    public  static void combinarCola(ColaPrioridadTDA c1 ,ColaPrioridadTDA c2){
        ColaPrioridadTDA colaFinal = new ColaPrioridadAO();

        colaFinal.InicializarCola();
        while (!c1.ColaVacia() && !c2.ColaVacia()){

            if (!c1.ColaVacia() && !c2.ColaVacia() && c1.Prioidad() == c2.Prioidad()){
                colaFinal.AcolarPrioridad(c2.Primero(), c2.Prioidad());
                c2.Desacolar();
            }

            if (!c1.ColaVacia()){
                colaFinal.AcolarPrioridad(c1.Primero(), c1.Prioidad());
                c1.Desacolar();
            }

            if (!c2.ColaVacia()){
                colaFinal.AcolarPrioridad(c2.Primero(), c2.Prioidad());
                c2.Desacolar();
            }






            while (!colaFinal.ColaVacia()){
                System.out.println(colaFinal.Primero() + " " + colaFinal.Prioidad());
                colaFinal.Desacolar();
            }
        }
    }
    public static void main(String[] args) {

        ColaPrioridadTDA ca = new ColaPrioridadAO();
        ColaPrioridadTDA ca1 = new ColaPrioridadAO();

        ca1.InicializarCola();
        ca.InicializarCola();

        ca.AcolarPrioridad(1,2);
        ca.AcolarPrioridad(2,3);
        ca.AcolarPrioridad(3,10);

        ca1.AcolarPrioridad(3,2);
        ca1.AcolarPrioridad(55,2);
        ca1.AcolarPrioridad(23,10);

        combinarCola(ca,ca1);

    }
}
