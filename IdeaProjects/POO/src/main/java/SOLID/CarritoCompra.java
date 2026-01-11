package SOLID;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private List<Producto > productos;
    private  int cantProductos;

    public CarritoCompra( ) {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto (Producto producto){
        this.productos.add(producto);
        cantProductos+=1;
    }

    public boolean eliminarProduto(int id){
      for (int i=0; i<cantProductos ; i ++){
          if (productos.get(i).getId()==id){
              productos.remove(i);
              return true;
          }
      }

      return false;
    };

    public double calcularTotal(){
        double monto =0.0;
        for (Producto i : productos){
            monto+=i.getPrecio();
        }

        return monto;
    }

    public void aplicarDescuento (){};

    public void mostrarCarrito(){
        for (Producto i : productos){
            System.out.println(i.getNombre() + " " + i.getPrecio());
        }
    }
}
