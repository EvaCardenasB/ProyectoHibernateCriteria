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
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI{
	

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@Override
	public List<Contract> searchByIdCliente(Long clientId) {
		
		//Consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery <Contract> cquery = cb.createQuery(Contract.class);
		final Root <Contract> rootP = cquery.from(Contract.class);
		
		//Where
		final Predicate pr1 = cb.equal(rootP.get("cliente"), clientId);
		
		
		cquery.select(rootP).where(cb.and(pr1));
		
		//Ejecuta la consulta y devuelve una lista con los resultados
		return session.createQuery(cquery).getResultList();
	}

}
