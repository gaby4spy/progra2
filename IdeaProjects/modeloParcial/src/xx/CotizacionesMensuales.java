package xx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CotizacionesMensuales implements CotizacionesMensualesTDA {

    // clave: mes (String "01" a "12"), valor: int[3] con cotizaciones E1, E2, E3
    Map<String, int[]> cotizaciones;

    @Override
    public void inicializarActivos() {
        cotizaciones = new HashMap<>();
    }

    @Override
    public void agregarDatos(String mes, int E1, int E2, int E3) {
        cotizaciones.put(mes, new int[]{E1, E2, E3});
    }

    @Override
    public void eliminar(String mes) {
        cotizaciones.remove(mes);
    }

    @Override
    public void modificarE1(String mes, int E1) {
        if (cotizaciones.containsKey(mes)) cotizaciones.get(mes)[0] = E1;
    }

    @Override
    public void modificarE2(String mes, int E2) {
        if (cotizaciones.containsKey(mes)) cotizaciones.get(mes)[1] = E2;
    }

    @Override
    public void modificarE3(String mes, int E3) {
        if (cotizaciones.containsKey(mes)) cotizaciones.get(mes)[2] = E3;
    }

    @Override
    public String maxE1() {
        return maxMinE(0, true);
    }

    @Override
    public String maxE2() {
        return maxMinE(1, true);
    }

    @Override
    public String maxE3() {
        return maxMinE(2, true);
    }

    @Override
    public String minE1() {
        return maxMinE(0, false);
    }

    @Override
    public String minE2() {
        return maxMinE(1, false);
    }

    @Override
    public String minE3() {
        return maxMinE(2, false);
    }

    private String maxMinE(int idx, boolean max) {
        String mejorMes = null;
        Integer mejorValor = null;
        for (Map.Entry<String, int[]> entry : cotizaciones.entrySet()) {
            int valor = entry.getValue()[idx];
            if (mejorValor == null || (max && valor > mejorValor) || (!max && valor < mejorValor)) {
                mejorValor = valor;
                mejorMes = entry.getKey();
            }
        }
        return mejorMes;
    }

    @Override
    public Set<String> claves() {
        return new HashSet<>(cotizaciones.keySet());
    }
}
