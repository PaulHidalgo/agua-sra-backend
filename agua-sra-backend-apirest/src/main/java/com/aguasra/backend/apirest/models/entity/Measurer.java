package com.aguasra.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

/**
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "measurers")
public class Measurer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMeasurer;

	@NotEmpty
	@Column(nullable = false, length = 15)
	private String brandMeasurer;

	@NotEmpty
	@Column(nullable = false, length = 20)
	private String modelMeasurer;

	@NotEmpty
	@Column(nullable = false, length = 1)
	private String stateMeasurer;

	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Partner partner;

	@Temporal(TemporalType.DATE)
	private Date dateCreateMeasurer;

	@PrePersist
	public void prePersist() {
		dateCreateMeasurer = new Date();
	}

	public Long getCodMeasurer() {
		return codMeasurer;
	}

	public void setCodMeasurer(Long codMeasurer) {
		this.codMeasurer = codMeasurer;
	}

	public String getBrandMeasurer() {
		return brandMeasurer;
	}

	public void setBrandMeasurer(String brandMeasurer) {
		this.brandMeasurer = brandMeasurer;
	}

	public String getModelMeasurer() {
		return modelMeasurer;
	}

	public void setModelMeasurer(String modelMeasurer) {
		this.modelMeasurer = modelMeasurer;
	}

	public String getStateMeasurer() {
		return stateMeasurer;
	}

	public void setStateMeasurer(String stateMeasurer) {
		this.stateMeasurer = stateMeasurer;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Date getDateCreateMeasurer() {
		return dateCreateMeasurer;
	}

	public void setDateCreateMeasurer(Date dateCreateMeasurer) {
		this.dateCreateMeasurer = dateCreateMeasurer;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
