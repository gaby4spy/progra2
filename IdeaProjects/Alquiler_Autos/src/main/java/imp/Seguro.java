package imp;

import com.google.gson.Gson;

import java.io.*;

public class Seguro {
    int idSeguro;
    String tipoSeguro;
    double costo;

    static  File carpetaRaiz;
    static File carpetaSeguro;
    static File archivoSeguro;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz= new File(userHome,"Programa");
        carpetaSeguro=new File(carpetaRaiz,"Seguros");
        archivoSeguro= new File(carpetaSeguro,"seguros.json");

    }

    Seguro (int idSeguro, String tipoSeguro, double costo) {
        this.idSeguro=idSeguro;
        this.tipoSeguro=tipoSeguro;
        this.costo=costo;
    }

    static int generarNuevoId() {
        Gson gson = new Gson();
        int maxId = 0;

        // Asegurar que la carpeta exista
        if (!carpetaSeguro.exists()) {
            carpetaSeguro.mkdirs();
        }

        if (!archivoSeguro.exists()) {
            try {
                archivoSeguro.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeguro))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Seguro seguro = gson.fromJson(linea, Seguro.class);
                if (seguro != null && seguro.idSeguro > maxId) {
                    maxId = seguro.idSeguro;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }

    static void registrarSeguro(String tipoSeguro,double costo){

        if (!carpetaRaiz.exists()){
            carpetaRaiz.mkdir();
        }
        if (!carpetaSeguro.exists()){
            carpetaSeguro.mkdir();
        }
        int idSeguro= generarNuevoId();
        Seguro seguro = new Seguro(idSeguro, tipoSeguro, costo);
        Gson gson  = new Gson();
        String pagoJson= gson.toJson(seguro);
        String conflicto= verificarTipoSeguro( tipoSeguro);


        if(conflicto==null){
            try(FileWriter writer = new FileWriter(archivoSeguro,true)){
                writer.write(pagoJson + System.lineSeparator());
            }catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("SEGURO CREADO : " + tipoSeguro);
        }else {
            System.out.println("No se puede registrar el seguro . Motivo : " + conflicto);
        }


    }


    static String verificarTipoSeguro( String tipoSeguro){
        Gson gson = new Gson();

        if (!carpetaSeguro.exists()){
            carpetaSeguro.mkdir();
        }

        if (!archivoSeguro.exists()){
            try {
                archivoSeguro.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeguro))){

            String linea;

            while ((linea=reader.readLine())!=null){
                Seguro seguro= gson.fromJson(linea,Seguro.class);
                if (seguro != null && seguro.tipoSeguro.toLowerCase().equals(tipoSeguro.toLowerCase()) ){
                    return "Tipo de seguro ya registrado: " + tipoSeguro;
                }
            }

        }catch ( IOException e) {
            e.printStackTrace();
        }
        return null;

    };


    static String verificarSeguro(int idSeguro) {
        Gson gson = new Gson();
        boolean flag = false;

        if (!carpetaSeguro.exists()) {
            carpetaSeguro.mkdirs();
        }

        if (!archivoSeguro.exists()) {
            try {
                archivoSeguro.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeguro))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                Seguro seguro = gson.fromJson(linea, Seguro.class);
                if (seguro != null && seguro.idSeguro == idSeguro) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return "ID SEGURO NO ENCONTRADO";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static double calcularMontoSeguro(int idSeguro, int dias) {
        Gson gson = new Gson();
        double totalSeguro = 0;
        boolean encontrado = false;

        if (!carpetaSeguro.exists()) {
            carpetaSeguro.mkdirs();
        }

        if (!archivoSeguro.exists()) {
            try {
                archivoSeguro.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeguro))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Seguro seguro = gson.fromJson(linea, Seguro.class);
                if (seguro != null && seguro.idSeguro == idSeguro) {
                    totalSeguro = seguro.costo * dias;
                    encontrado = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!encontrado) {
            System.out.println("No se encontró el seguro con ID: " + idSeguro);
        }

        return totalSeguro;
    }

}
