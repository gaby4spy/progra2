package SOLID;

public interface IMetodoPago {
    boolean pagar(double monto);
     boolean validarFondos (double monto);
    String getTitular();
}
