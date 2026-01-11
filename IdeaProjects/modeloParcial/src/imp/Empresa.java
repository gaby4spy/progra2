package imp;

import java.util.ArrayList;

public class Empresa {


    public String nombre;                 // Nombre de la empresa
    public ArrayList<Integer> datos;      // Lista de meses / valores

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.datos  = new ArrayList<>();
    }

    public void poner(int valor) {
        datos.add(valor);
    }


    public Integer sacar() {
        if (datos.isEmpty()) return null;
        return datos.remove(datos.size() - 1);
    }


    @Override
    public String toString() {
        return nombre + " -> " + datos;
    }


    public Integer variacionAnual() {
        if (datos.size() < 2) return null;          // no hay “principio y fin”
        int primero = datos.get(0);                 // índice 0
        int ultimo  = datos.get(datos.size() - 1);  // índice size-1
        return ultimo - primero;                    // diferencia (puede ser negativa)
    }

}
