package imp;

import java.util.List;

public interface CotizacionesMensualesTDA {
    void inicializarActivos();

    void agregarDatos(String mes, int e1, int e2, int e3);
    void eliminar(String mes);

    void modificarE1(String mes, int nuevoE1);
    void modificarE2(String mes, int nuevoE2);
    void modificarE3(String mes, int nuevoE3);

    String maxE1();  String minE1();
    String maxE2();  String minE2();
    String maxE3();  String minE3();

    List<String> claves();          // meses presentes
}

