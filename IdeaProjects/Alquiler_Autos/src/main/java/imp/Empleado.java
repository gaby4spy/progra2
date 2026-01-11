package imp;

import com.google.gson.Gson;
import java.io.*;

public class Empleado {
    /// Atributos de instancia
    int idEmpleado;
    String nombre;
    String apellido;
    String cargo;

    /// Archivos y carpetas
    static File carpetaRaiz;
    static File carpetaEmpleado;
    static File archivoEmpleado;

    /// Inicialización estática de rutas
    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome,"Programa");
        carpetaEmpleado = new File(carpetaRaiz, "Empleados");
        archivoEmpleado = new File(carpetaEmpleado, "empleados.json");
    }

    /// Constructor
    Empleado(int idEmpleado, String nombre, String apellido, String cargo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }

    /// Genera un nuevo ID incremental
    static int generarNuevoId() {
        Gson gson = new Gson();
        int maxId = 0;

        if (!archivoEmpleado.exists()) {
            try {
                archivoEmpleado.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEmpleado))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Empleado empleado = gson.fromJson(linea, Empleado.class);
                if (empleado != null && empleado.idEmpleado > maxId) {
                    maxId = empleado.idEmpleado;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }

    /// Registra un nuevo empleado
    public static void registrarEmpleado(String nombre, String apellido, String cargo) {
        // Validación básica
        if (nombre == null || nombre.isBlank() ||
                apellido == null || apellido.isBlank() ||
                cargo == null || cargo.isBlank()) {
            System.out.println("ERROR: Nombre, apellido y cargo no pueden estar vacíos.");
            return;
        }

        // Crear carpetas si no existen
        if (!carpetaRaiz.exists()) {
            carpetaRaiz.mkdir();
        }

        if (!carpetaEmpleado.exists()) {
            carpetaEmpleado.mkdir();
        }

        int idEmpleado = generarNuevoId();
        Empleado empleado = new Empleado(idEmpleado, nombre.trim(), apellido.trim(), cargo.trim());
        Gson gson = new Gson();
        String empleadoJson = gson.toJson(empleado);

        try (FileWriter writer = new FileWriter(archivoEmpleado, true)) {
            writer.write(empleadoJson + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("EMPLEADO CREADO: " + idEmpleado);
    }

    /// Muestra todos los empleados registrados
    public static void leerArchivoEmpleados() {
        Gson gson = new Gson();

        if (!carpetaEmpleado.exists()) {
            carpetaEmpleado.mkdirs();
        }

        if (!archivoEmpleado.exists()) {
            try {
                archivoEmpleado.createNewFile();
                System.out.println("No tiene empleados registrados.");
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        boolean hayEmpleados = false;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEmpleado))) {
            String objetoJson;
            while ((objetoJson = lector.readLine()) != null) {
                Empleado empleado = gson.fromJson(objetoJson, Empleado.class);
                System.out.println(empleado.idEmpleado + " " + empleado.nombre + " " + empleado.apellido + " " + empleado.cargo);
                hayEmpleados = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayEmpleados) {
            System.out.println("No hay empleados registrados en el archivo.");
        }
    }

    /// Funcionalidades adicionales para el empleado
    public static void registrarCliente(String nombre, String apellido , String dni,String telefono, String domicilio) {
        /// alta a cliente
        Cliente.guardarArchivoCliente(  nombre, apellido,dni,telefono ,domicilio);
    }

    public static void crearAlquiler(int cliente ,int idSeguro, int diasAlquiler,int idChofer, int idAuto) {
        /// crea un alquiler
        Alquiler.registrarAlquiler(idSeguro,diasAlquiler,idChofer,idAuto,cliente);
    }

    public static void registrarDevolucion(String patente) {

        /// dado una patente cambia su estado de este a libre
        Auto.cambiarEstadoAuto(patente,"libre");

    }

    public static void filtrarAutoEstado(String estado) {
        /// ESTADO VALIDO = LIBRE,ALQUILADO ,REPARACION
        Auto.filtrarAutoEstado(estado);

        // lógica futura
    }
}
