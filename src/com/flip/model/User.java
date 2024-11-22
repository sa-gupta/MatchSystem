package com.flip.model;

public class User {

	private String name;
	private Gender gender;
	private Integer age;
	private String city;
	
	public User(String name, Gender gender, Integer age, String city) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.city = city;
	}

	public User() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + ", city=" + city + "]";
	}
}
