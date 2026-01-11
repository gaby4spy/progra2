package imp;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AutoFamiliar extends  Auto{
    int cantAsientos;
    boolean tieneIsofix;

    static  File carpetaRaiz;
    static File carpetaAuto;
    static File archivoAutoFamiliar;


    static  {
        String userHome = System.getProperty("user.home");
        carpetaRaiz= new File(userHome,"Programa");
        carpetaAuto= new File(carpetaRaiz,"Autos");
        archivoAutoFamiliar= new File(carpetaAuto,"autos.json");
    }

    AutoFamiliar(int idAuto, String patente,String marca,String modelo, int anio,String color , int kilometraje , double precio,String estado , int cantAsientos,boolean tieneIsofix){
        super( idAuto,  patente, marca, modelo, anio, color , kilometraje , precio,estado);
        this.cantAsientos=cantAsientos;
        this.tieneIsofix=tieneIsofix;
    }

    static  void  guardarArchivoAutoFamiliar( String patente,String marca,String modelo, int anio,String color , int kilometraje , double precio,String estado, int cantAsientos,boolean tieneIsofix){
        int idAuto = generarNuevoId(); //  genera id automáticamente
        AutoFamiliar auto = new AutoFamiliar( idAuto,  patente, marca, modelo,  anio, color , kilometraje , precio,estado , cantAsientos, tieneIsofix);
        Gson gson = new Gson();
        String autoJson= gson.toJson(auto);


        if (!carpetaRaiz.exists()) {
            carpetaRaiz.mkdir();
        }
        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdir();
        }
        if (!archivoAutoFamiliar.exists()) {
            try {
                archivoAutoFamiliar.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(verificarPatente(patente)==true){
            System.out.println("PATENTE EN USO");
        }else {
            try (FileWriter writer = new FileWriter(archivoAutoFamiliar,true)){
                writer.write(autoJson + System.lineSeparator());
                System.out.println("SE REGISTRO EL AUTO COMPACTO " + " " + idAuto);
            }catch (IOException e){
                e.printStackTrace();
            }
        };




    }

    }





