/**
 * 
 */
package com.aguasra.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "operations")
public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codOperation;

	@NotEmpty
	@Size(min = 2, max = 20)
	@Column(nullable = false)
	private String nameOperation;

	@NotEmpty
	@Column(nullable = false, length = 1)
	private String stateOperation;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Module module;

	@ManyToMany(mappedBy = "operations", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Role> roles;

	@Temporal(TemporalType.DATE)
	private Date dateCreateOperation;

	@PrePersist
	public void prePersist() {
		dateCreateOperation = new Date();
	}

	public Long getCodOperation() {
		return codOperation;
	}

	public void setCodOperation(Long codOperation) {
		this.codOperation = codOperation;
	}

	public String getNameOperation() {
		return nameOperation;
	}

	public void setNameOperation(String nameOperation) {
		this.nameOperation = nameOperation;
	}

	public String getStateOperation() {
		return stateOperation;
	}

	public void setStateOperation(String stateOperation) {
		this.stateOperation = stateOperation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Date getDateCreateOperation() {
		return dateCreateOperation;
	}

	public void setDateCreateOperation(Date dateCreateOperation) {
		this.dateCreateOperation = dateCreateOperation;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
