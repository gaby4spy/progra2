package imp;

import com.google.gson.Gson;
import java.io.*;

public class Flota {

    static File carpetaRaiz;
    static File carpetaVehiculos;
    static File archivoVehiculos;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome, "FlotaVehiculos");
        carpetaVehiculos = new File(carpetaRaiz, "Datos");
        archivoVehiculos = new File(carpetaVehiculos, "vehiculos.txt");

        if (!carpetaVehiculos.exists()) {
            carpetaVehiculos.mkdirs();
        }
    }


    public static void agregarVehiculo(Vehiculo v) {
        try {
            if (idExiste(v.getIdentificador())) {
                throw new VehiculoDuplicadoException(v.getIdentificador());
            }

            if (!carpetaRaiz.exists()) carpetaRaiz.mkdir();
            if (!carpetaVehiculos.exists()) carpetaVehiculos.mkdir();

            try (FileWriter writer = new FileWriter(archivoVehiculos, true)) {
                Gson gson = new Gson();
                String json = gson.toJson(v);
                writer.write(json + "\n");
                System.out.println("Vehículo guardado exitosamente.");
            }

        } catch (VehiculoDuplicadoException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        }
    }


    public static void listarMarcasVehiculos() {
        if (!archivoVehiculos.exists()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        boolean hayVehiculos = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoVehiculos))) {
            String linea;
            System.out.println("==== MARCAS DE VEHÍCULOS ====");
            while ((linea = reader.readLine()) != null) {
                hayVehiculos = true;

                int start = linea.indexOf("\"marcaVehiculo\"");
                if (start != -1) {
                    int colon = linea.indexOf(":", start);
                    int firstQuote = linea.indexOf("\"", colon);
                    int secondQuote = linea.indexOf("\"", firstQuote + 1);
                    if (firstQuote != -1 && secondQuote != -1) {
                        String marca = linea.substring(firstQuote + 1, secondQuote);
                        System.out.println(marca);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        if (!hayVehiculos) {
            System.out.println("No hay vehículos registrados.");
        }
    }


    public static void calcularKilometrajePorTipo() {
        if (!archivoVehiculos.exists()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        int totalAutomovil = 0;
        int totalCamion = 0;
        int totalMoto = 0;
        boolean hayVehiculos = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoVehiculos))) {
            String linea;
            Gson gson = new Gson();

            while ((linea = reader.readLine()) != null) {
                hayVehiculos = true;

                if (linea.contains("capacidadMotor") && linea.contains("numeroPuertas")) {
                    Automovil a = gson.fromJson(linea, Automovil.class);
                    totalAutomovil += a.getKilometraje();

                } else if (linea.contains("capacidadCarga")) {
                    Camion c = gson.fromJson(linea, Camion.class);
                    totalCamion += c.getKilometraje();

                } else if (linea.contains("tipoMotor") && linea.contains("capacidadTanque")) {
                    Motocicleta m = gson.fromJson(linea, Motocicleta.class);
                    totalMoto += m.getKilometraje();
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        if (!hayVehiculos) {
            System.out.println("No hay vehículos registrados.");
        } else {
            System.out.println("==== KILOMETRAJE POR TIPO ====");
            System.out.println("Automóviles: " + totalAutomovil + " km");
            System.out.println("Camiones: " + totalCamion + " km");
            System.out.println("Motocicletas: " + totalMoto + " km");
            System.out.println("TOTAL GLOBAL: " + (totalAutomovil + totalCamion + totalMoto) + " km");
        }
    }


    public static void mostrarDatosSiExiste(int id) {
        try {
            if (!idExiste(id)) {
                throw new VehiculoNoEncontradoException(id);
            }

            Gson gson = new Gson();
            try (BufferedReader reader = new BufferedReader(new FileReader(archivoVehiculos))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue;

                    if (linea.contains("capacidadMotor") && linea.contains("numeroPuertas")) {
                        Automovil a = gson.fromJson(linea, Automovil.class);
                        if (a.getIdentificador() == id) {
                            a.imprimirDatos();
                            return;
                        }

                    } else if (linea.contains("capacidadCarga")) {
                        Camion c = gson.fromJson(linea, Camion.class);
                        if (c.getIdentificador() == id) {
                            c.imprimirDatos();
                            return;
                        }

                    } else if (linea.contains("tipoMotor") && linea.contains("capacidadTanque")) {
                        Motocicleta m = gson.fromJson(linea, Motocicleta.class);
                        if (m.getIdentificador() == id) {
                            m.imprimirDatos();
                            return;
                        }
                    }
                }
            }

        } catch (VehiculoNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }


    private static boolean idExiste(int id) {
        if (!archivoVehiculos.exists()) return false;

        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoVehiculos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                if (linea.contains("capacidadMotor") && linea.contains("numeroPuertas")) {
                    Automovil a = gson.fromJson(linea, Automovil.class);
                    if (a.getIdentificador() == id) return true;

                } else if (linea.contains("capacidadCarga")) {
                    Camion c = gson.fromJson(linea, Camion.class);
                    if (c.getIdentificador() == id) return true;

                } else if (linea.contains("tipoMotor") && linea.contains("capacidadTanque")) {
                    Motocicleta m = gson.fromJson(linea, Motocicleta.class);
                    if (m.getIdentificador() == id) return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return false;
    }

    public static void imprimirDatosFlota() {
        if (!archivoVehiculos.exists()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        Gson gson = new Gson();
        boolean hayVehiculos = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoVehiculos))) {
            String linea;
            System.out.println("Flota datos");
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                hayVehiculos = true;

                // Automóvil: contiene "capacidadMotor" y "numeroPuertas"
                if (linea.contains("\"capacidadMotor\"") && linea.contains("\"numeroPuertas\"")) {
                    Automovil auto = gson.fromJson(linea, Automovil.class);
                    auto.imprimirDatos();


                    // Camión: contiene "capacidadCarga" y NO "tipoMotor"
                } else if (linea.contains("\"capacidadCarga\"") && !linea.contains("\"tipoMotor\"")) {
                    Camion camion = gson.fromJson(linea, Camion.class);
                    camion.imprimirDatos();


                    // Motocicleta: contiene "tipoMotor" y "capacidadTanque"
                } else if (linea.contains("\"tipoMotor\"") && linea.contains("\"capacidadTanque\"")) {
                    Motocicleta moto = gson.fromJson(linea, Motocicleta.class);
                    moto.imprimirDatos();


                } else {
                    System.out.println("Vehículo desconocido: " + linea);

                }
            }

            if (!hayVehiculos) {
                System.out.println("No hay vehículos registrados.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }




}

