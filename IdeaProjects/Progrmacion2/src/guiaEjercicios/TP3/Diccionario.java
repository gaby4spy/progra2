package guiaEjercicios.TP3;


import DiccionarioMultiple.DiccionarioMultipleA;

import Diccionario.DiccionarioSimpleA;
import  Conjunto.*;
public class Diccionario {

    //C
    public static DiccionarioMultipleA  elementosComunes (DiccionarioMultipleA d1 , DiccionarioMultipleA d2) {
        DiccionarioMultipleA dicGenerado = new DiccionarioMultipleA();
        dicGenerado.InicializarDiccionario();

        ConjuntoTDA clavesComunes = new ConjuntoA();
        clavesComunes.InicilizarConjunto();

        ConjuntoTDA claves1 = d1.Claves();
        ConjuntoTDA claves2= d2.Claves();


        while (!claves1.ConjuntoVacio()){
            int valor = claves1.Elegir();
            if (claves2.Pertenece(valor)){
                clavesComunes.agregar(valor);
            }
            claves1.Sacar(valor);
        }


        while (!clavesComunes.ConjuntoVacio()){
            int clave = clavesComunes.Elegir();
            ConjuntoTDA valores1 =d1.Recuperar(clave);
            ConjuntoTDA valores2= d2.Recuperar(clave);
            while (!valores1.ConjuntoVacio()){
                int valor=valores1.Elegir();
                dicGenerado.Agregar(clave,valor);
                valores1.Sacar(valor);
            }

            while (!valores2.ConjuntoVacio()){
                int valor= valores2.Elegir();
                dicGenerado.Agregar(clave,valor);
                valores2.Sacar(valor);
            }

            clavesComunes.Sacar(clave);


        }



        return dicGenerado;

    }

    //A

    public static DiccionarioMultipleA generarDiccionario (DiccionarioMultipleA d1,DiccionarioMultipleA d2){
        DiccionarioMultipleA dic = new DiccionarioMultipleA();
        dic.InicializarDiccionario();


        ConjuntoTDA clavesD1 = d1.Claves();
        ConjuntoTDA clavesD2 = d2.Claves();


        while (!clavesD1.ConjuntoVacio()){
            int clave= clavesD1.Elegir();
            ConjuntoTDA valores = d1.Recuperar(clave);

            while (!valores.ConjuntoVacio()){
                int valor = valores.Elegir();
                dic.Agregar(clave,valor);
                valores.Sacar(valor);
            }

            clavesD1.Sacar(clave);
        }

        while (!clavesD2.ConjuntoVacio()){
            int clave= clavesD2.Elegir();
            ConjuntoTDA valores = d2.Recuperar(clave);

            while (!valores.ConjuntoVacio()){
                int valor = valores.Elegir();
                dic.Agregar(clave,valor);
                valores.Sacar(valor);
            }

            clavesD2.Sacar(clave);
        }





        return dic;
    }



    //D
    public static DiccionarioMultipleA puntoD (DiccionarioMultipleA d1,DiccionarioMultipleA d2){
        DiccionarioMultipleA dicGenerado = new DiccionarioMultipleA();
        dicGenerado.InicializarDiccionario();

        ConjuntoTDA clavesComunes = new ConjuntoA();
        clavesComunes.InicilizarConjunto();

        ConjuntoTDA claves1 = d1.Claves();
        ConjuntoTDA claves2= d2.Claves();


        while (!claves1.ConjuntoVacio()){
            int valor = claves1.Elegir();
            if (claves2.Pertenece(valor)){
                clavesComunes.agregar(valor);
            }
            claves1.Sacar(valor);
        }

        while (!clavesComunes.ConjuntoVacio()){
            int clave = clavesComunes.Elegir();
            ConjuntoTDA valoresD1= d1.Recuperar(clave);
            ConjuntoTDA valoresD2= d2.Recuperar(clave);

            while (!valoresD1.ConjuntoVacio()){
                int valor = valoresD1.Elegir();

                if (valoresD2.Pertenece(valor)){
                    dicGenerado.Agregar(clave,valor);
                }

                valoresD1.Sacar(valor);

            }


            clavesComunes.Sacar(clave);
        }






        return dicGenerado;
    }


    //5.2

    public static DiccionarioMultipleA puntoX (DiccionarioSimpleA d ){
        DiccionarioMultipleA dicGnerado = new DiccionarioMultipleA();
        ConjuntoTDA claves = d.Claves();

        dicGnerado.InicializarDiccionario();
        while (!claves.ConjuntoVacio()){
            int clave = claves.Elegir();
            int valor = d.Recuperar(clave);

            dicGnerado.Agregar(valor,clave);


            claves.Sacar(clave);
        }


        return dicGnerado;

    }
    public static void main(String[] args) {


        DiccionarioMultipleA D1 = new DiccionarioMultipleA();
        DiccionarioMultipleA D2 = new DiccionarioMultipleA();


        D1.InicializarDiccionario();
        D2.InicializarDiccionario();

        D1.Agregar(2,2);
        D1.Agregar(2,3);
        D1.Agregar(1,2);
        D1.Agregar(3,22);
        D1.Agregar(3,2);



        D2.Agregar(2,21);
        D2.Agregar(2,2);
        D2.Agregar(3,2);
        D2.Agregar(12,2);
        D2.Agregar(11,2);
        D2.Agregar(3,22);

        /*var dic= elementosComunes(D1,D2);*/

        var dic = generarDiccionario(D1,D2);

       var dd= puntoD(D1,D2);

       var conjClaves = dd.Claves();

       DiccionarioSimpleA c = new DiccionarioSimpleA();
       c.InicializarDiccionario();

       c.agregar(8,2);
        c.agregar(7,2);
        c.agregar(5,1);
        c.agregar(6,1);
        c.agregar(11,10);


        var res = puntoX(c);

        var claves = res.Claves();

        while (!claves.ConjuntoVacio()){
            int clave = claves.Elegir();
            ConjuntoTDA elementos = res.Recuperar(clave);

            System.out.print("clave:");
            System.out.println(clave);
            while (!elementos.ConjuntoVacio()){
                int valor = elementos.Elegir();
                System.out.println(valor);
                elementos.Sacar(valor);
            }

            claves.Sacar(clave);
        }

    }
}
