package Grafos;

public class Main {
    public int[][] ObtenerMatrizEtiquetada() {
        int[][] matrix = new int[cantNodos][cantNodos];

        for (int i = 0; i < cantNodos; i++) {
            for (int j = 0; j < cantNodos; j++) {
                matrix[i][j] = MAdy[i][j];
            }
        }
        return matrix;
    }

}
