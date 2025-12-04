package Pilas;

public class PilaTF  implements PilaTDA {

    int  [] a;
    int indice;

    @Override
    public void InicilizarPila() {
        a = new int [100];
        indice=0;
    }

    @Override
    public void Apilar(int x) {
        a[indice]=x;
        indice++;

    }

    @Override
    public void Desapilar() {
        indice--;
    }

    @Override
    public boolean PilaVacia() {
        return (indice==0);
    }

    @Override
    public int Tope() {
        return a[indice-1];
    }
}
