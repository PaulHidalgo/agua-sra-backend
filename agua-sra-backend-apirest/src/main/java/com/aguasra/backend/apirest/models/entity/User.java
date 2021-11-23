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
 * 
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "usuario")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codUser;

	@NotEmpty
	@Column(unique = true, length = 20)
	private String nameUser;

	@NotEmpty
	@Column(nullable = false, length = 60)
	private String passwordUser;

	@NotEmpty
	@Column(nullable = false, length = 1)
	private String stateUser;

	@Temporal(TemporalType.DATE)
	private Date dateCreateUser;

	@PrePersist
	public void prePersist() {
		dateCreateUser = new Date();
	}

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Role role;

	public Long getCodUser() {
		return codUser;
	}

	public void setCodUser(Long codUser) {
		this.codUser = codUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getStateUser() {
		return stateUser;
	}

	public void setStateUser(String stateUser) {
		this.stateUser = stateUser;
	}

	public Date getDateCreateUser() {
		return dateCreateUser;
	}

	public void setDateCreateUser(Date dateCreateUser) {
		this.dateCreateUser = dateCreateUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
