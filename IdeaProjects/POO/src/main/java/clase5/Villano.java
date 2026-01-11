package clase5;

public class Villano  implements  Atacable{
    private  int vida;

    public Villano (int vida) {
        this.vida=vida;
    }
    @Override
    public void recibirDanio(int cantidad) {
        this.vida-=cantidad;
        System.out.println("Villano ha recibido " + cantidad + "de daño. Vida restante: " + this.vida);
    }

    @Override
    public boolean estaVivo() {
        return vida>0;
    }
}
