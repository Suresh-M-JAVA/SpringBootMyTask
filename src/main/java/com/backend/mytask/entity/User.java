package com.backend.mytask.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id", length = 50) 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	
	@Column(name = "firstname", length = 50)
	private String firstname;
	
	@Column(name = "lastname", length = 50)
	private String lastname;
	
	@Column(name = "gender", length = 50)
	private String gender;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "password", length = 50)
	private String password;
	
	public User(int id, String firstname, String lastname, String gender, String email, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	
	public User() {}
	
	public User(String firstname, String lastname, String gender, String email, String password) {
		// TODO Auto-generated constructor stub
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
