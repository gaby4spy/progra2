package Rojas_Gabriel;

public class EmpleadoTiempoCompleto  extends  Empleado implements  Beneficios{
    private  double bono;

    public EmpleadoTiempoCompleto(String nombre, double salarioBase ,double bono) {
        super(nombre, salarioBase);
        this.bono=bono;

    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bono;
    }

    @Override
    public double calcularBonoAnual() {
        return bono *2;
    }

    @Override
    public String obtenerDetallesSalud() {
        return "Cobertura médica completa";
    }

    @Override
    public String toString() {
        return "EmpleadoTiempoCompleto{" +
                "nombre=" + this.getNombre() +
                ", ID=" + this.getId() +
                ", bono=" + bono +
                '}';
    }
}
