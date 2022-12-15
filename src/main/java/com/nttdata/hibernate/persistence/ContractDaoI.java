/**
 * 
 */
package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * @author Eva
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract>{

	List<Contract> searchByIdCliente(Long clientId);
	


}
