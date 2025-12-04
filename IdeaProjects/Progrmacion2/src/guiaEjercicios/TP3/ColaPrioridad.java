package guiaEjercicios.TP3;


import Colas.ColaPrioridad.ColaPrioridadAO;
import Colas.ColaPrioridad.ColaPrioridadTDA;
import DiccionarioMultiple.DiccionarioMultipleA;

public class ColaPrioridad {

    public static DiccionarioMultipleA generarDiccionario (ColaPrioridadTDA cola){
        DiccionarioMultipleA diccionario = new DiccionarioMultipleA();
        diccionario.InicializarDiccionario();


        while (!cola.ColaVacia()){
            int valor = cola.Primero();
            int prioridd = cola.Prioidad();
            diccionario.Agregar(valor,prioridd);
            cola.Desacolar();
        }


        return diccionario;

    }

    public static void main(String[] args) {

        ColaPrioridadTDA colaPrioridad = new ColaPrioridadAO();
        colaPrioridad.InicializarCola();

        colaPrioridad.AcolarPrioridad(10,3);
        colaPrioridad.AcolarPrioridad(20,5);
        colaPrioridad.AcolarPrioridad(10,7);
        colaPrioridad.AcolarPrioridad(30,2);
        colaPrioridad.AcolarPrioridad(10,1);

        var c = generarDiccionario(colaPrioridad);


    }
}
