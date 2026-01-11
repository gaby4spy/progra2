package Ej2;

public class Main {

    public static ColaTDA generarCola(ColaTDA c1, ColaTDA c2){
        ConjuntoTDA valoresAxu1= new ConjuntoA();
        ConjuntoTDA valoresAux2 = new ConjuntoA();

        ColaTDA colaAux1= new ColaPU();
        ColaTDA colaAux2 = new ColaPU();
        ColaTDA colaFinal = new ColaPU();

        colaFinal.InicializarCola();
        colaAux1.InicializarCola();
        colaAux2.InicializarCola();

        valoresAxu1.InicializarConjunto();
        valoresAux2.InicializarConjunto();


        //saco los valores y guardo su orden

        while (!c1.ColaVacia()){
            int valor = c1.Primero();
            valoresAxu1.Agregar(valor);
            colaAux1.Acolar(valor);
            c1.Desacolar();
        }

        while (!c2.ColaVacia()){
            int valor = c2.Primero();
            valoresAux2.Agregar(valor);
            colaAux2.Acolar(valor);
            c2.Desacolar();
        }

        //genero la tercera cola
        while (!valoresAxu1.ConjuntoVacio()){
            int valor = valoresAxu1.Elegir();
            if (valoresAux2.Pertenece(valor)){
                colaFinal.Acolar(valor);
            }
            valoresAxu1.Sacar(valor);
        }

        //restauro colas inciales
        while (!colaAux1.ColaVacia()){
            int valor = colaAux1.Primero();
            c1.Acolar(valor);
            colaAux1.Desacolar();
        }

        while (!colaAux2.ColaVacia()){
            int valor = colaAux2.Primero();
            c2.Acolar(valor);
            colaAux2.Desacolar();
        }

        return colaFinal;

    }
    public static void main(String[] args) {


        ColaTDA cola1= new ColaPU();
        ColaTDA cola2= new ColaPU();

        cola1.InicializarCola();
        cola2.InicializarCola();


        cola1.Acolar(12);
        cola1.Acolar(2333);
        cola1.Acolar(16);

        cola2.Acolar(2);
        cola2.Acolar(3);
        cola2.Acolar(1);
        cola2.Acolar(16);
        cola2.Acolar(33);




    }
}
