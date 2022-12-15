/**
 * 
 */
package com.nttdata.hibernate.service;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;


import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.ContractDaoI;
import com.nttdata.hibernate.persistence.ContractDaoImpl;

/**
 * @author Eva
 *
 */
public class ContratoManagementServiceImpl implements ContratoManagementServiceI {
	private ContractDaoI contratoDao;

	public ContratoManagementServiceImpl(final Session session) {
		this.contratoDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContrato(Contract newContrato) {

		// Verificación de nulidad o inexistencia en la DB
		if (newContrato != null && newContrato.getContatoId() == null) {

			// Insercción del nuevo cliente.
			contratoDao.insert(newContrato);
		}

	}

	@Override
	public void updateContrato(Contract updatedContrato) {
		// Verificación de nulidad o inexistencia en la DB
		if (updatedContrato != null && updatedContrato.getContatoId() == null) {

			// Insercción del nuevo cliente.
			contratoDao.update(updatedContrato);
		}

	}

	@Override
	public void deleteContrato(Contract deletedContrato) {
		// Verificación de nulidad o inexistencia en la DB
		if (deletedContrato != null && deletedContrato.getContatoId() == null) {

			// Insercción del nuevo cliente.
			contratoDao.delete(deletedContrato);
		}

	}

	@Override
	public Contract searchById(Long contratoId) {
		Contract contract = null;

		// Verificación de nulidad
		if (contratoId != null) {

			// Obtención del contrato por id
			contract = contratoDao.searchById(contratoId);
		}

		return contract;

	}

	@Override
	public List<Contract> searchAll() {
		List<Contract> contratosList = new ArrayList<>();

		// Obtención de contratos.
		contratosList = contratoDao.searchAll();

		return contratosList;

	}

	@Override
	public List<Contract> searchByIdCliente(Long idCliente) {
		List<Contract> contractList = new ArrayList<>();
		// Verificación de nulidad o inexistencia en la DB
				if (idCliente != null) {

					// Buscar el cliente por id en la lista de contratos.
					contractList = contratoDao.searchByIdCliente(idCliente);
				}
				return contractList;
	}

}
