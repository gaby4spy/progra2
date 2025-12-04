package Diccionario;

import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;

public class DiccionarioSimpleA  implements DiccionarioSimpleTDA{

    private Elemento[] elementos;
    private int cant;



    @Override
    public void InicializarDiccionario() {
        elementos= new Elemento[100];
        cant=0;
    }


    @Override
    public void agregar(int clave, int valor) {
        int pos = Clave2iInd(clave);
        if (pos==-1){ //la clave no existe
            pos=cant; // nueva entrada
            elementos[pos]=new Elemento();
            elementos[pos].clave=clave;
            cant++;
        }
        elementos[pos].valor=valor;

    }

    private int Clave2iInd(int clave){
        int i = cant-1;
        while (i>=0 && elementos[i].clave !=clave){
            i--;
        }
        return i;
    }

    @Override
    //dada una clave si esxiste lo elemina la pos la obtiene del metodo clave2ind
    public void Eliminar(int clave) {
        int pos = Clave2iInd(clave);
        if (pos!=-1){
            elementos[pos]=elementos[cant-1];
            cant--;
        }

    }

    @Override

    //dado una clave retorna un valor si esta existe
    public int Recuperar(int clave) {
        int pos =Clave2iInd(clave);
        return elementos[pos].valor;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoA();
        c.InicilizarConjunto();
        for (int i=0; i<cant;i++){
            c.agregar(elementos[i].clave);
        }
        return c;
    }
}
