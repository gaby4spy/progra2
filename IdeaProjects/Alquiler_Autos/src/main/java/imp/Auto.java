package imp;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;

public class Auto {
    int idAuto;
    String patente;
    String marca;
    String modelo;
    int anio;
    String color;
    int Kilometraje;
    double precio;
    String estado;

    static File carpetaAuto;
    static File archivoAuto;
    static File carpetaRaiz;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome,"Programa");
        carpetaAuto = new File(carpetaRaiz, "Autos");
        archivoAuto = new File(carpetaAuto, "autos.json");

        // Crear todas las carpetas necesarias si no existen
        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdirs();  // <-- mkdirs() para crear toda la ruta faltante
        }
    }

    Auto(int idAuto, String patente, String marca, String modelo, int anio, String color, int kilometraje, double precio,String estado) {
        this.idAuto = idAuto;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.Kilometraje = kilometraje;
        this.precio = precio;
        this.estado= estado;
    }

    static int generarNuevoId() {
        Gson gson = new Gson();
        int maxId = 0;

        // Asegurar que la carpeta exista
        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdirs();
        }

        if (!archivoAuto.exists()) {
            try {
                archivoAuto.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Auto auto = gson.fromJson(linea, Auto.class);
                if (auto != null && auto.idAuto > maxId) {
                    maxId = auto.idAuto;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }



    static boolean verificarPatente(String patente) {
        Gson gson = new Gson();
        boolean flag = false;

        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdirs();
        }

        if (!archivoAuto.exists()) {
            try {
                archivoAuto.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String objAuto;
            while ((objAuto = reader.readLine()) != null) {
                Auto auto = gson.fromJson(objAuto, Auto.class);
                if (auto != null && auto.patente != null && auto.patente.equalsIgnoreCase(patente)) {
                    flag = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flag;
    }


    static String leerArchivoAuto(int idAuto) {
        Gson gson = new Gson();

        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdirs();
        }

        if (!archivoAuto.exists()) {
            try {
                archivoAuto.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        boolean hayAutos = false;
        boolean autoEncontrado = false;
        boolean estadoLibre = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String objAuto;
            while ((objAuto = reader.readLine()) != null) {
                Auto auto = gson.fromJson(objAuto, Auto.class);
                hayAutos = true;
                if (auto != null && auto.idAuto == idAuto) {
                    autoEncontrado = true;
                    if (auto.estado != null && auto.estado.equalsIgnoreCase("libre")) {
                        estadoLibre = true;
                    }
                    break; // Una vez encontrado, no es necesario seguir
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayAutos) {
            return "NO HAY AUTOS REGISTRADOS";
        }

        if (!autoEncontrado) {
            return "NO SE ENCONTRÓ EL AUTO";
        }

        if (!estadoLibre) {
            return "EL AUTO ESTÁ EN USO";
        }

        return null;
    }

    static void filtrarAutoEstado(String estado) {
        Gson gson = new Gson();

        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdirs();
        }

        if (!archivoAuto.exists()) {
            try {
                archivoAuto.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        boolean hayAutos = false;
        boolean hayCoincidencias = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Auto auto = gson.fromJson(linea, Auto.class);
                if (auto != null) {
                    hayAutos = true;
                    if (auto.estado != null && auto.estado.toLowerCase().equals(estado.toLowerCase())) {
                        System.out.println("=== Datos del Auto ===");
                        System.out.println("Marca   : " + auto.marca);
                        System.out.println("Modelo  : " + auto.modelo);
                        System.out.println("Patente : " + auto.patente);
                        System.out.println("ID Auto : " + auto.idAuto);
                        System.out.println("======================");
                        // o mostrar los campos a mano
                        hayCoincidencias = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayAutos) {
            System.out.println("NO HAY AUTOS REGISTRADOS");
        } else if (!hayCoincidencias) {
            System.out.println("NO HAY AUTOS CON ESTADO '" + estado.toUpperCase() + "'");
        }
    }





    static void modificarPrecioAuto(String marca, String modelo, double nuevoPrecio) {
        Gson gson = new Gson();
        ArrayList<Auto> autos = new ArrayList<>();
        boolean autoEncontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String objAuto;
            while ((objAuto = reader.readLine()) != null) {
                Auto auto = gson.fromJson(objAuto, Auto.class);
                if (auto != null) {
                    if (auto.marca != null && auto.modelo != null &&
                            auto.marca.toLowerCase().strip().equals(marca.toLowerCase().strip()) &&
                            auto.modelo.toLowerCase().strip().equals(modelo.toLowerCase().strip())) {
                        auto.precio = nuevoPrecio;
                        autoEncontrado = true;
                        System.out.println("Auto encontrado y actualizado - " + marca + " " + modelo);
                    }
                    autos.add(auto);
                }
            }
            if (!autoEncontrado) {
                System.out.println("Auto no encontrado - Marca: " + marca + " Modelo: " + modelo);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoAuto, false))) {
            for (Auto auto : autos) {
                String json = gson.toJson(auto);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static double calcularMontoAlquiler(int idAuto, int cantdDias) {
        Gson gson = new Gson();
        double totalAlquiler = 0;

        if (!carpetaAuto.exists()) {
            carpetaAuto.mkdirs();
        }

        if (!archivoAuto.exists()) {
            try {
                archivoAuto.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

         boolean hayAutos = false;


        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String objAuto;
            while ((objAuto = reader.readLine()) != null) {
                Auto auto = gson.fromJson(objAuto, Auto.class);
                hayAutos = true;
                if (auto != null && auto.idAuto == idAuto) {
                    totalAlquiler = auto.precio * cantdDias;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!hayAutos) {
            System.out.println("No hay autos registrados");
        }

        return totalAlquiler;
    }

     static void cambiarEstadoAuto(int idAuto, String nuevoEstado) {
        Gson gson = new Gson();
        ArrayList<Auto> autos = new ArrayList<>();
        boolean autoEncontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String objAuto;
            while ((objAuto = reader.readLine()) != null) {
                Auto auto = gson.fromJson(objAuto, Auto.class);
                if (auto != null) {
                    if (auto.idAuto == idAuto) {
                        auto.estado = nuevoEstado;
                        autoEncontrado = true;
                        System.out.println("Auto ID " + idAuto + " actualizado a estado: " + nuevoEstado);
                    }
                    autos.add(auto);
                 }
            }

            if (!autoEncontrado) {
                System.out.println("Auto no encontrado - ID: " + idAuto);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
         }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoAuto, false))) {
            for (Auto auto : autos) {
                String json = gson.toJson(auto);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void cambiarEstadoAuto(String patente, String nuevoEstado) {
        Gson gson = new Gson();
        ArrayList<Auto> autos = new ArrayList<>();
        boolean autoEncontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String objAuto;
            while ((objAuto = reader.readLine()) != null) {
                  Auto auto = gson.fromJson(objAuto, Auto.class);
                if (auto != null) {
                    if (auto.patente.toLowerCase().equals(patente.toLowerCase()) ) {
                        auto.estado = nuevoEstado;
                        autoEncontrado = true;
                        System.out.println("Auto PATENTE " + patente + " actualizado a estado: " + nuevoEstado);
                    }
                    autos.add(auto);
                }
            }

            if (!autoEncontrado) {
                System.out.println("Auto no encontrado - PATENTE: " + patente);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoAuto, false))) {
            for (Auto auto : autos) {
                String json = gson.toJson(auto);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean esModeloBuscado(int idAuto, String marcaBuscada, String modeloBuscado) {
        Gson gson = new Gson();

        if (!carpetaAuto.exists()) {
            return false;
        }

        if (!archivoAuto.exists()) {
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAuto))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Auto auto = gson.fromJson(linea, Auto.class);
                if (auto != null && auto.idAuto == idAuto) {
                    if (auto.marca != null && auto.modelo != null &&
                            auto.marca.equalsIgnoreCase(marcaBuscada) &&
                            auto.modelo.equalsIgnoreCase(modeloBuscado)) {
                        return true;
                    }
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }



}
