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
import javax.validation.constraints.NotNull;

/**
 * @author PHidalgo
 *
 */
@Entity
@Table(name = "readersWater")
public class ReaderWater implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReader;

	@NotNull
	private Date dateReader;

	@NotEmpty
	@Column(nullable = false, length = 15)
	private Long consumeReader;

	@NotEmpty
	@Column(nullable = false, length = 15)
	private Long previousReader;

	@NotEmpty
	@Column(nullable = false, length = 15)
	private Long actualReader;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Partner partner;

	@Temporal(TemporalType.DATE)
	private Date dateCreateReader;

	@PrePersist
	public void prePersist() {
		dateCreateReader = new Date();
	}

	public Long getCodReader() {
		return codReader;
	}

	public void setCodReader(Long codReader) {
		this.codReader = codReader;
	}

	public Date getDateReader() {
		return dateReader;
	}

	public void setDateReader(Date dateReader) {
		this.dateReader = dateReader;
	}

	public Long getConsumeReader() {
		return consumeReader;
	}

	public void setConsumeReader(Long consumeReader) {
		this.consumeReader = consumeReader;
	}

	public Long getPreviousReader() {
		return previousReader;
	}

	public void setPreviousReader(Long previousReader) {
		this.previousReader = previousReader;
	}

	public Long getActualReader() {
		return actualReader;
	}

	public void setActualReader(Long actualReader) {
		this.actualReader = actualReader;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Date getDateCreateReader() {
		return dateCreateReader;
	}

	public void setDateCreateReader(Date dateCreateReader) {
		this.dateCreateReader = dateCreateReader;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
