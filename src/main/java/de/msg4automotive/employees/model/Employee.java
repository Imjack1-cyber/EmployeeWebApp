package de.msg4automotive.employees.model;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private int plz; // PLZ als Kleinbuchstaben
	private String city;
	private String streetAddress; // Richtige Schreibweise
	private LocalDate startedWorking;

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, int age, int plz, String city, String streetAddress,
			LocalDate startedWorking) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.plz = plz;
		this.city = city;
		this.streetAddress = streetAddress; // Richtige Schreibweise
		this.startedWorking = startedWorking;
	}

	// Getter und Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) { // Richtige Schreibweise
		this.plz = plz;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetAddress() { // Richtige Schreibweise
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) { // Richtige Schreibweise
		this.streetAddress = streetAddress;
	}

	public LocalDate getStartedWorking() {
		return startedWorking;
	}

	public void setStartedWorking(LocalDate string) {
		this.startedWorking = string;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", plz="
				+ plz + ", city=" + city + ", streetAddress=" + streetAddress + ", startedWorking=" + startedWorking
				+ "]";
	}

}
