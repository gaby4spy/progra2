package apiPila;

public class Main {
    public static void main(String[] args) {
        Pila a = new Pila();

        a.apilar(2);
        System.out.println(   a.esVacio());
        System.out.println(a.top());
        a.desApilar();
        System.out.println(   a.esVacio());


        a.desApilar();


    }
}
