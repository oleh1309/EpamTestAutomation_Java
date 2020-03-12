package com.epam.model.client;

import com.epam.model.annotation.Column;
import java.util.Objects;

public class Client {

	@Column(name = "IDClient", length = 10)
	private int IDClient;
	@Column(name = "Surname", length = 25)
	private String surname;
	@Column(name = "Name", length = 25)
	private String name;
	@Column(name = "City", length = 25)
	private String city;
	@Column(name = "Email", length = 45)
	private String email;
	@Column(name = "Password", length = 25)
	private String password;
	@Column(name = "QuestionToReset", length = 50)
	private String questionToReset;
	@Column(name = "AnswerToReset", length = 25)
	private String answerToReset;
	@Column(name = "IDBank", length = 10)
	private int IDBank;

	public Client() {
	}

	public Client(int IDClient, String surname, String name, String city,
				  String email, String password, String questionToReset, String answerToReset, int IDBank) {
		this.IDClient =  IDClient;
		this.surname = surname;
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
		this.questionToReset = questionToReset;
		this.answerToReset = answerToReset;
		this.IDBank =  IDBank;
	}

	public Client(String surname, String name, String city,
				  String email, String password, String questionToReset, String answerToReset, int IDBank) {
		this.surname = surname;
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
		this.questionToReset = questionToReset;
		this.answerToReset = answerToReset;
		this.IDBank =  IDBank;
	}

	public int getIDBank() {
		return IDBank;
	}

	public void setIDBank(int IDBank) {
		this.IDBank = IDBank;
	}

	public int getIDClient() {
		return IDClient;
	}

	public void setIDClient(int IDClient) {
		this.IDClient = IDClient;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getQuestionToReset() {
		return questionToReset;
	}

	public void setQuestionToReset(String questionToReset) {
		this.questionToReset = questionToReset;
	}

	public String getAnswerToReset() {
		return answerToReset;
	}

	public void setAnswerToReset(String answerToReset) {
		this.answerToReset = answerToReset;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Client)) return false;
		Client client = (Client) o;
		return IDClient == client.IDClient &&
				IDBank == client.IDBank &&
				Objects.equals(surname, client.surname) &&
				Objects.equals(name, client.name) &&
				Objects.equals(city, client.city) &&
				Objects.equals(email, client.email) &&
				Objects.equals(password, client.password) &&
				Objects.equals(questionToReset, client.questionToReset) &&
				Objects.equals(answerToReset, client.answerToReset);
	}

	@Override
	public int hashCode() {
		return Objects.hash(IDClient, surname, name, city, email, password, questionToReset, answerToReset, IDBank);
	}

	@Override
	public String toString() {
		return "Client{" +
				"IDClient=" + IDClient +
				", surname='" + surname + '\'' +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", questionToReset='" + questionToReset + '\'' +
				", answerToReset='" + answerToReset + '\'' +
				", IDBank=" + IDBank +
				'}';
	}
}
