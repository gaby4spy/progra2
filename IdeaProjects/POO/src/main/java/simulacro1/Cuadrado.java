package simulacro1;

public class Cuadrado extends Figura {


    public Cuadrado(int lado, int base, String colog) {
        super(lado, base, colog);
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public void Dibujar() {
        System.out.println("dibujado cuadrado...");

    }





    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public String getColog() {
        return colog;
    }

    public void setColog(String colog) {
        this.colog = colog;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int calcularArea(){
        return base*lado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" +
                "lado=" + lado +
                ", colog='" + colog + '\'' +
                ", base=" + base +
                '}';
    }
}
