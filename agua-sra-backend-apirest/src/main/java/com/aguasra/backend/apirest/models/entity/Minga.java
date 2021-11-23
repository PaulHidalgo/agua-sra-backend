package com.aguasra.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "mingas")
public class Minga implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMinga;

	@NotNull
	private Date dateMinga;

	@NotEmpty
	@Column(nullable = false, length = 15)
	private Long feeMinga;

	@NotEmpty
	@Column(nullable = false, length = 500)
	private String descriptionMinga;

	@NotEmpty
	@Column(nullable = false, length = 1)
	private String stateMinga;

	@Temporal(TemporalType.DATE)
	private Date dateCreateMinga;

	@PrePersist
	public void prePersist() {
		dateCreateMinga = new Date();
	}

	public Long getCodMinga() {
		return codMinga;
	}

	public void setCodMinga(Long codMinga) {
		this.codMinga = codMinga;
	}

	public Date getDateMinga() {
		return dateMinga;
	}

	public void setDateMinga(Date dateMinga) {
		this.dateMinga = dateMinga;
	}

	public Long getFeeMinga() {
		return feeMinga;
	}

	public void setFeeMinga(Long feeMinga) {
		this.feeMinga = feeMinga;
	}

	public String getDescriptionMinga() {
		return descriptionMinga;
	}

	public void setDescriptionMinga(String descriptionMinga) {
		this.descriptionMinga = descriptionMinga;
	}

	public String getStateMinga() {
		return stateMinga;
	}

	public void setStateMinga(String stateMinga) {
		this.stateMinga = stateMinga;
	}

	public Date getDateCreateMinga() {
		return dateCreateMinga;
	}

	public void setDateCreateMinga(Date dateCreateMinga) {
		this.dateCreateMinga = dateCreateMinga;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
