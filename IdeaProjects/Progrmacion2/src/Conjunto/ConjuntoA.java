package Conjunto;

public class ConjuntoA implements ConjuntoTDA{
    private  int [] a ;
    private  int cant;
    @Override
    public void InicilizarConjunto() {
        a = new int[100];
        cant =0;
    }

    @Override
    public void agregar(int x) {
        if (!this.Pertenece(x)){
            a[cant]=x;
            cant++;
        }
    }

    @Override
    public int Elegir() {
        return a [cant-1];
    }

    @Override
    public boolean ConjuntoVacio() {
        return (cant==0);
    }

    @Override
    public void Sacar(int x) {
        int i =0;
        while (i<cant && a[i]!=x){
            i++;
        }
        if (i<cant){
            a[i]=a[cant-1];
            cant--;
        }
    }

    @Override
    public boolean Pertenece(int x) {
        int i =0;
        while (i<cant && a [i] !=x){
            i++;
        }
        return (i<cant);
    }

}
