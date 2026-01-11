package xx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CotizacionesAnuales implements CotizacionesAnualesTDA {

    private Map<String, CotizacionesMensualesTDA> datos;

    @Override
    public void inicializarCotizaciones() {
        datos = new HashMap<>();
    }

    @Override
    public void agregarCotizacionAnual(String anio, CotizacionesMensualesTDA cot) {
        datos.put(anio, cot);
    }

    @Override
    public CotizacionesMensualesTDA obtenerCotizacionAnual(String anio) {
        return datos.get(anio);
    }

    @Override
    public Set<String> claves() {
        return new HashSet<>(datos.keySet());
    }
}
