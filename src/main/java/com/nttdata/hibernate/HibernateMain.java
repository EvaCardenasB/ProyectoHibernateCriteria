package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.service.ClienteManagementServiceI;
import com.nttdata.hibernate.service.ClienteManagementServiceImpl;
import com.nttdata.hibernate.service.ContratoManagementServiceI;
import com.nttdata.hibernate.service.ContratoManagementServiceImpl;

/**
 * Clase principal
 * 
 * @author Eva
 */
public class HibernateMain {
	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClienteManagementServiceI clienteService = new ClienteManagementServiceImpl(session);
		final ContratoManagementServiceI contratoService = new ContratoManagementServiceImpl(session);

		// Generación de clientes.
		final Client cliente1 = new Client();
		cliente1.setName("Eva");
		cliente1.setSurname1("Cardenas");
		cliente1.setSurname2("Bermudez");
		cliente1.setDni("29628444M");

		final Client cliente2 = new Client();
		cliente2.setName("Isabel");
		cliente2.setSurname1("Sanchez");
		cliente2.setSurname2("Lopez");
		cliente2.setDni("29345678J");

		final Client cliente3 = new Client();
		cliente3.setName("Javier");
		cliente3.setSurname1("Cortes");
		cliente3.setSurname2("Garcia");
		cliente3.setDni("29876543G");

		final Client cliente4 = new Client();
		cliente4.setName("Jose");
		cliente4.setSurname1("Fernandez");
		cliente4.setSurname2("Flores");
		cliente4.setDni("29897865H");

		// Insertar los clientes
		clienteService.insertNewClient(cliente1);
		clienteService.insertNewClient(cliente2);
		clienteService.insertNewClient(cliente3);
		clienteService.insertNewClient(cliente4);

		// Generacion de contratos
		final Contract contrato1 = new Contract();
		contrato1.setFecha_vigencia("17/06/2022");
		contrato1.setFecha_caducidad("17/06/2024");
		contrato1.setPrecio(1050.00);

		final Contract contrato2 = new Contract();
		contrato2.setFecha_vigencia("05/07/2022");
		contrato2.setFecha_caducidad("05/07/2024");
		contrato2.setPrecio(1050.00);

		final Contract contrato3 = new Contract();
		contrato3.setFecha_vigencia("20/09/2022");
		contrato3.setFecha_caducidad("");
		contrato3.setPrecio(1050.00);

		final Contract contrato4 = new Contract();
		contrato4.setFecha_vigencia("15/10/2022");
		contrato4.setFecha_caducidad("");
		contrato4.setPrecio(1050.00);

		// Asignacion de clientes a los contratos
		contrato1.setCliente(cliente1);
		contrato2.setCliente(cliente1);
		contrato3.setCliente(cliente2);
		contrato4.setCliente(cliente3);

		// Insertar los contratos
		contratoService.insertNewContrato(contrato1);
		contratoService.insertNewContrato(contrato2);
		contratoService.insertNewContrato(contrato3);
		contratoService.insertNewContrato(contrato4);

		// Actualizacion de clientes 
		clienteService.updateClient(cliente1);
		clienteService.updateClient(cliente2);
		clienteService.updateClient(cliente3);

		// Actualizar cliente.
		cliente4.setSurname2("Sanchez");
		cliente4.setDni("29897865T");
		clienteService.updateClient(cliente4);

		// Eliminar cliente.
		clienteService.deleteClient(cliente4);

		// Buscar clientes por id.
		System.out.println("Obetener cliente por su id: ");
		System.out.println(clienteService.searchById((long) 2));
		System.out.println("-------------------------------");

		// Obtener todos los usuarios de la DB
		System.out.println("Obtener todos los usuarios de la DB: ");
		System.out.println(clienteService.searchAll());
		System.out.println("-------------------------------");

		// Consultar clientes por nombre y apellidos con Criteria
		System.out.println("Consultar clientes por nombre y apellidos");
		List<Client> clientes = clienteService.searchByNameAndSurname("Eva", "Cardenas", "Bermudez");

		for (final Client cliente : clientes) {
			System.out.println(cliente.getName() + " " + cliente.getSurname1() + " " + cliente.getSurname2());
		}
		System.out.println("-------------------------------");

		/*
		 * Devuelve los contratos asociados a un cliente con Criteria
		 */
		System.out.println("Obtener todos los contractos asociados a un cliente por su id:");
		long id = 1;
		List<Contract> contractList = contratoService.searchByIdCliente(id);
		System.out.print("El cliente con id " + id + " ,");
		for (final Contract contract : contractList) {

			System.out.print(contractList == null ? "no tiene contractos asociados"
					: contractList.size() > 1 ? "tiene los siguientes contratos \n"
							: "tiene el contrato \n" + "IdContrato: ");
			System.out.println(contract.getId() + " fecha de vigencia: " + contract.getFecha_vigencia()
					+ " fecha de caducidad: " + contract.getFecha_caducidad() + " precio: " + contract.getPrecio());
		}

		// Cierre de sesión.
		session.close();

	}

}
