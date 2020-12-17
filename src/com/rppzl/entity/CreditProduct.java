package com.rppzl.entity;


import javax.persistence.*;

@Entity
@Table(name = "credit_product")
public class CreditProduct {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "interest_rate")
	private Double interestRate;

	public CreditProduct() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Transient
	public String getCredit() {
		return name + ", Ставка: " + interestRate + "%";
	}

	@Override
	public String toString() {
		return getCredit();
	}
}
