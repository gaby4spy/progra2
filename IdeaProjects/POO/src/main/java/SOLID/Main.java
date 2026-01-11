package SOLID;

public class Main {
    public static void main(String[] args) {


        Producto p1 = new Producto("Laptop", 1, 1500.0, "Físico");
        Producto p2 = new Producto("Curso Java", 2, 200.0, "Digital");
        Producto p3 = new Producto("Smartphone", 3, 800.0, "Físico");
        Producto p4 = new Producto("Suscripción Netflix", 4, 15.0, "Servicio");
        Producto p5 = new Producto("Auriculares", 5, 50.0, "Físico");
        Producto p6 = new Producto("Ebook Diseño UX", 6, 30.0, "Digital");
        Producto p7 = new Producto("Membresía Gym", 7, 40.0, "Servicio");
        Producto p8 = new Producto("Mouse", 8, 25.0, "Físico");
        Producto p9 = new Producto("Curso Python", 9, 180.0, "Digital");
        Producto p10 = new Producto("Spotify Premium", 10, 10.0, "Servicio");


        CarritoCompra c1 = new CarritoCompra();

        c1.agregarProducto(p1);
        c1.agregarProducto(p2);
        c1.agregarProducto(p3);
        c1.agregarProducto(p4);
        c1.agregarProducto(p5);
        c1.agregarProducto(p6);
        c1.agregarProducto(p7);
        c1.agregarProducto(p8);
        c1.agregarProducto(p9);
        c1.agregarProducto(p10);



        IMetodoPago mp=new Pago("33333","carlo gimenez","27/2","232",200000.0);

        Compra compra = new Compra(c1,mp,"22/2/2002");

        compra.procesarPago();
        compra.generarComprobante();



    }
}
