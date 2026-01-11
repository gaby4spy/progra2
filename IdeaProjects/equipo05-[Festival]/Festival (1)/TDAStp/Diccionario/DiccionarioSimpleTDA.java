package TDAStp.Diccionario;


import Sistema.Asistente;
import TDAStp.Conjunto.ConjuntoTDA;

public interface DiccionarioSimpleTDA {
    void InicializarDiccionario(); // pre: no aplica.
    void Agregar(int dni, Asistente asistente);// pre: diccionario inicializado.
    void Eliminar(int dni); // pre: diccionario inicializado.
    Asistente Recuperar(int dni); // pre: diccionario inicializado y clave existente.
    ConjuntoTDA Claves(); // pre: diccionario inicializado.
}

