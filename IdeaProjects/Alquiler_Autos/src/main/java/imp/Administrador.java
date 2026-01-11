package imp;


import com.google.gson.Gson;

import java.io.*;

public class Administrador  extends  Empleado{
    String userName;
    String password;

    static File carpetaAdmin;
    static File archivoAdmin;
    static File carpetaRaiz;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome,"Programa");
        carpetaAdmin = new File(carpetaRaiz, "Admin");
        archivoAdmin = new File(carpetaAdmin, "admin.json");
    }



    public Administrador(int idEmpleado, String nombre, String apellido, String cargo,String userName,String password) {
        super(idEmpleado, nombre, apellido, cargo);
        this.userName=userName;
        this.password=password;
    }


    /// FUNCIONALIDADES QUE EJECUTA EL ADMIN

    public  static  void generarInformeAlquileres(String marca,String modelo){
        Alquiler.generarInformeAlquiler(marca,modelo);
    }
    public static void consultarHistorialCliente(int idCliente){
        Alquiler.buscarAlquilerCliente(idCliente);
    }

    public static  void consultarFacturas(int id ){
        Pago.mostrarPago(id);
    }
    public static void modificarPrecioAlquiler(String marca, String modelo, double nuevoPrecio){
        Auto.modificarPrecioAuto(marca, modelo, nuevoPrecio);
    }
    public static  void altaEmpleado( String nombre,String apellido,String cargo){
        registrarEmpleado(  nombre, apellido, cargo);
    };
    public static  void registrarMantenimientoAuto(String patente){
        Auto.cambiarEstadoAuto(patente,"mantenimiento");
    };

    public static  void registrarAutoCompacto( String patente,String marca,String modelo, int anio,String color , int kilometraje , double precio,String estado , String tipoCaja,int puertas){
        AutoCompacto.guardarArchivoAutoCompacto( patente, marca, modelo, anio, color, kilometraje, precio,estado, tipoCaja, puertas);
    }

    public static  void registrarAutoFamiliar( String patente,String marca,String modelo, int anio,String color , int kilometraje , double precio,String estado , int cantAsientos,boolean tieneIsofix) {
        AutoFamiliar.guardarArchivoAutoFamiliar( patente, marca, modelo, anio, color, kilometraje, precio,estado, cantAsientos, tieneIsofix);
    };

    public static void crearSeguro(String tipoSeguro,double costo){
        Seguro.registrarSeguro( tipoSeguro, costo);
    };





    /// ==========================================


}
