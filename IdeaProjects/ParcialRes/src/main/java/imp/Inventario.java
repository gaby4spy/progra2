package imp;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    static File carpetaDispositivo;
    static File archivoDispositivos;
    static File carpetaRaiz;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome, "Inventario");
        carpetaDispositivo = new File(carpetaRaiz, "Productos");
        archivoDispositivos = new File(carpetaDispositivo, "productos.json");

        if (!carpetaDispositivo.exists()) {
            carpetaDispositivo.mkdirs();
        }
    }

    public static void guardarDispositivo(DispositivoElectronico d) {
        try {
            if (idExiste(d.getIdentificafor())) {
                throw new IllegalArgumentException("Ya existe un dispositivo con el ID " + d.getIdentificafor());
            }

            if (!carpetaRaiz.exists()) carpetaRaiz.mkdir();
            if (!carpetaDispositivo.exists()) carpetaDispositivo.mkdir();

            try (FileWriter writer = new FileWriter(archivoDispositivos, true)) {
                Gson gson = new Gson();
                String json = gson.toJson(d);
                writer.write(json + "\n");
                System.out.println("Dispositivo agregado exitosamente.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        }
    }


    static void listarNombresDispositivos() {
        if (!carpetaDispositivo.exists()) {
            System.out.println("No hay dispositivos registrados (carpeta no existe).");
            return;
        }

        if (!archivoDispositivos.exists()) {
            System.out.println("No hay dispositivos registrados (archivo no existe).");
            return;
        }

        boolean hayDispositivos = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDispositivos))) {
            String linea;
            System.out.println("=========================");
            while ((linea = reader.readLine()) != null) {
                hayDispositivos = true;

                int start = linea.indexOf("\"nombreDispositivo\"");
                if (start != -1) {
                    int colon = linea.indexOf(":", start);
                    if (colon != -1) {
                        int firstQuote = linea.indexOf("\"", colon);
                        int secondQuote = linea.indexOf("\"", firstQuote + 1);
                        if (firstQuote != -1 && secondQuote != -1) {
                            String nombre = linea.substring(firstQuote + 1, secondQuote);
                            System.out.println(nombre);
                        } else {
                            System.out.println("Dispositivo desconocido (sin valor claro): " + linea);
                        }
                    } else {
                        System.out.println("Dispositivo desconocido (sin ':'): " + linea);
                    }
                } else {
                    System.out.println("Dispositivo desconocido: " + linea);
                }
            }
            System.out.println("=========================");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayDispositivos) {
            System.out.println("No hay dispositivos registrados.");
        }
    }

    public static void calcularTiempoUsoPorTipo() {
        Gson gson = new Gson();

        if (!carpetaDispositivo.exists()) {
            System.out.println("No hay dispositivos registrados (carpeta no existe).");
            return;
        }

        if (!archivoDispositivos.exists()) {
            System.out.println("No hay dispositivos registrados (archivo no existe).");
            return;
        }

        boolean hayDispositivos = false;

        int totalLaptop = 0;
        int totalSmartphone = 0;
        int totalTablet = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDispositivos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                hayDispositivos = true;

                // Corrijo typo común
                linea = linea.replace("\"capactidad\"", "\"capacidad\"");

                if (linea.contains("memoriaRam") && linea.contains("capacidadAlmacenamiento")) {
                    Laptop laptop = gson.fromJson(linea, Laptop.class);
                    totalLaptop += laptop.getTiempoUsoAcumulado();
                    ///System.out.println("Laptop: " + laptop.getNombreDispositivo());

                } else if (linea.contains("capacidad") && linea.contains("pulgadas")) {
                    Smartphone smartphone = gson.fromJson(linea, Smartphone.class);
                    totalSmartphone += smartphone.getTiempoUsoAcumulado();
                    ///System.out.println("Smartphone: " + smartphone.getNombreDispositivo());

                } else if (linea.contains("resolucionPantalla")) {
                    Tablet tablet = gson.fromJson(linea, Tablet.class);
                    totalTablet += tablet.getTiempoUsoAcumulado();
                    ///System.out.println("Tablet: " + tablet.getNombreDispositivo());

                } else {
                    ///System.out.println("Dispositivo desconocido: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayDispositivos) {
            System.out.println("No hay dispositivos registrados.");
        } else {
            System.out.println("==== TIEMPO DE USO ====");
            System.out.println("Laptops: " + totalLaptop + " horas");
            System.out.println("Smartphones: " + totalSmartphone + " horas");
            System.out.println("Tablets: " + totalTablet + " horas");
            System.out.println("TOTAL GLOBAL: " + (totalLaptop + totalSmartphone + totalTablet) + " horas");
        }
    }



    public static void mostrarDatosDispositivo(int id) {
        if (!idExiste(id)) {
            System.out.println("No se encontró ningún dispositivo con el ID " + id);
            return;
        }

        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDispositivos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Prevención de errores

                if (linea.contains("memoriaRam") && linea.contains("capacidadAlmacenamiento")) {
                    Laptop laptop = gson.fromJson(linea, Laptop.class);
                    if (laptop != null && laptop.getIdentificafor() == id) {
                        laptop.imprimirDatos();
                        break;
                    }

                } else if (linea.contains("capactidad") && linea.contains("pulgadas")) {
                    Smartphone smartphone = gson.fromJson(linea, Smartphone.class);
                    if (smartphone != null && smartphone.getIdentificafor() == id) {
                        smartphone.imprimirDatos();
                        break;
                    }

                } else if (linea.contains("tieneTeclado") && linea.contains("esLigera")) {
                    Tablet tablet = gson.fromJson(linea, Tablet.class);
                    if (tablet != null && tablet.getIdentificafor() == id) {
                        tablet.imprimirDatos();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }



    public static boolean idExiste(int id) {
        Gson gson = new Gson();

        if (!carpetaDispositivo.exists() || !archivoDispositivos.exists()) {
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDispositivos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {

                if (linea.contains("memoriaRam") && linea.contains("capacidadAlmacenamiento")) {
                    Laptop laptop = gson.fromJson(linea, Laptop.class);
                    if (laptop.getIdentificafor() == id) return true;

                } else if (linea.contains("capactidad") && linea.contains("pulgadas")) {
                    Smartphone smartphone = gson.fromJson(linea, Smartphone.class);
                    if (smartphone.getIdentificafor() == id) return true;

                } else if (linea.contains("resolucionPantalla")) {
                    Tablet tablet = gson.fromJson(linea, Tablet.class);
                    if (tablet.getIdentificafor() == id) return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }






}
