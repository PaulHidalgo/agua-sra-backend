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
@Table(name = "payments")
public class Payment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codPayment;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private Long feeConsume;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private Long feeSewerage;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private Long feeCollector;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private Long feeOtherServices;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private Long feeTotalPayment;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private Long feeLimitPayment;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private String notesPayment;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ReaderWater readerWater;

	@Temporal(TemporalType.DATE)
	private Date dateCreatePayment;

	@PrePersist
	public void prePersist() {
		dateCreatePayment = new Date();
	}

	public Long getCodPayment() {
		return codPayment;
	}

	public void setCodPayment(Long codPayment) {
		this.codPayment = codPayment;
	}

	public Long getFeeConsume() {
		return feeConsume;
	}

	public void setFeeConsume(Long feeConsume) {
		this.feeConsume = feeConsume;
	}

	public Long getFeeSewerage() {
		return feeSewerage;
	}

	public void setFeeSewerage(Long feeSewerage) {
		this.feeSewerage = feeSewerage;
	}

	public Long getFeeCollector() {
		return feeCollector;
	}

	public void setFeeCollector(Long feeCollector) {
		this.feeCollector = feeCollector;
	}

	public Long getFeeOtherServices() {
		return feeOtherServices;
	}

	public void setFeeOtherServices(Long feeOtherServices) {
		this.feeOtherServices = feeOtherServices;
	}

	public Long getFeeTotalPayment() {
		return feeTotalPayment;
	}

	public void setFeeTotalPayment(Long feeTotalPayment) {
		this.feeTotalPayment = feeTotalPayment;
	}

	public Long getFeeLimitPayment() {
		return feeLimitPayment;
	}

	public void setFeeLimitPayment(Long feeLimitPayment) {
		this.feeLimitPayment = feeLimitPayment;
	}

	public String getNotesPayment() {
		return notesPayment;
	}

	public void setNotesPayment(String notesPayment) {
		this.notesPayment = notesPayment;
	}

	public ReaderWater getReaderWater() {
		return readerWater;
	}

	public void setReaderWater(ReaderWater readerWater) {
		this.readerWater = readerWater;
	}

	public Date getDateCreatePayment() {
		return dateCreatePayment;
	}

	public void setDateCreatePayment(Date dateCreatePayment) {
		this.dateCreatePayment = dateCreatePayment;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
