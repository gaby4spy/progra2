package tp.TDAStp.Diccionario;

import Conjunto.ConjuntoTDA;
import tp.Sistema.Asistente;

import tp.TDAStp.Conjuntoinfo.ConjuntoA;

public interface DiccionarioSimpleTDAAVL{
    void InicializarDiccionario();
    void agregar(int clave , Asistente valor);
    void Eliminar(int clave);
    Asistente Recuperar(int clave);
    ConjuntoTDA Claves();
}
