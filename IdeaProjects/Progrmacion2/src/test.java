import Arbol.ABB;
import Arbol.TDAABB;
import Colas.ColaPI;
import Colas.ColaPU;
import Colas.ColaTDA;
import Diccionario.DiccionarioSimpleA;
import Diccionario.DiccionarioSimpleTDA;
import Grafos.GrafoMA;
import Grafos.GrafoTDA;
import Pilas.PilaTDA;
import Pilas.PilaTF;
import tp.TDAStp.Conjuntoinfo.ConjuntoA;
import tp.TDAStp.Conjuntoinfo.ConjuntoTDA;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static ConjuntoTDA   conjuntoAislados(GrafoTDA x ){

        ConjuntoTDA conjuntoAux = x.Vertices();

        ConjuntoTDA conjuntoAislado = new ConjuntoA();
        conjuntoAislado.InicializarConjunto();

        while (!conjuntoAux.ConjuntoVacio()){
            boolean flag = false;
            int clave = conjuntoAux.Elegir();

            ConjuntoTDA aux = x.Vertices();
            while (!aux.ConjuntoVacio()) {
                int valor = aux.Elegir();
                if (x.ExisteArista(clave,valor)){
                    flag=true;
                }
                aux.Sacar(valor);

            }

            if (flag==false){
                conjuntoAislado.Agregar(clave);
            }
            conjuntoAux.Sacar(clave);
        }

        return conjuntoAislado;
    }

    public static DiccionarioSimpleTDA menorCosto(GrafoTDA grafo , int vertice){
        ConjuntoTDA claves = grafo.Vertices();
        DiccionarioSimpleA diccionario = new DiccionarioSimpleA();
        diccionario.InicializarDiccionario();

        if (claves.Pertenece(vertice)){

            ConjuntoTDA clavesAux = grafo.Vertices();

            while (!clavesAux.ConjuntoVacio()){
                int valor = clavesAux.Elegir();

                if (grafo.ExisteArista(vertice, valor)){

                    int pesoNuevo = grafo.PesoArista(vertice, valor);

                    if (!diccionario.Claves().Pertenece(vertice)){
                        diccionario.agregar(vertice, pesoNuevo);
                    } else {
                        int valorActual = diccionario.Recuperar(vertice);
                        if (pesoNuevo < valorActual){
                            diccionario.agregar(vertice, pesoNuevo);
                        }
                    }
                }

                clavesAux.Sacar(valor);
            }
        }
        else {
            System.out.println("no existe elmeento");
        }

        return diccionario;
    }
    public static DiccionarioSimpleTDA menorAllCostos(GrafoTDA grafo){
        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleA();
        diccionario.InicializarDiccionario();

        ConjuntoTDA claves = grafo.Vertices();

        while (!claves.ConjuntoVacio()){
            ConjuntoTDA aux = grafo.Vertices();

            int vertice = claves.Elegir();

            while (!aux.ConjuntoVacio()){
                int vertice2 = aux.Elegir();

                if (grafo.ExisteArista(vertice,vertice2)){
                    int pesoNuevo = grafo.PesoArista(vertice,vertice2);
                    System.out.println("VERTICE A: " + vertice +" VERTICES B : " + vertice2 +"--->" + pesoNuevo );

                    if (!diccionario.Claves().Pertenece(vertice)){
                        diccionario.agregar(vertice,pesoNuevo);
                    }else {
                        int pesoAcutal= diccionario.Recuperar(vertice);
                        if (pesoNuevo<pesoAcutal){
                            diccionario.agregar(vertice,pesoNuevo);
                        }
                    }
                }
                aux.Sacar(vertice2);
            }


            claves.Sacar(vertice);



        }
        return diccionario;
    }

    public static int retornarDerecho(TDAABB arbol , int nodo){
        TDAABB arbolAux = arbol;
        boolean flag = false;
        while (!arbolAux.ArbolVacio()  ){
             if (arbolAux.Raiz()==nodo){
                 if (!arbolAux.HijoDer().ArbolVacio()){
                     return arbolAux.HijoDer().Raiz();
                 }else {
                     return -2;
                 }
             } else if (nodo> arbolAux.Raiz()) {
                 arbolAux=arbolAux.HijoDer();
             } else {
                 arbolAux=arbolAux.HijoIzq();
             }

        }



        return -1;
    }

    public static ConjuntoTDA elemPresentes (ColaTDA c, PilaTDA p){
        ConjuntoTDA pilaAux=new ConjuntoA();
        ConjuntoTDA colaAux= new ConjuntoA();
        ConjuntoTDA resultado= new ConjuntoA();


        ColaTDA restaurarCola = new ColaPI();
        PilaTDA restaurarPila = new PilaTF();


        pilaAux.InicializarConjunto();
        colaAux.InicializarConjunto();
        restaurarPila.InicilizarPila();
        restaurarCola.InicilizarCola();
        resultado.InicializarConjunto();

        while (!c.ColaVacia()){
            int valor = c.Primero();
            colaAux.Agregar(valor);
            restaurarCola.Acolar(valor);
            c.Desacolar();
        }

        while (!p.PilaVacia()){
            int valor = p.Tope();
            pilaAux.Agregar(valor);
            restaurarPila.Apilar(valor);
            p.Desapilar();
        }


        //comparamos

        while (!pilaAux.ConjuntoVacio()){
            int valor = pilaAux.Elegir();
            if (colaAux.Pertenece(valor)){
                resultado.Agregar(valor);
            }
            pilaAux.Sacar(valor);
        }

        //restauramos

        while (!restaurarPila.PilaVacia()){
            int valor = restaurarPila.Tope();
            p.Apilar(valor);
            restaurarPila.Desapilar();
        }

        while (!restaurarCola.ColaVacia()){
            int valor = restaurarCola.Primero();
            c.Acolar(valor);
            restaurarCola.Desacolar();
        }



        return resultado;
    }





    public static void main(String[] args) {

        GrafoMA x = new GrafoMA();
        x.InicializarGrafo();

        x.AgregarVertice(30);
        x.AgregarVertice(20);
        x.AgregarVertice(40);
        x.AgregarVertice(10);
        x.AgregarVertice(25);
        x.AgregarVertice(35);
        x.AgregarVertice(50);
        x.AgregarVertice(5);
        x.AgregarVertice(4);



        x.AgregarArista(10,20,10);
        x.AgregarArista(10,40,8);
        x.AgregarArista(40,10,8);
        x.AgregarArista(40,30,12);
        x.AgregarArista(40,50,5);
        x.AgregarArista(20,10,10);
        x.AgregarArista(20,30,2);
        x.AgregarArista(30,20,2);
        x.AgregarArista(30,40,12);
        x.AgregarArista(50,40,5);


        var z = menorCosto(x,900);

        var clave = z.Claves();
        while (!clave.ConjuntoVacio()){
            int clave1= clave.Elegir();
            int valor = z.Recuperar(clave1);

            System.out.println("CLAVE " + clave1 + " VALOR " + valor);

            clave.Sacar(clave1);
        }

        var x2 = menorAllCostos(x);
        var valores = x2.Claves();

        while (!valores.ConjuntoVacio()){
            int clave1 = valores.Elegir();
            int valor = x2.Recuperar(clave1);
            System.out.println(" CLAVE " + clave1 +  " valor "+ valor);
            valores.Sacar(clave1);

        }


        TDAABB arbol1= new ABB();
        arbol1.InicializarArbol();
        arbol1.AgregarElem(10);
        arbol1.AgregarElem(5);
        arbol1.AgregarElem(8);
        arbol1.AgregarElem(40);
        arbol1.AgregarElem(50);


        System.out.println(retornarDerecho(arbol1,999));

        var resultado =retornarDerecho(arbol1,10);
        if (resultado==-1){
            System.out.println("nodo no encontrado" );
        }else if (resultado==-2){
            System.out.println("Nodo encontrado pero sin hijo derecho");
        }else {
            System.out.println("Hijo derecho " + resultado);
        }



        PilaTDA p1 = new PilaTF();
        p1.InicilizarPila();
        p1.Apilar(8);
        p1.Apilar(12);
        p1.Apilar(3);
        p1.Apilar(44);
        p1.Apilar(66);

        ColaTDA c1 = new ColaPI();
        c1.InicilizarCola();
        c1.Acolar(22);
        c1.Acolar(1);
        c1.Acolar(12);
        c1.Acolar(44);
        c1.Acolar(55);



        var res = elemPresentes(c1,p1);

        while (!res.ConjuntoVacio()){
            int valor = res.Elegir();
            System.out.println(valor);
            res.Sacar(valor);
        }

    }
}
