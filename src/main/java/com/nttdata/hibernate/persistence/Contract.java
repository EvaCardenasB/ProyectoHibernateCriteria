package com.nttdata.hibernate.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
/**
 * Entidad tabla contrato
 * 
 * @author Eva
 *
 */
@Entity
@Table(name = "CONTRACT")
public class Contract extends AbstractEntity implements Serializable {
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Fecha de vigencia del contrato */
	private String effective_date;

	/** Fecha de vigencia del contrato */
	private String expiry_date;

	/** Precio mensual */
	private Double monthly_price;

	/** Cliente al que pertenece (FK) */
	private Client client;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContatoId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContatoId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the fecha_vigencia
	 */
	@Column(name = "FECHA_VIGENCIA", nullable = false)
	public String getFecha_vigencia() {
		return effective_date;
	}

	/**
	 * @param fecha_vigencia the fecha_vigencia to set
	 */
	public void setFecha_vigencia(String fecha_vigencia) {
		this.effective_date = fecha_vigencia;
	}

	/**
	 * @return the fecha_caducidad
	 */
	@Column(name = "FECHA_CADUCIDAD", nullable = false)
	public String getFecha_caducidad() {
		return expiry_date;
	}

	/**
	 * @param fecha_caducidad the fecha_caducidad to set
	 */
	public void setFecha_caducidad(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	/**
	 * @return the precio
	 */
	@Column(name = "MENSUALIDAD", nullable = false)
	public Double getPrecio() {
		return monthly_price;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.monthly_price = precio;
	}

	/**
	 * @return the cliente
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID")
	public Client getCliente() {
		return client;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Client cliente) {
		this.client = cliente;
	}

	@Override
	public String toString() {
		return "Cliente [contractId=" + contractId + ", fecha_vigencia=" + effective_date + ", fecha_caducidad=" + expiry_date
				+ ", precio=" + monthly_price + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public Long getId() {
		return this.contractId;
	}

	@Override
	public void setId(Long id) {
		this.contractId = id;
	}

}
