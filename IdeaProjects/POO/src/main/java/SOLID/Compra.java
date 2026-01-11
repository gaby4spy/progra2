package SOLID;

public class Compra {
   private CarritoCompra carritoCompra;
   private IMetodoPago metodoPago;
   private EstadoCompra estado;
   private String fecha;


    public Compra(CarritoCompra carritoCompra, IMetodoPago metodoPago, String fecha) {
        this.carritoCompra = carritoCompra;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
    }

    public boolean procesarPago(){
        boolean estado = metodoPago.pagar(carritoCompra.calcularTotal());

        if (estado){
            this.estado = EstadoCompra.APROBADO;
        }

       return estado;
   }
    public void generarComprobante() {
        if (estado == EstadoCompra.APROBADO) {
            System.out.println("=== TITULAR ===");
            System.out.println(metodoPago.getTitular());
            carritoCompra.mostrarCarrito();
            System.out.println("==============");
            System.out.println("TOTAL: " + carritoCompra.calcularTotal());
            System.out.println("==============");
        } else {
            System.out.println("COMPRA CANCELADA");
        }
    }

    public void  cancelarCompra (){
       this.estado = EstadoCompra.CANCELADO;
   }




}
