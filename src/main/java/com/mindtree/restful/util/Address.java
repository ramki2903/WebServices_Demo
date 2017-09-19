package com.mindtree.restful.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "address")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = { "doorNo", "street", "location", "city" })
public class Address {

	
	/*@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(strategy = "foreign", name = "foreigngen", parameters = @Parameter(name = "property", value = "employee") )*/
	@Id
	@Column(name = "address_id")
	@GeneratedValue
	private long Id;
	
	@Column(name = "doorNo")
	private Integer doorNo;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "city")
	private String city;
	
	/*@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee employee;*/

	
	public long getId() {
		return Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}

	
	public Integer getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(Integer doorNo) {
		this.doorNo = doorNo;
	}

	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	/*public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/
	
	public Address() {

	}

	public Address(long Id,Integer doorNo, String street, String location, String city) {
		
		super();
		this.Id= Id;
		this.doorNo = doorNo;
		this.street = street;
		this.location = location;
		this.city = city;

	}

}
