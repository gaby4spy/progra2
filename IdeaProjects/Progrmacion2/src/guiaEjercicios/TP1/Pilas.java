package guiaEjercicios.TP1;

import Pilas.*;


public class Pilas {

    //A
    public  static void pasarPilaInverso(PilaTF pila ,  PilaTF pila2){
        PilaTF aux = new PilaTF();
        aux.InicilizarPila();


        //va desapilando los elementos de pila y los coloca en pila2 quedan inverso
        while (!pila.PilaVacia()){
            pila2.Apilar(pila.Tope());
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }

        //Permite que la pila orginal vuelva a su estado original
        while (!aux.PilaVacia()){
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }



    };

    //B
    public static void  copiarPila (PilaTF pila ,  PilaTF pila2){
        PilaTF aux = new PilaTF();
        aux.InicilizarPila();


        //va desapilando los elementos de pila y los coloca en aux
        while (!pila.PilaVacia()){
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }

        //en aux los valores estaran invertidos al desapilar y colocarlos en pila y pila2 quedaran 'copiados'
        while (!aux.PilaVacia()){
            pila.Apilar(aux.Tope());
            pila2.Apilar(aux.Tope());
            aux.Desapilar();
        }

    };

    //C
    public static void invertirContenido (PilaTF pila){
        PilaTF aux1= new PilaTF();
        PilaTF aux2 = new PilaTF();

        aux1.InicilizarPila();
        aux2.InicilizarPila();

        while (!pila.PilaVacia()){
            aux1.Apilar(pila.Tope());
            pila.Desapilar();
        }

        while (!aux1.PilaVacia()){
            aux2.Apilar(aux1.Tope());
            aux1.Desapilar();
        }

        while (!aux2.PilaVacia()){
            pila.Apilar(aux2.Tope());
            aux2.Desapilar();
        }

    };


    //D
    public static int contElementosPila(PilaTF pila){
        int cont=0;
        PilaTF aux = new PilaTF();
        aux.InicilizarPila();
        while (!pila.PilaVacia()){
            aux.Apilar(pila.Tope());
            cont++;
            pila.Desapilar();
        }

        while (!aux.PilaVacia()){
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }

        return cont;
    };


    //E
    public static int sumartElementosPila(PilaTF pila){
        int suma=0;
        PilaTF aux = new PilaTF();
        aux.InicilizarPila();

        while (!pila.PilaVacia()){
            suma+=pila.Tope();
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        };

        while (!aux.PilaVacia()){
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }

        return suma;
    };


    //F
    public static double promPila(PilaTF pila){
        double suma =0.0;
        int cont=0;
        PilaTF aux = new PilaTF();
        aux.InicilizarPila();

        while (!pila.PilaVacia()){
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }


        while (!aux.PilaVacia()){
            double valor = aux.Tope();
            suma+=valor;
            cont+=1;

            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }



       return suma / cont;
    };


    public static void main(String[] args) {
        PilaTF pila1 = new PilaTF() ;
        PilaTF pila2 =  new PilaTF() ;

        pila2.InicilizarPila();
        pila1.InicilizarPila();

        pila1.Apilar(1);
        pila1.Apilar(2);
        pila1.Apilar(3);
        pila1.Apilar(4);
        pila1.Apilar(5);
        pila1.Apilar(6);


        System.out.println("PROMEDIO PILA : " +promPila(pila1));
        System.out.println("La pila contiene : " +contElementosPila(  pila1) + " elementos ");
        System.out.println("sumatoria de la pila : " +  sumartElementosPila(pila1));

        invertirContenido(pila1);

        System.out.println(pila1.Tope());
         //pasarPilaInverso(pila1,pila2);

       // System.out.println(pila1.Tope() +"--" + pila2.Tope());

        //copiarPila(pila1,pila2);

        //System.out.println(pila1.Tope() + "--" + pila2.Tope());





    }
}
