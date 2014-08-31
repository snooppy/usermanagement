package ua.cn.dmitrykrivenko.usermanagement.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Dmitry Krivenko <dmitrykrivenko at gmail.com>
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 6827172232412822123L;

	@Id
	@GeneratedValue
	private Integer id;

	private String role;

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
