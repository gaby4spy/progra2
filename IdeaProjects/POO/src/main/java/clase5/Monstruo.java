package clase5;

public class Monstruo implements  Atacable{
    private  int vida;

    public Monstruo (int vida){
        this.vida=vida;
    }

    @Override
    public void recibirDanio(int cantidad) {
        this.vida-=cantidad;
        System.out.println("Monstruo ha recibido " + cantidad + "de daño. Vida restante: " + this.vida);
    }

    @Override
    public boolean estaVivo() {
        return vida>0;
    }
}
