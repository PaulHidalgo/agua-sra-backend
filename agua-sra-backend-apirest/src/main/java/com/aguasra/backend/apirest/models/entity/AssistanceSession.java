package com.aguasra.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "assistanceSession")
public class AssistanceSession implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codAssistanceSession;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private String assistanceSession;

	@NotEmpty
	@Column(nullable = false, length = 100)
	private String reasonAssistanceSession;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Partner partner;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Session session;

	@Temporal(TemporalType.DATE)
	private Date dateCreateAssistanceSession;

	@PrePersist
	public void prePersist() {
		dateCreateAssistanceSession = new Date();
	}

	public Long getCodAssistanceSession() {
		return codAssistanceSession;
	}

	public void setCodAssistanceSession(Long codAssistanceSession) {
		this.codAssistanceSession = codAssistanceSession;
	}

	public String getAssistanceSession() {
		return assistanceSession;
	}

	public void setAssistanceSession(String assistanceSession) {
		this.assistanceSession = assistanceSession;
	}

	public String getReasonAssistanceSession() {
		return reasonAssistanceSession;
	}

	public void setReasonAssistanceSession(String reasonAssistanceSession) {
		this.reasonAssistanceSession = reasonAssistanceSession;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Date getDateCreateAssistanceSession() {
		return dateCreateAssistanceSession;
	}

	public void setDateCreateAssistanceSession(Date dateCreateAssistanceSession) {
		this.dateCreateAssistanceSession = dateCreateAssistanceSession;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
