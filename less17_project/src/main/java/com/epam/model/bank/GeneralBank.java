package com.epam.model.bank;

import com.epam.model.annotation.Column;
import com.epam.model.account.MainAccount;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.client.Client;

public abstract class GeneralBank {
	@Column(name = "IDBank", length = 10)
	private int idBank;
	@Column(name = "Name", length = 25)
	private String name;
	@Column(name = "City", length = 25)
	private String city;

	public GeneralBank() {
	}

	public GeneralBank(int idBank,String name, String city) {
		this.idBank = idBank;
		this.name = name;
		this.city = city;
	}

	protected abstract MainAccount chooseAccount(TypeAccount type, int total_count, Client client);

	public MainAccount create(TypeAccount type, int total_count, Client client) {
		MainAccount account = chooseAccount(type, total_count,client);
		return account;
	}

	public int getIdBank() {
		return idBank;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "GeneralBank{" +
				"idBank=" + idBank +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
