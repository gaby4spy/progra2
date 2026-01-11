package xx;

import java.util.Set;

public interface CotizacionesMensualesTDA {
    void inicializarActivos();
    void agregarDatos(String mes, int E1, int E2, int E3);
    void eliminar(String mes);
    void modificarE1(String mes, int E1);
    void modificarE2(String mes, int E2);
    void modificarE3(String mes, int E3);

    String maxE1();
    String maxE2();
    String maxE3();

    String minE1();
    String minE2();
    String minE3();

    Set<String> claves();
}
