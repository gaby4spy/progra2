package TDAStp.Cola;


import Sistema.Asistente;

public interface ColaAsistenteTDA {
    void InicializarCola();
    void  Acolar(Asistente x);
    void Desacolar();
    boolean ColaVacia();
    Asistente Primero();
}
