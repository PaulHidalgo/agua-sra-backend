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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	public Role() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codRole;

	@NotEmpty
	@Size(min = 2, max = 20)
	@Column(nullable = false)
	private String nameRole;

	@NotEmpty
	@Column(nullable = false, length = 1)
	private String stateRole;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "role_sessions", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "operation_id") })
	private List<Operation> operations;

	@Temporal(TemporalType.DATE)
	private Date dateCreateRole;

	@PrePersist
	public void prePersist() {
		dateCreateRole = new Date();
	}

	public Long getCodRole() {
		return codRole;
	}

	public void setCodRole(Long codRole) {
		this.codRole = codRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public String getStateRole() {
		return stateRole;
	}

	public void setStateRole(String stateRole) {
		this.stateRole = stateRole;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Date getDateCreateRole() {
		return dateCreateRole;
	}

	public void setDateCreateRole(Date dateCreateRole) {
		this.dateCreateRole = dateCreateRole;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}