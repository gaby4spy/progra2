package DiccionarioMultiple;

import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;
import  Conjunto.ConjuntoA;
public class DiccionarioMultipleA  implements DiccionarioMultipleTDA{

    class Elemento{
        int clave;
        int [] valores;
        int cantValores;
    }

    private  Elemento[] elementos;
    private int cantClaves;

    @Override
    public void InicializarDiccionario() {
        elementos = new  Elemento[100];
        cantClaves=0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int PosC= Clave2Indice(clave);
        if (PosC==-1){ //clave no existe
            PosC=cantClaves;
            elementos[PosC]=new Elemento();
            elementos[PosC].clave=clave;
            elementos[PosC].cantValores=0;
            elementos[PosC].valores=new int[100];
            cantClaves++;

        }

        Elemento e = elementos[PosC];
        int PosV=Valor2Indice(e,valor);
        if (PosV==-1){
            e.valores[e.cantValores]=valor;
            e.cantValores++;
        }

    }

    @Override
    public void Eliminar(int clave) {
        int PosC=Clave2Indice(clave);
        if (PosC!=-1){//clave existe
            elementos[PosC]=elementos[cantClaves-1];
            cantClaves--;
        }

    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int PosC =Clave2Indice(clave);
        if (PosC!=-1){
            Elemento e = elementos[PosC];
            int PosV= Valor2Indice(e,valor);
            if (PosC!=-1){
                e.valores[PosV]= e.valores[e.cantValores-1];
                e.cantValores--;
            }

            if (e.cantValores==0){
                Eliminar(clave);
            }
        }

    }

    private int Clave2Indice(int clave){
        int i = cantClaves-1;
        while (i>=0 && elementos[i].clave!=clave){
            i--;
        }
        return i;
    }
    private  int Valor2Indice(Elemento e , int valor){
        int i = e.cantValores-1;
        while (i>=0 && e.valores[i]!=valor){
            i--;
        }
        return i;
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        ConjuntoTDA c = new  ConjuntoA();
        c.InicilizarConjunto();
        int PosC=Clave2Indice(clave);
        if (PosC!=-1){
            Elemento e =elementos[PosC];
            for (int i =0; i<e.cantValores;i++){
                c.agregar(e.valores[i]);
            }
        }
        return c;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoA();
        c.InicilizarConjunto();
        for (int i = 0;i<cantClaves;i++){
            c.agregar(elementos[i].clave);
        }
        return c;
    }
}
