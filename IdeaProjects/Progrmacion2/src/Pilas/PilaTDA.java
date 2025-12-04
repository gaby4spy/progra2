package Pilas;

public interface PilaTDA {
    void InicilizarPila(); //pre  no aplica
    void Apilar (int x ); //pre:pila inicilizada
    void Desapilar();// pre : pila incilizada y no vacia
    boolean PilaVacia();//pre: pila inicilizada
    int Tope(); //pre : pila iniclizada y no vacia ;

}
