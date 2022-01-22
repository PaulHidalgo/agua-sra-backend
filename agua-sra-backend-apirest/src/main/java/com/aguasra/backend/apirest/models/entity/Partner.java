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

/**
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "partners")
public class Partner implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codPartner;

	@Column(nullable = false, length = 60)
	private String namePartner;

	@Column(nullable = false, length = 60)
	private String lastnamePartner;

	@Column(nullable = false, length = 15)
	private String dniPartner;

	@Column(nullable = false, length = 4)
	private Integer numberPartner;

	@Column(nullable = false, length = 2)
	private Integer applePartner;

	@Column(nullable = false, length = 2)
	private Integer lotPartner;

	@Column(nullable = false, length = 10)
	private Integer phone1Partner;

	@Column(nullable = false, length = 10)
	private Integer phone2Partner;

	@Column(nullable = false, length = 1)
	private String statePartner;

	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User user;

	@Temporal(TemporalType.DATE)
	private Date dateCreatePartner;

	@PrePersist
	public void prePersist() {
		dateCreatePartner = new Date();
	}

	public Long getCodPartner() {
		return codPartner;
	}

	public void setCodPartner(Long codPartner) {
		this.codPartner = codPartner;
	}

	public String getNamePartner() {
		return namePartner;
	}

	public void setNamePartner(String namePartner) {
		this.namePartner = namePartner;
	}

	public String getLastnamePartner() {
		return lastnamePartner;
	}

	public void setLastnamePartner(String lastnamePartner) {
		this.lastnamePartner = lastnamePartner;
	}

	public String getDniPartner() {
		return dniPartner;
	}

	public void setDniPartner(String dniPartner) {
		this.dniPartner = dniPartner;
	}

	public Integer getNumberPartner() {
		return numberPartner;
	}

	public void setNumberPartner(Integer numberPartner) {
		this.numberPartner = numberPartner;
	}

	public Integer getApplePartner() {
		return applePartner;
	}

	public void setApplePartner(Integer applePartner) {
		this.applePartner = applePartner;
	}

	public Integer getLotPartner() {
		return lotPartner;
	}

	public void setLotPartner(Integer lotPartner) {
		this.lotPartner = lotPartner;
	}

	public Integer getPhone1Partner() {
		return phone1Partner;
	}

	public void setPhone1Partner(Integer phone1Partner) {
		this.phone1Partner = phone1Partner;
	}

	public Integer getPhone2Partner() {
		return phone2Partner;
	}

	public void setPhone2Partner(Integer phone2Partner) {
		this.phone2Partner = phone2Partner;
	}

	public String getStatePartner() {
		return statePartner;
	}

	public void setStatePartner(String statePartner) {
		this.statePartner = statePartner;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateCreatePartner() {
		return dateCreatePartner;
	}

	public void setDateCreatePartner(Date dateCreatePartner) {
		this.dateCreatePartner = dateCreatePartner;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
