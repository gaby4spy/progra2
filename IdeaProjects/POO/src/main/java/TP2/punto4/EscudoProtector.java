package TP2.punto4;

public enum EscudoProtector {
    ESCUDO_1(50),
    ESCUDO_2(60),
    ESCUDO_3(70),
    ESCUDO_4(100);

    private  int proteccion;

    EscudoProtector (int proteccion){
        this.proteccion=proteccion;
    }

    public int getProteccion() {
        return proteccion;
    }
}
