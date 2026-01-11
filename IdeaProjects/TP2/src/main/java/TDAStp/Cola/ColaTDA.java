package TDAStp.Cola;

import Sistema.Asistente;

public interface ColaTDA {
    void InicilizarCola();
    void  Acolar(Asistente x);
    void Desacolar();
    boolean ColaVacia();
    Asistente Primero();
}
