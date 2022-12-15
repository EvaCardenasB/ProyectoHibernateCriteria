/**
 * 
 */
package com.nttdata.hibernate.service;

import java.util.List;

import com.nttdata.hibernate.persistence.Contract;

/**
 * @author Eva
 *
 */
public interface ContratoManagementServiceI {

	/**
	 * Insertar nuevo contrato
	 * 
	 * @param newContrato
	 */
	public void insertNewContrato(final Contract newContrato);

	/**
	 * Actualizar contrato
	 * 
	 * @param updatedContrato
	 */
	public void updateContrato(final Contract updatedContrato);

	/**
	 * Eliminar contrato
	 * 
	 * @param deletedContrato
	 */
	public void deleteContrato(final Contract deletedContrato);

	/**
	 * Buscar contratos por id
	 * 
	 * @param contratoId
	 */
	public Contract searchById(final Long contratoId);

	/**
	 * Obtener todos los contratos
	 * 
	 * @return
	 */
	public List<Contract> searchAll();

	/**
	 * Obtiene clientes mediante un contrato
	 * 
	 * @param id
	 * @return
	 */
	public List<Contract> searchByIdCliente(final Long id);

}
