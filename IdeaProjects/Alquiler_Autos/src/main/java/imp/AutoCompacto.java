package imp;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AutoCompacto  extends  Auto{
    String tipoCaja;
    int puertas;

    static File carpetaAuto;
    static File archivoAutoCompacto;
    static  File carpetaRaiz;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz= new File(userHome,"Programa");
        carpetaAuto=new File(carpetaRaiz,"Autos");
        archivoAutoCompacto= new File(carpetaAuto,"autos.json");

    }

    AutoCompacto(int idAuto, String patente,String marca,String modelo, int anio,String color , int kilometraje , double precio, String estado , String tipoCaja,int puertas  ){
        super( idAuto,  patente,marca,modelo,  anio, color ,  kilometraje , precio , estado);
        this.tipoCaja=tipoCaja;
        this.puertas=puertas;
    }

    static void guardarArchivoAutoCompacto( String patente, String marca, String modelo,
                                           int anio, String color, int kilometraje, double precio,String estado,
                                           String tipoCaja, int puertas) {


        if (!carpetaRaiz.exists()) {
            carpetaRaiz.mkdir();
        }
        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdir();
        }
        if (!archivoAutoCompacto.exists()) {
            try {
                archivoAutoCompacto.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        int idAuto = Auto.generarNuevoId(); //genera id automáticamente
        AutoCompacto auto = new AutoCompacto(idAuto, patente, marca, modelo, anio, color, kilometraje, precio,estado, tipoCaja, puertas);
        Gson gson = new Gson();
        String autoJson = gson.toJson(auto);



        if(verificarPatente(patente)==true){
            System.out.println("PATENTE EN USO");
        }else {
            try (FileWriter writer = new FileWriter(archivoAutoCompacto, true)) {
                writer.write(autoJson + System.lineSeparator());
                System.out.println("SE REGISTRO EL AUTO COMPACTO :" + " "  + auto.marca +" "+ auto.modelo + " " + "ASOCIADO CON ID : "+ idAuto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        }
    }

