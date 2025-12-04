package EstructurasEnlazadas.Lista;

public class Lista {

    class Nodo{
        int valor;
        Nodo siguiente;
    }

    Nodo primero;

    public void Inicializar(){
        primero=null;
    }

    public void Agregar(int valor){
        Nodo nuevoValor= new Nodo();
        nuevoValor.valor=valor;

        if (primero==null){
            primero=nuevoValor;
        }else {
            Nodo actual= primero;
            while (actual.siguiente!=null){
                actual=actual.siguiente;
            }
            actual.siguiente=nuevoValor;
        }
    }


    public void mostrarLista(){
        Nodo actual= primero;
        while (actual!=null){
            System.out.print(actual.valor+ "->");
            actual=actual.siguiente;
        }
    }


    public void eliminar(int valor) {
        if (primero == null) {
            return; // Lista vacía
        }

        // Caso especial: el nodo a eliminar es el primero
        if (primero.valor == valor) {
            Nodo actual = primero.siguiente;
            primero = actual;
            return;
        }

        Nodo actual = primero;

        // Buscamos el nodo anterior al que queremos eliminar
        while (actual.siguiente != null && actual.siguiente.valor != valor) {
            actual = actual.siguiente;
        }

        // Si encontramos el nodo a eliminar
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }



    public static void main(String[] args) {
        Lista l=new Lista();
        l.Inicializar();
        l.Agregar(1);
        l.Agregar(2);
        l.Agregar(3);
        l.Agregar(4);
        l.Agregar(5);
        l.Agregar(6);
        l.Agregar(7);
        l.Agregar(8);
        l.Agregar(9);
        l.Agregar(10);
        l.Agregar(11);
        l.Agregar(12);
        l.Agregar(13);
        l.Agregar(14);
        l.Agregar(15);
        l.Agregar(16);


        l.mostrarLista();
        l.eliminar(1);
        System.out.println();
        l.mostrarLista();


    }










}
