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

/**
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "parameters")
public class Parameter implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codParameter;

	@NotEmpty
	@Column(nullable = false, length = 20)
	private String nameParameter;

	@NotEmpty
	@Column(nullable = false, length = 100)
	private String descriptionParameter;

	@NotEmpty
	@Column(nullable = false, length = 50)
	private String valueParameter;

	@NotEmpty
	@Column(nullable = false, length = 50)
	private String typeParameter;

	@NotEmpty
	@Column(nullable = false, length = 1)
	private String stateParameter;

	@Temporal(TemporalType.DATE)
	private Date dateCreateParameter;

	@PrePersist
	public void prePersist() {
		dateCreateParameter = new Date();
	}

	public Long getCodParameter() {
		return codParameter;
	}

	public void setCodParameter(Long codParameter) {
		this.codParameter = codParameter;
	}

	public String getNameParameter() {
		return nameParameter;
	}

	public void setNameParameter(String nameParameter) {
		this.nameParameter = nameParameter;
	}

	public String getDescriptionParameter() {
		return descriptionParameter;
	}

	public void setDescriptionParameter(String descriptionParameter) {
		this.descriptionParameter = descriptionParameter;
	}

	public String getValueParameter() {
		return valueParameter;
	}

	public void setValueParameter(String valueParameter) {
		this.valueParameter = valueParameter;
	}

	public String getTypeParameter() {
		return typeParameter;
	}

	public void setTypeParameter(String typeParameter) {
		this.typeParameter = typeParameter;
	}

	public String getStateParameter() {
		return stateParameter;
	}

	public void setStateParameter(String stateParameter) {
		this.stateParameter = stateParameter;
	}

	public Date getDateCreateParameter() {
		return dateCreateParameter;
	}

	public void setDateCreateParameter(Date dateCreateParameter) {
		this.dateCreateParameter = dateCreateParameter;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
