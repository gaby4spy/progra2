package Rojas_Gabriel;

public class Freelancer extends  Empleado {
    private  double tarifaPorHora;
    private  int horasTrabajdas;

    public Freelancer(String nombre, double salarioBase, double tarifaPorHora, int horasTrabajdas) {
        super(nombre, salarioBase);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajdas = horasTrabajdas;
    }

    @Override
    public double calcularSalario() {
        return tarifaPorHora *horasTrabajdas;
    }


    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getHorasTrabajdas() {
        return horasTrabajdas;
    }

    public void setHorasTrabajdas(int horasTrabajdas) {
        this.horasTrabajdas = horasTrabajdas;
    }

    public double obtenerBonoPorHoras() {
        if (getHorasTrabajdas() > 100) {
            return 600;
        } else if (getHorasTrabajdas() > 50) {
            return 200;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "nombre=" + this.getNombre() +
                ", ID=" + this.getId() +
                ", tarifaPorHora=" + tarifaPorHora +
                ", horasTrabajdas=" + horasTrabajdas +
                '}';
    }
}
