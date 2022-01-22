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
@Table(name = "readersWater")
public class ReaderWater implements Serializable {
	
	public ReaderWater() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReader;

	@Column
	private Date dateReader;

	@Column(nullable = false, length = 15)
	private Long consumeReader;

	@Column(nullable = false, length = 15)
	private Long previousReader;

	@Column(nullable = false, length = 15)
	private Long actualReader;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
 	private Measurer measurer;

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

	public Date getDateCreateReader() {
		return dateCreateReader;
	}

	public void setDateCreateReader(Date dateCreateReader) {
		this.dateCreateReader = dateCreateReader;
	}

	public Measurer getMeasurer() {
		return measurer;
	}

	public void setMeasurer(Measurer measurer) {
		this.measurer = measurer;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
