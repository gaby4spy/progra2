package xx;


import java.util.Set;

public class Main {

    public static void main(String[] args) {

        /* ---------- crear un objeto mensual ---------- */
        CotizacionesMensuales mensuales = new CotizacionesMensuales();
        mensuales.inicializarActivos();

        /* ---------- cargar los datos del enunciado ---------- */
        mensuales.agregarDatos("01", 110, 200, 312);
        mensuales.agregarDatos("02", 105, 199, 314);
        mensuales.agregarDatos("03", 111, 203, 318);
        mensuales.agregarDatos("04", 120, 208, 320);
        mensuales.agregarDatos("05", 125, 210, 316);
        mensuales.agregarDatos("06", 126, 212, 312);
        mensuales.agregarDatos("08", 130, 212, 308);   // julio faltante
        mensuales.agregarDatos("09", 134, 211, 304);
        mensuales.agregarDatos("10", 136, 210, 313);
        mensuales.agregarDatos("11", 138, 212, 317);
        mensuales.agregarDatos("12", 140, 215, 320);

        /* ---------- usar los métodos del TDA ---------- */
        System.out.println("Mes de máx E1: " + mensuales.maxE1());  // debería dar "12"
        System.out.println("Mes de mín E1: " + mensuales.minE1());  // "02"

        System.out.println("Mes de máx E2: " + mensuales.maxE2());  // "12"
        System.out.println("Mes de mín E2: " + mensuales.minE2());  // "02"

        System.out.println("Mes de máx E3: " + mensuales.maxE3());  // "04"
        System.out.println("Mes de mín E3: " + mensuales.minE3());  // "09"

        /* ---------- mostrar todas las claves presentes ---------- */
        System.out.print("Claves cargadas: ");
        Set<String> meses = mensuales.claves();
        for (String m : meses) System.out.print(m + " ");
        System.out.println();

        /* ---------- ejemplo de uso anual ---------- */
        CotizacionesAnuales anuales = new CotizacionesAnuales();
        anuales.inicializarCotizaciones();
        anuales.agregarCotizacionAnual("2025", mensuales);   // guardamos el año 2025




    }
}
