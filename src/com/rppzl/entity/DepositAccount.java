package com.rppzl.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deposit_account")
public class DepositAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "number")
	private String number;

	@Column(name = "sum")
	private Double sum;

	@Column(name = "start_date")
	private LocalDate startDate;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "account_id")
	private PersonalAccount personalAccount;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "deposit_product_id")
	private DepositProduct product;

	public DepositAccount() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public PersonalAccount getPersonalAccount() {
		return personalAccount;
	}

	public void setPersonalAccount(PersonalAccount personalAccount) {
		this.personalAccount = personalAccount;
	}

	public DepositProduct getProduct() {
		return product;
	}

	public void setProduct(DepositProduct product) {
		this.product = product;
	}
}
