package TDAStp.Diccionario;

import TDAStp.Conjuntoinfo.ConjuntoTDA;
import  Sistema.Asistente;
public interface DiccionarioSimpleTDA {
    void InicializarDiccionario();
    void agregar(int clave , Asistente valor);
    void Eliminar(int clave);
    Asistente Recuperar(int clave);
    ConjuntoTDA Claves();
}
