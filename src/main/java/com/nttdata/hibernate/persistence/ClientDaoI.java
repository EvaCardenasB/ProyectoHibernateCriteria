package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * @author Eva
 *
 */
public interface ClientDaoI extends CommonDaoI<Client> {

	/**
	 * Obtiene los clientes por nombre y apellidos.
	 * @param name
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @return List<Cliente>
	 */
	public List<Client> searchByNameAndSurname(final String name, final String primer_apellido,final String segundo_apellido);

}
