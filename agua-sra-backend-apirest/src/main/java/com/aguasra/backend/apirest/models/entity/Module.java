/**
 * 
 */
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
import javax.validation.constraints.Size;

/**
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "modules")
public class Module implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codModule;

	@NotEmpty
	@Size(min = 2, max = 20)
	@Column(nullable = false)
	private String nameModule;

	@NotEmpty
	@Column(nullable = false, length = 1)
	private String stateModule;

	@Temporal(TemporalType.DATE)
	private Date dateCreateModule;

	@PrePersist
	public void prePersist() {
		dateCreateModule = new Date();
	}

	public Long getCodModule() {
		return codModule;
	}

	public void setCodModule(Long codModule) {
		this.codModule = codModule;
	}

	public String getNameModule() {
		return nameModule;
	}

	public void setNameModule(String nameModule) {
		this.nameModule = nameModule;
	}

	public String getStateModule() {
		return stateModule;
	}

	public void setStateModule(String stateModule) {
		this.stateModule = stateModule;
	}

	public Date getDateCreateModule() {
		return dateCreateModule;
	}

	public void setDateCreateModule(Date dateCreateModule) {
		this.dateCreateModule = dateCreateModule;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
