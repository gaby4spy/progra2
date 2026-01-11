package FinalParcial;

import Diccionario.DiccionarioSimpleA;
import Diccionario.DiccionarioSimpleTDA;
import Grafos.GrafoTDA;
import Grafos.GrafoMA;

import Conjunto.ConjuntoTDA;

public class Grafos {

    public  static void mayorAristasSalistas(GrafoTDA grafo , int valor){
        tp.TDAStp.Conjuntoinfo.ConjuntoTDA claves = grafo.Vertices();
        DiccionarioSimpleTDA diciconario= new DiccionarioSimpleA();
        diciconario.InicializarDiccionario();



        while (!claves.ConjuntoVacio()){
            int val2= claves.Elegir();

            if (grafo.ExisteArista(valor,val2)){
                int nuevo= grafo.PesoArista(valor,val2);
                if (!diciconario.Claves().Pertenece(valor)){

                    diciconario.agregar(valor, nuevo);
                }else {
                    int actual= diciconario.Recuperar(valor);
                    if (nuevo>actual){
                        diciconario.agregar(valor, nuevo);
                    }
                }
            }
            claves.Sacar(val2);

        }

        ConjuntoTDA x = diciconario.Claves();
        while (!x.ConjuntoVacio()){
            int clave=x.Elegir();
            int valor4 = diciconario.Recuperar(clave);

            System.out.println(clave +"-->"+ valor4);
            x.Sacar(clave);
        }


    }
    public static void main(String[] args) {

        GrafoTDA g1 = new GrafoMA();
        g1.InicializarGrafo();

        g1.AgregarVertice(10);
        g1.AgregarVertice(20);
        g1.AgregarVertice(30);
        g1.AgregarVertice(40);
        g1.AgregarVertice(50);


        g1.AgregarArista(10,20,10);
        g1.AgregarArista(10,40,8);

        g1.AgregarArista(20,10,10);
        g1.AgregarArista(20,30,2);

        g1.AgregarArista(30,20,2);
        g1.AgregarArista(30,40,12);

        g1.AgregarArista(40,10,8);
        g1.AgregarArista(40,30,12);
        g1.AgregarArista(40,50,5);

        mayorAristasSalistas(g1,40);
    }
}
