package imp;
import java.util.List;

public interface Grafo {
    boolean agregarVertice(int vertice);
    boolean eliminarVertice(int vertice);
    boolean agregarArista(int origen, int destino);
    boolean agregarArista(int origen, int destino, double peso);
    boolean eliminarArista(int origen, int destino);
    boolean existeArista(int origen, int destino);
    List<Integer> vecinos(int vertice);
    List<Integer> recorridoAnchura(int fuente);
    List<Integer> recorridoProfundidad(int fuente);
    List<Integer> caminoMinimo(int fuente, int destino);
    List<Integer> dijkstra(int fuente, int destino);
}