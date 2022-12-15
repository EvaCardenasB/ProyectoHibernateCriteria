package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Entidad de tabla CLIENTE
 * 
 * @author Eva
 *
 */
@Entity
@Table(name = "CLIENT")
public class Client extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clientId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String surname1;

	/** Segundo apellido del cliente */
	private String surname2;

	/** dni del cliente */
	private String dni;

	/** Lista de contratos */
	private List<Contract> contractList;

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname1
	 */
	@Column(name = "SURNAME_1", nullable = false)
	public String getSurname1() {
		return surname1;
	}

	/**
	 * @param surname1 the surname1 to set
	 */
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	/**
	 * @return the surname2
	 */
	@Column(name = "SURNAME_2", nullable = false)
	public String getSurname2() {
		return surname2;
	}

	/**
	 * @param surname2 the surname2 to set
	 */
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "DNI", unique = true, nullable = false, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @return the contractList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
	public List<Contract> getContractList() {
		return contractList;
	}

	/**
	 * @param contractList
	 */
	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	@Override
	public String toString() {
		return "Cliente [clientId=" + clientId + ", name=" + name + ", surname1=" + surname1 + ", surname2=" + surname2
				+ ", dni=" + dni + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Client.class;
	}

	@Override
	public Long getId() {
		return this.clientId;
	}

	@Override
	public void setId(Long id) {
		this.clientId = id;
	}

}
