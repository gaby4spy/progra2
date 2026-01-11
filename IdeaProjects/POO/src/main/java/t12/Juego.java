package t12;

public enum Juego {
    PIEDRA ("PIEDRA","PAPEL"),
    PAPEL("PAPEL","TIJERA"),
    TIJERA("TIJERA","PIEDRA");



    private String tipo;
    private String enemigo;

    Juego(String tipo, String enemigo) {
        this.tipo = tipo;
        this.enemigo = enemigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEnemigo() {
        return enemigo;
    }
}
