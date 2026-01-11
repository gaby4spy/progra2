package TP2.punto4;

public enum SuperPoder {
    VOLAR (10),
    FUERZA_SOBREHUMNA(20),
    INVISIBILIDAD ,
    TELEPATIA ;


    private  int danio;

    SuperPoder(int danio){
        this.danio=danio;
    };

    SuperPoder (){}

    public int getDanio() {
        return danio;
    }

}
