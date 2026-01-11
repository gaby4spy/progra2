package xx;
import java.util.Set;

public interface CotizacionesAnualesTDA {
    void inicializarCotizaciones();
    void agregarCotizacionAnual(String anio, CotizacionesMensualesTDA cot);
    CotizacionesMensualesTDA obtenerCotizacionAnual(String anio);
    Set<String> claves();
}
