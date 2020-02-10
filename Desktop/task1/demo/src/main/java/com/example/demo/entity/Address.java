package com.example.demo.entity;

import javax.persistence.*;




@Entity
@Table(name="Address")
public class Address
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int address_id;
	String address;
	String city;
	String state;
	Long zip;
	

	public int getId() {
		return address_id;
	}
	public void setId(int id) {
		this.address_id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getZip() {
		return zip;
	}
	public void setZip(Long zip) {
		this.zip = zip;
	}
	
	
	
}
