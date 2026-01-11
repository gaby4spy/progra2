package clase5;

public class Heroe implements  Atacable{

    private  int vida;

    public Heroe (int vida){
        this.vida=vida;
    }

    @Override
    public void recibirDanio(int cantidad) {
        this.vida-= cantidad;
        System.out.println("hereo ha recibido " + cantidad + "de danño vida restante " + this.vida);
    }

    @Override
    public boolean estaVivo() {
        return vida>0;
    }
}
