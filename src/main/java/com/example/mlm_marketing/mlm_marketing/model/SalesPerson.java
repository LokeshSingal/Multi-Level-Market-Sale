package com.example.mlm_marketing.mlm_marketing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="salesperson")
public class SalesPerson {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private SalesPerson referencedFrom;
	
	@Column(name="name")
	private String name;
	
	@Column(name="parent_share")
	private Integer refrencedShare;
	
	@Column(name="id_path")
	private String referencePath;
	
	@Column(name="balance")
	private Double balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SalesPerson getReferencedFrom() {
		return referencedFrom;
	}

	public void setReferencedFrom(SalesPerson referencedFrom) {
		this.referencedFrom = referencedFrom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRefrencedShare() {
		return refrencedShare;
	}

	public void setRefrencedShare(Integer refrencedShare) {
		this.refrencedShare = refrencedShare;
	}

	public String getReferencePath() {
		return referencePath;
	}

	public void setReferencePath(String referencePath) {
		this.referencePath = referencePath;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
}
