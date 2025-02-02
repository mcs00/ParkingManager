package com.parking.dto;

import java.io.Serializable;

public class Client implements Serializable{   
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
  

    public Client() {
    }

	public Client(int id) {
		this.id = id;
	}

	public Client(int id, String name, String surname, String email, String phone) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		
	}

	public Client(String name, String surname, String email, String phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone
				+ "]";
	}


	


}
