package ua.cn.dmitrykrivenko.usermanagement.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Dmitry Krivenko <dmitrykrivenko at gmail.com>
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -1170771042556610140L;

	@Id
	@GeneratedValue
	private Integer id;

	private String firstname;
	private String lastname;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	private String email;
	private String password;
	@Column(name = "repeat_password")
	private String repeatpassword;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private User manager;

	public User() {
	}

	public User(String firstname, String lastname, Address address, String email, String password, String repeatpassword, Role role, User manager) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;

		this.email = email;
		this.password = password;
		this.repeatpassword = repeatpassword;

		this.role = role;
		this.manager = manager;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatpassword() {
		return repeatpassword;
	}

	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

}
