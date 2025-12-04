package EstructurasEnlazadas.DiccionarioDinamicos;

import Conjunto.ConjuntoA;
import Conjunto.ConjuntoTDA;
import Diccionario.DiccionarioSimpleTDA;

public class DiccionarioSimpleL implements DiccionarioSimpleTDA {
    private class  NodoClave{
        int clave;
        int valor;
        NodoClave sigClave;
    }

    private NodoClave origen;


    @Override
    public void InicializarDiccionario() {
        origen= null;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoClave nc = Clave2NodoClave( clave );
        if (nc==null){
            nc=new NodoClave();
            nc.clave=clave;
            nc.sigClave=origen;
        }
        nc.valor=valor;

    }

    private NodoClave Clave2NodoClave (int clave){
        NodoClave aux = origen;
        while (aux!=null && aux.clave !=clave){
            aux=aux.sigClave;
        }
        return aux;
    }
    @Override
    public void Eliminar(int clave) {
        if(origen!=null){
            if (origen.clave==clave){
                origen=origen.sigClave;
            }else {
                NodoClave aux =  origen;
                while (aux.sigClave!=null && aux.sigClave.clave!=clave){
                    aux=aux.sigClave;
                }
                if (aux.sigClave!=null){
                    aux.sigClave=aux.sigClave.sigClave;
                }
            }
        }
    }

    @Override
    public int Recuperar(int clave) {

        NodoClave nc = Clave2NodoClave(clave);
        return nc.valor;
    }

    @Override
    public ConjuntoTDA Claves() {

        ConjuntoTDA c = new ConjuntoA();
        c.InicilizarConjunto();
        NodoClave aux = origen;
        while (aux!=null){
            c.agregar(aux.clave);
            aux=aux.sigClave;
        }
        return null;
    }
}
