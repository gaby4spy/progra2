package imp;

import java.util.ArrayList;
import java.util.List;

public class CotizacionesMensuales implements CotizacionesMensualesTDA {

    /* ---------- Atributo principal ---------- */
    private List<Empresa> listaEmpresas;

    /* ---------- Inicialización ---------- */
    @Override
    public void inicializarActivos() {
        listaEmpresas = new ArrayList<>();
    }

    /* ---------- Alta / inserción de dato ---------- */
    @Override
    public void agregarDatos(int mes, String empresa) {
        Empresa emp = buscarEmpresa(empresa);
        if (emp == null) {                       // si no existe, la creo
            emp = new Empresa(empresa);
            listaEmpresas.add(emp);
        }
        emp.poner(mes);                          // agrega el dato
    }

    /* ---------- Eliminación de dato ---------- */
    @Override
    public void eliminar(int mes, String empresa) {
        Empresa emp = buscarEmpresa(empresa);
        if (emp != null) {
            // elimina la primera ocurrencia de 'mes' en la lista de datos
            emp.datos.remove(Integer.valueOf(mes));
        }
    }

    /* ---------- Modificación de dato ---------- */
    @Override
    public void modificar(int mes, String empresa) {
        Empresa emp = buscarEmpresa(empresa);
        if (emp != null && !emp.datos.isEmpty()) {
            // ejemplo: reemplazar el último dato por 'mes'
            emp.datos.set(emp.datos.size() - 1, mes);
        }
    }

    /* ---------- Auxiliar ---------- */
    private Empresa buscarEmpresa(String nombre) {
        for (Empresa e : listaEmpresas) {
            if (e.nombre.equals(nombre)) return e;
        }
        return null;
    }
}
