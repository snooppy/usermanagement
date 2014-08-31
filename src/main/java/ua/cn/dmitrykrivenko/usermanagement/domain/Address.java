package ua.cn.dmitrykrivenko.usermanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Dmitry Krivenko <dmitrykrivenko at gmail.com>
 */
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = -6406924789463732593L;

	@Id
	@GeneratedValue
	private long id;

	private String street;
	private int number;
	@Column(name = "zip_code")
	private String zipcode;
	private String city;

	public Address() {
	}

	public Address(String street, int number, String zipcode, String city) {
		this.street = street;
		this.number = number;
		this.zipcode = zipcode;
		this.city = city;
	}

	public long getId() {
		return this.id;
	}

	public void setAddressId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
