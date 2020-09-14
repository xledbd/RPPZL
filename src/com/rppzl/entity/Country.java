package com.rppzl.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private int id;

	@Column(name = "country")
	private String country;

	@Column(name = "citizenship")
	private String citizenship;

	public Country() {

	}

	public Country(String country, String citizenship) {
		this.country = country;
		this.citizenship = citizenship;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	@Override
	public String toString() {
		return country + " (" + citizenship + ")";
	}
}
