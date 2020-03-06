package com.example.demo.entity;
import javax.persistence.*;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class user
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	String name;
	String email;
	long contact_no;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName="address_id")
	private Address a;
	
	
	public Address getA() {
			return a;
		}
	public void setA(Address a) {
		this.a = a;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	
	
	
	
	
	
}
