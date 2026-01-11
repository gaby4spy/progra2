package imp;

import com.google.gson.Gson;
import java.io.*;

public class Chofer {
    int idChofer;
    String nombre;
    String licencia;

    static File carpetaChoferes;
    static File archivoChofer;
    static File carpetaRaiz;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome, "Programa");
        carpetaChoferes = new File(carpetaRaiz, "Choferes");
        archivoChofer = new File(carpetaChoferes, "choferes.json");

        if (!carpetaChoferes.exists()) {
            carpetaChoferes.mkdirs();
        }
    }

    public Chofer(int idChofer, String nombre, String licencia) {
        this.idChofer = idChofer;
        this.nombre = nombre;
        this.licencia = licencia;
    }

    public static int generarNuevoId() {
        Gson gson = new Gson();
        int maxId = 0;

        if (!archivoChofer.exists()) {
            try {
                archivoChofer.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoChofer))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Chofer c = gson.fromJson(linea, Chofer.class);
                if (c != null && c.idChofer > maxId) {
                    maxId = c.idChofer;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }

    public static boolean licenciaExiste(String licenciaBuscada) {
        Gson gson = new Gson();
        if (!archivoChofer.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoChofer))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Chofer c = gson.fromJson(linea, Chofer.class);
                if (c != null && c.licencia.equalsIgnoreCase(licenciaBuscada)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean idChoferExiste(int idBuscado) {
        Gson gson = new Gson();
        if (!archivoChofer.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoChofer))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Chofer c = gson.fromJson(linea, Chofer.class);
                if (c != null && c.idChofer == idBuscado) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void registrarChofer(String nombre, String licencia) {
        if (licenciaExiste(licencia)) {
            System.out.println("⚠ La licencia ya está registrada. No se puede crear el chofer.");
            return;
        }

        int id = generarNuevoId();
        Chofer c = new Chofer(id, nombre, licencia);
        Gson gson = new Gson();
        String json = gson.toJson(c);

        try (FileWriter writer = new FileWriter(archivoChofer, true)) {
            writer.write(json + System.lineSeparator());
            System.out.println("✅ Chofer registrado con ID: " + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Chofer recuperarPorId(int idBuscado) {
        Gson gson = new Gson();
        if (!archivoChofer.exists()) return null;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoChofer))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Chofer c = gson.fromJson(linea, Chofer.class);
                if (c != null && c.idChofer == idBuscado) {
                    return c;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
