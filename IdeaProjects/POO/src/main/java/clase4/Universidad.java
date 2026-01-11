package clase4;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;              // Nombre de la universidad
    private String direccion;           // Dirección física
    private int anioFundacion;          // Año de fundación
    private String rector;              // Nombre del rector
    private  List<Carrera> carreras;



    public Universidad (String nombre,String direccion,int anioFundacion,String rector){
        this.nombre=nombre;
        this.direccion=direccion;
        this.anioFundacion=anioFundacion;
        this.rector=rector;
        this.carreras= new ArrayList<>();
    }


    /// METODOS
    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", anioFundacion=" + anioFundacion +
                ", rector='" + rector + '\'' +
                '}';
    }


    public  void agregarCarrera(String nombre, String tituloOtorgado, int duracionAnios, String codigo){
        carreras.add(new Carrera( nombre, tituloOtorgado, duracionAnios, codigo));
    }


    public  void mostrarInfo(){
        System.out.println(toString());
        for (Carrera carrera : carreras){
            carrera.mostrarInfo();
        }
    };
    public List<Carrera> obtenerCarreras() {
        return this.carreras;
    }




}
