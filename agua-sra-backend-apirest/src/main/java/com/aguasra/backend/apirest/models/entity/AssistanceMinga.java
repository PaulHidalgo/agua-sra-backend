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
@Table(name = "assistanceMingas")
public class AssistanceMinga implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codAssistanceMinga;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private String assistanceMinga;

	@NotEmpty
	@Column(nullable = false, length = 100)
	private String reasonAssistanceMinga;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Partner partner;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Minga minga;

	@Temporal(TemporalType.DATE)
	private Date dateCreateAssistanceMinga;

	@PrePersist
	public void prePersist() {
		dateCreateAssistanceMinga = new Date();
	}

	public Long getCodAssistanceMinga() {
		return codAssistanceMinga;
	}

	public void setCodAssistanceMinga(Long codAssistanceMinga) {
		this.codAssistanceMinga = codAssistanceMinga;
	}

	public String getAssistanceMinga() {
		return assistanceMinga;
	}

	public void setAssistanceMinga(String assistanceMinga) {
		this.assistanceMinga = assistanceMinga;
	}

	public String getReasonAssistanceMinga() {
		return reasonAssistanceMinga;
	}

	public void setReasonAssistanceMinga(String reasonAssistanceMinga) {
		this.reasonAssistanceMinga = reasonAssistanceMinga;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Minga getMinga() {
		return minga;
	}

	public void setMinga(Minga minga) {
		this.minga = minga;
	}

	public Date getDateCreateAssistanceMinga() {
		return dateCreateAssistanceMinga;
	}

	public void setDateCreateAssistanceMinga(Date dateCreateAssistanceMinga) {
		this.dateCreateAssistanceMinga = dateCreateAssistanceMinga;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
