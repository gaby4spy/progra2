package imp;

import com.google.gson.Gson;
import java.io.*;

class Cliente {
    int id;
    String nombre;
    String apellido;
    String domicilio;
    String dni;
    String telefono;

    static File carpetaClientes;
    static File archivoCliente;
    static File carpetaRaiz;

    static {
        String userHome = System.getProperty("user.home");
        carpetaRaiz = new File(userHome,"Programa");
        carpetaClientes = new File(carpetaRaiz, "Clientes");
        archivoCliente = new File(carpetaClientes, "clientes.json");
    }

    Cliente(int id, String nombre, String apellido , String dni,String telefono, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni=dni;
        this.telefono=telefono;
        this.domicilio = domicilio;
    }

    static int generarNuevoId() {
        Gson gson = new Gson();
        int maxId = 0;

        if (!archivoCliente.exists()) {
            try {
                archivoCliente.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCliente))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Cliente cliente = gson.fromJson(linea, Cliente.class);
                if (cliente != null && cliente.id > maxId) {
                    maxId = cliente.id;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId + 1;
    }

    static boolean verificarDniCliente(String dni) {
        Gson gson = new Gson();
        boolean flag = false;

        if (!carpetaClientes.exists()) {
            carpetaClientes.mkdirs();
        }

        if (!archivoCliente.exists()) {
            try {
                archivoCliente.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCliente))) {
            String objCliente;
            while ((objCliente = reader.readLine()) != null) {
                Cliente cliente = gson.fromJson(objCliente,Cliente.class);
                if (cliente != null && cliente.dni!= null && cliente.dni.toLowerCase().equals(dni.toLowerCase())) {
                    flag = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flag;
    }

    static void guardarArchivoCliente(String nombre, String apellido, String dni, String telefono, String domicilio) {
        // Asegura existencia de carpetas necesarias
        if (!carpetaRaiz.exists()) carpetaRaiz.mkdir();
        if (!carpetaClientes.exists()) carpetaClientes.mkdir();

        // Genera nuevo ID y crea objeto Cliente
        int id = generarNuevoId();
        Cliente cliente = new Cliente(id, nombre, apellido, dni, telefono, domicilio);

        Gson gson = new Gson();
        String clienteJson = gson.toJson(cliente);
        boolean verificarDniCliente = verificarDniCliente(dni);


        // Guarda cliente en archivo

        if (verificarDniCliente==true){
            System.out.println("EL DNI YA ESTA ASOCAIDO A UN CLIENTE");
        }else {
            try (FileWriter writer = new FileWriter(archivoCliente, true)) {
                writer.write(clienteJson + System.lineSeparator());
                System.out.println("CLIENTE CREADO: " + id);
            } catch (IOException e) {
                System.err.println("Error al guardar el cliente: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }




    static String existeCliente(int idBuscado) {
        Gson gson = new Gson();

        if (!carpetaClientes.exists()) {
            carpetaClientes.mkdirs();
        }

        if (!archivoCliente.exists()) {
            try {
                archivoCliente.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        boolean hayClientes = false;
        boolean clienteEncontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCliente))) {
            String objCliente;
            while ((objCliente = reader.readLine()) != null) {
                Cliente cliente = gson.fromJson(objCliente, Cliente.class);
                hayClientes = true;
                if (cliente != null && cliente.id == idBuscado) {
                    clienteEncontrado = true;
                    break; // Ya lo encontramos, salimos
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayClientes) {
            return "NO HAY CLIENTES REGISTRADOS";
        }

        if (!clienteEncontrado) {
            return "NO SE ENCONTRÓ EL CLIENTE";
        }

        return null; // Todo OK
    }


    static Object obtenerClientePorId(int idBuscado) {
        Gson gson = new Gson();

        if (!carpetaClientes.exists()) {
            carpetaClientes.mkdirs();
        }

        if (!archivoCliente.exists()) {
            try {
                archivoCliente.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        boolean hayClientes = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCliente))) {
            String objCliente;
            while ((objCliente = reader.readLine()) != null) {
                Cliente cliente = gson.fromJson(objCliente, Cliente.class);
                if (cliente != null) {
                    hayClientes = true;
                    if (cliente.id == idBuscado) {
                        return cliente; // Encontrado, devolvemos el objeto
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hayClientes) {
            return "NO HAY CLIENTES REGISTRADOS";
        }

        return "NO SE ENCONTRÓ EL CLIENTE";
    }



}
