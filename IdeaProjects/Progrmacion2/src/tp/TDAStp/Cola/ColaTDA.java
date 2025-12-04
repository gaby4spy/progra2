package tp.TDAStp.Cola;

import tp.Sistema.Asistente;

public interface ColaTDA {
    void InicilizarCola();
    void  Acolar(Asistente x);
    void Desacolar();
    boolean ColaVacia();
    Asistente Primero();
}
