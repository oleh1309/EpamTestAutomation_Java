package com.epam.model.account.type;

import com.epam.model.annotation.Column;

public class TypeAccount {
	@Column(name = "IDType")
	private int IDType;
	@Column(name = "TypeName", length = 45)
	private String TypeName;
	@Column(name = "Commission")
	private double Commission;
	@Column(name = "Duration")
	private int duration;


	public TypeAccount() {
	}

	public TypeAccount(int IDType, AccountType typeName, double commission, int duration) {
		this.IDType = IDType;
		this.TypeName = typeName.toString();
		this.Commission = commission;
		this.duration = duration;
	}

	public int getIDType() {
		return IDType;
	}

	public String getTypeName() {
		return TypeName;
	}

	public double getCommission() {
		return Commission;
	}

	public int getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "TypeAccount{" +
				"IDType='" + IDType + '\'' +
				", TypeName='" + TypeName + '\'' +
				", Comision=" + Commission +
				'}';
	}
}
