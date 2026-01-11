package SOLID;

public class Producto {
    private  int id;
    private  String nombre;
    private  double precio;
    private  String tipo;


    public Producto(String nombre, int id, double precio, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.tipo = tipo;
    }


    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
