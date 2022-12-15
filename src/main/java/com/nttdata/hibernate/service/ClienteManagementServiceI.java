package com.nttdata.hibernate.service;

import java.util.List;

import com.nttdata.hibernate.persistence.Client;

/**
 * @author Eva
 *
 */

public interface ClienteManagementServiceI {

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	
	/**
	 * Actualiza un cliente
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	
	/**
	 * Elimina un cliente
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);


	/**
	 * Obtiene un cliente mediante su id
	 * 
	 * @param clientId
	 * @return
	 */
	public Client searchById(final Long clientId);
	
	/**
	 * Obtiene todos los clientes de la DB
	 * 
	 * @return
	 */
	public List<Client> searchAll();
	
	/**
	 * Obtiene clientes mediante su nombre y apellidos
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return
	 */
	public List<Client> searchByNameAndSurname(final String name, final String surname1,final String surname2);

}

