public class Main {
    public static double promedioMateria(TurnoExamen turno, String codMat) {
        DiccionarioSimple notas = turno.obtener(codMat);
        int suma = 0;
        int presentes = 0;

        for (String legajo : notas.claves()) {
            String nota = (String) notas.obtener(legajo);
            if (!nota.toLowerCase().equals("a")) {
                suma += Integer.parseInt(nota);
                presentes++;
            }
        }

        if (presentes == 0)
            return 0;
        else
            return (double) suma / presentes;
    }

    public static String materiaMaxProm(TurnoExamen turno) {
        String mejorMateria = null;
        double mejorProm = -1;

        for (String cod : turno.claves()) {
            double prom = promedioMateria(turno, cod);
            if (prom > mejorProm) {
                mejorProm = prom;
                mejorMateria = cod;
            }
        }
        return mejorMateria;
    }



}