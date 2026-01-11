package Emer;

public class ListaCircular  implements ListaCircularTDA {
    private class Nodo {
        int dato;
        Nodo sig;
    }

    private Nodo primero;   // apunta a algún nodo de la lista, no necesariamente el último
    private Nodo ultimo;    // para insertar rápido al final

    @Override
    public void InicializarLista() {
        primero = null;
        ultimo = null;
    }

    @Override
    public boolean ListaVacia() {
        return primero == null;
    }

    @Override
    public void Agregar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.dato = x;

        if (primero == null) {
            // Lista vacía: el único nodo se apunta a sí mismo
            primero = nuevo;
            ultimo = nuevo;
            nuevo.sig = nuevo;
        } else {
            // insertar al final
            nuevo.sig = primero;  // el nuevo apunta al primero para mantener circularidad
            ultimo.sig = nuevo;   // el que era último ahora apunta al nuevo
            ultimo = nuevo;       // actualizamos el último
        }
    }

    @Override
    public int Primero() {
        return primero.dato;
    }

    @Override
    public void Avanzar() {
        if (primero != null)
            primero = primero.sig;
    }

    @Override
    public void Eliminar(int x) {
        if (primero == null) return;

        Nodo actual = primero;
        Nodo anterior = ultimo; // en una circular, el anterior del primero es el último

        do {
            if (actual.dato == x) {
                if (actual == primero) {
                    // eliminar el primer nodo
                    if (primero == ultimo) {
                        // tenía un solo nodo
                        primero = null;
                        ultimo = null;
                    } else {
                        primero = primero.sig;
                        ultimo.sig = primero;
                    }
                } else if (actual == ultimo) {
                    // eliminar el último
                    anterior.sig = primero;
                    ultimo = anterior;
                } else {
                    // eliminar nodo intermedio
                    anterior.sig = actual.sig;
                }
                return; // elimina una sola vez
            }
            anterior = actual;
            actual = actual.sig;
        } while (actual != primero);
    }
}
