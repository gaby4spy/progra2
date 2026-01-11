package gm.zona_fit;

import gm.zona_fit.Servicio.IClientesServicio;
import gm.zona_fit.modelo.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClientesServicio clienteServicio;

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();



	@Override
	public void run(String... args) throws Exception {
		logger.info("***** Zona Fit *****");
		zonaFitApp();
	}

	private void zonaFitApp() {
		logger.info("***** Zona Fit *****");
		boolean salir = false;
		Scanner consola = new Scanner(System.in);

		while (!salir) {
			int opcion = mostrarMenu(consola);
			salir = ejecutarOpcione(consola, opcion);
			logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola) {
		logger.info("""
                \n===== MENÚ =====
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir  
                Elige una opción:
                """);

		String entrada = consola.nextLine().trim();

		if (entrada.isEmpty()) {
			logger.warn("⚠️ No ingresaste nada, por favor elige un número.");
			return -1; // opción inválida
		}

		try {
			return Integer.parseInt(entrada);
		} catch (NumberFormatException e) {
			logger.warn("⚠️ Entrada inválida. Debes ingresar un número.");
			return -1; // opción inválida
		}
	}

	private boolean ejecutarOpcione(Scanner consola, int opcion) {
		boolean salir = false;

		switch (opcion) {
			case 1 -> {
				logger.info(nl + "-- Listado de clientes --" + nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				for (Cliente c : clientes) {
					logger.info(c.toString() + nl);
				}
			}
			case 2 -> {
				logger.info(nl + "Buscar cliente por id ---" + nl);
				String entrada = consola.nextLine().trim();
				try {
					int idCliente = Integer.parseInt(entrada);
					Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
					if (cliente != null) {
						logger.info("Cliente encontrado: " + cliente + nl);
					} else {
						logger.info("Cliente no encontrado." + nl);
					}
				} catch (NumberFormatException e) {
					logger.warn("⚠️ ID inválido, debes ingresar un número.");
				}
			}case 3->{
				logger.info("agregar estudiante " + nl);
				logger.info("Nombre : ");
				var nombre = consola.nextLine();
				logger.info("Apellido : ");
				var apellido = consola.nextLine();
				logger.info("membresia: ");
				var membresia =Integer.parseInt(consola.nextLine());
				var cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setMembresia(membresia);
				clienteServicio.guardarCliente(cliente);
				logger.info("cliente agregado" + cliente);

			}case  4 -> {
				logger.info("modificar cliente ");

				logger.info("id cliente");
				var idCliente= Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente!=null){
					logger.info("Nombre : ");
					var nombre = consola.nextLine();
					logger.info("apellido :");
					var apellido= consola.nextLine();
					logger.info("Membresia : ");
					var membresia = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					logger.info("cliente modificado " + cliente + nl);
				}else {
					logger.info("cliente no encontrado ");
				}


			} case 5->{
				logger.info("eliminar cliente");
				logger.info("id cliente");
				var idCliente = Integer.parseInt(consola.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente!= null){
					clienteServicio.eliminarClinete(cliente);
					logger.info("cliente eliminado " + cliente + nl) ;

				}else {
					logger.info("cliente no encontrado ");
				}
			}

			case 6 -> {
				logger.info("👋 Saliendo de la aplicación...");
				salir = true;
			}

			default -> logger.info("⚠️ Opción no válida.");
		}

		return salir;
	}
}
