package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Eva
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * @return the id
	 */
	public abstract Long getId();

	/**
	 * @param id the id to set
	 */
	public abstract void setId(final Long id);

	
}

