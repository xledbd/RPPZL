package com.rppzl.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private int id;

	@NotNull
	@Pattern(regexp = "^[A-Za-zа-яА-я]{1,45}$")
	@Column(name = "lastname")
	private String lastName;

	@NotNull
	@Pattern(regexp = "^[A-Za-zа-яА-я]{1,45}$")
	@Column(name = "name")
	private String firstName;

	@NotNull
	@Pattern(regexp = "^[A-Za-zа-яА-я]{1,45}$")
	@Column(name = "middle_name")
	private String middleName;

	@NotNull
	@Column(name = "date")
	private LocalDate dateOfBirth;

	@NotNull
	@Pattern(regexp = "^[ABHKMPSD][BMHPC]$")
	@Column(name = "passport_series")
	private String passportSeries;

	@NotNull
	@Pattern(regexp = "^[0-9]{7}$")
	@Column(name = "passport_number")
	private String passportNumber;

	@NotNull
	@Pattern(regexp = "^[А-ЯA-Z ]{1,45}$")
	@Column(name = "authority")
	private String authority;

	@NotNull
	@Column(name = "date_of_issue")
	private LocalDate dateOfIssue;

	@NotNull
	@Pattern(regexp = "^[0-9]{7}[A-Z][0-9]{4}PB[1-7]$")
	@Column(name = "identification_number")
	private String identificationNumber;

	@NotNull
	@Pattern(regexp = "^[A-Za-zа-яА-я]{1,45}$")
	@Column(name = "place_of_birth")
	private String placeOfBirth;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "city_of_residence_id")
	private City cityOfResidence;

	@NotNull
	@Pattern(regexp = "^[A-Za-zа-яА-я0-9 /.-]{1,45}$")
	@Column(name = "adress_of_residence")
	private String address;

	@Pattern(regexp = "^([0-9]{3}-[0-9]{2}-[0-9]{2})?$")
	@Column(name = "lendline_phone")
	private String landlinePhone;

	@Pattern(regexp = "^(\\+[0-9]{11,12})?$")
	@Column(name = "mobile_phone")
	private String mobilePhone;

	@Email
	@Column(name = "Email")
	private String email;

	@Pattern(regexp = "^([A-Za-zа-яА-я0-9 /.-]{1,45})?$")
	@Column(name = "place_of_work")
	private String placeOfWork;

	@Pattern(regexp = "^([A-Za-zа-яА-я /.-]{1,45})?$")
	@Column(name = "position")
	private String position;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "city_of_registration_id")
	private City cityOfRegistration;

	@NotNull
	@Column(name = "family_status")
	private String familyStatus;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "citizenship_id")
	private Country citizenship;

	@NotNull
	@Column(name = "disability")
	private String disability;

	@Column(name = "retiree")
	private boolean retired;

	@DecimalMin(value = "0.0")
	@Column(name = "monthly_income")
	private BigDecimal monthlyIncome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassportSeries() {
		return passportSeries;
	}

	public void setPassportSeries(String passportSeries) {
		this.passportSeries = passportSeries;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public City getCityOfResidence() {
		return cityOfResidence;
	}

	public void setCityOfResidence(City cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandlinePhone() {
		return landlinePhone;
	}

	public void setLandlinePhone(String landlinePhone) {
		this.landlinePhone = landlinePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlaceOfWork() {
		return placeOfWork;
	}

	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public City getCityOfRegistration() {
		return cityOfRegistration;
	}

	public void setCityOfRegistration(City cityOfRegistration) {
		this.cityOfRegistration = cityOfRegistration;
	}

	public String getFamilyStatus() {
		return familyStatus;
	}

	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}

	public Country getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Country citizenship) {
		this.citizenship = citizenship;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public BigDecimal getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(BigDecimal monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
}
