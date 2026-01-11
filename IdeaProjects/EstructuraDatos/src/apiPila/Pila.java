package apiPila;

import java.lang.reflect.Array;

public class Pila implements  PIlaTDA{

    int n=5;///tamaño arreglo
    int t=-1 ;///indica la pos a la que va a parar el objeto
    int [] pila = new int [n];/// arregle estatico

    @Override
    public int tamnio() {
        return t+1;
    }

    @Override
    public boolean esVacio() {
        return (t<0);
    }

    @Override
    public int top() {
        if(esVacio()){
            throw new RuntimeException("La pila está vacía.");
        }
        return pila[t];

    }

    @Override
    public void apilar(int O) {
        if (tamnio()==n-1){
            System.out.println("no se puede ingresar mas elementos");
            return;
        }
        t=t+1;
        pila[t]=O;

    }

    @Override
    public int desApilar() {
        if (esVacio()) {
            throw new RuntimeException("No se puede desapilar: pila vacía.");
        }
        int e = pila[t];
        t=t-1;
        return  e;

    }

}
