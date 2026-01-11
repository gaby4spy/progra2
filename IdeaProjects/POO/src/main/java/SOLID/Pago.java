package SOLID;

public class Pago implements  IMetodoPago{
    private  String numeroTarjeta;
    private  String titular;
    private String fechaVencimiento;
    private String cvv;
    private  double fondos;


    public Pago(String numeroTarjeta, String titular, String fechaVencimiento, String cvv ,Double fondo ) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.fondos =fondo;
    }

    @Override

    public boolean pagar(double monto) {
        if (validarFondos(monto)) {
            fondos -= monto; // descontar dinero
            return true;
        }
        return false;
    }



    @Override
    public boolean validarFondos(double monto) {
        return monto <= fondos;
    }


    public String getTitular() {
        return titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public double getFondos() {
        return fondos;
    }
}
