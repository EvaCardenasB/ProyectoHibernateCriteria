package com.nttdata.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.ClientDaoI;
import com.nttdata.hibernate.persistence.ClientDaoImpl;

/** 
 * @author Eva
 */
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	private ClientDaoI clientDao;

	public ClienteManagementServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}

	@Override
	public void insertNewClient(final Client newClient) {

		// Verificación de nulidad o inexistencia en la DB
		if (newClient != null && newClient.getClientId() == null) {

			// Insercción del nuevo cliente.
			clientDao.insert(newClient);
		}

	}

	@Override
	public void updateClient(final Client updatedClient) {

		// Verificación de nulidad o inexistencia en la DB
		if (updatedClient != null && updatedClient.getClientId() != null) {

			// Actualización del cliente.
			clientDao.update(updatedClient);
		}

	}

	@Override
	public void deleteClient(final Client deletedClient) {

		// Verificación de nulidad o inexistencia en la DB
		if (deletedClient != null && deletedClient.getClientId() != null) {

			// Eliminación del cliente
			clientDao.delete(deletedClient);
		}

	}

	@Override
	public Client searchById(final Long clientId) {
		Client client = null;

		// Verificación de nulidad
		if (clientId != null) {

			// Obtención del cliente por id
			client = clientDao.searchById(clientId);
		}

		return client;
	}

	@Override
	public List<Client> searchByNameAndSurname(final String name, final String surname1,
			final String surname2) {

		List<Client> clientList = new ArrayList<>();

		// Obtención del cliente por nombre y apellidps
		clientList = clientDao.searchByNameAndSurname(name, surname1, surname2);

		return clientList;
	}

	@Override
	public List<Client> searchAll() {
		return clientDao.searchAll();
	}

}
