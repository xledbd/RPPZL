package com.rppzl.entity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
						  CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "country_id")
	private Country country;

	public City() {

	}

	public City(String name) {
		this.name = name;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City{" +
				"id=" + id +
				", name='" + name + '\'' +
				", country=" + country +
				'}';
	}
}
