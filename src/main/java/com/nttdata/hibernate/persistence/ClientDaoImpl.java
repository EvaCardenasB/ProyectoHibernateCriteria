package com.nttdata.hibernate.persistence;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;


/**
 * @author Eva
 *
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	/**
	 * Sesión de conexión a BD
	 */
	private Session session;

	/**
	 * Método constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

		//Metodo comentado del taller2, mas abajo realizado con criteria
	/*
	 * @Override public List<Cliente> searchByNameAndSurname(String name, String
	 * primer_apellido, String segundo_apellido) {
	 * 
	 * // Verificación de sesión abierta. if (!session.getTransaction().isActive())
	 * { session.getTransaction().begin(); }
	 * 
	 * // Localiza clientes en función del nombre. final List<Cliente> clientesList
	 * = session.createQuery("FROM CLIENTE WHERE NAME='" + name +
	 * "' AND PRIMER_APELLIDO='" + primer_apellido + "' AND SEGUNDO_APELLIDO='" +
	 * segundo_apellido).list();
	 * 
	 * return clientesList; }
	 */
	@Override
	public List<Client> searchByNameAndSurname(String name, String surname1, String surname2) {
		
		//Consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery <Client> cquery = cb.createQuery(Client.class);
		final Root <Client> rootP = cquery.from(Client.class);
		
		//Where
		final Predicate pr1 = cb.equal(rootP.get("name"), name);
		final Predicate pr2 = cb.equal(rootP.get("surname1"), surname1);
		final Predicate pr3 = cb.equal(rootP.get("surname2"), surname2);
		
		cquery.select(rootP).where(cb.and(pr1,pr2,pr3));
		
		//Ejecuta la consulta y devuelve una lista con los resultados
		return session.createQuery(cquery).getResultList();
	}
}
