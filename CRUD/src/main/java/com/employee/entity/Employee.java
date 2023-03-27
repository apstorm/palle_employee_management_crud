package com.employee.entity;

public class Employee {
	private int id;
	private String name;
	private String dob;
	private String address;
	private String email;
	private String password;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
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

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String dob, String address, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public Employee(String name, String dob, String address, String email, String password) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", email=" + email
				+ ", password=" + password + "]";
	}

}
