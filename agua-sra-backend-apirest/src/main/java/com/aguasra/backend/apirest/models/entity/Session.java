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

/**
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "sessions")
public class Session implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codSession;
	
	@Column
	private Date dateSession;
	
	@Column(nullable = false, length = 20)
	private String typeSession;
	
	@Column(nullable = false, length = 15)
	private Long feeSession;
	
	@Column(nullable = false, length = 500)
	private String descriptionSession;
	
	@Column(nullable = false, length = 1)
	private String stateSession;

	@Temporal(TemporalType.DATE)
	private Date dateCreateSession;
	
	@PrePersist
	public void prePersist() {
		dateCreateSession = new Date();
	}

	public Long getCodSession() {
		return codSession;
	}

	public void setCodSession(Long codSession) {
		this.codSession = codSession;
	}

	public Date getDateSession() {
		return dateSession;
	}

	public void setDateSession(Date dateSession) {
		this.dateSession = dateSession;
	}

	public String getTypeSession() {
		return typeSession;
	}

	public void setTypeSession(String typeSession) {
		this.typeSession = typeSession;
	}

	public Long getFeeSession() {
		return feeSession;
	}

	public void setFeeSession(Long feeSession) {
		this.feeSession = feeSession;
	}

	public String getDescriptionSession() {
		return descriptionSession;
	}

	public void setDescriptionSession(String descriptionSession) {
		this.descriptionSession = descriptionSession;
	}

	public String getStateSession() {
		return stateSession;
	}

	public void setStateSession(String stateSession) {
		this.stateSession = stateSession;
	}

	public Date getDateCreateSession() {
		return dateCreateSession;
	}

	public void setDateCreateSession(Date dateCreateSession) {
		this.dateCreateSession = dateCreateSession;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
