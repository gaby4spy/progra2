package simulacro1;

public abstract class Figura {
    int lado ;
    int base;
    String colog;

    public Figura (int lado,int base,String colog){
        this.lado=lado;
        this.base=base;
        this.colog=colog;
    }
    public void mover(int x, int y) {
// Implementación de movimiento
    }
    public abstract double calcularPerimetro();

    public  abstract void  Dibujar();
}
