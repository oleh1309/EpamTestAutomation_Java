package com.epam.model.transaction;

import com.epam.model.annotation.Column;

public class Transaction {
	@Column(name = "IDTransaction")
	private int IDTransaction;
	@Column(name = "IDClient_from")
	private int IDClient_from;
	@Column(name = "IDAccount_from")
	private int IDAccount_from;
	@Column(name = "IDClient_to")
	private int IDClient_to;
	@Column(name = "IDAccount_to")
	private int IDAccount_to;
	@Column(name = "Amount")
	private double amount;
	@Column(name = "IsSuccess")
	private boolean isSuccess;

	public Transaction() {
	}

	public Transaction(int IDClient_from, int IDAccount_from,
					   int IDClient_to, int IDAccount_to, double amount, boolean isSuccess) {
		this.IDClient_from = IDClient_from;
		this.IDAccount_from = IDAccount_from;
		this.IDClient_to = IDClient_to;
		this.IDAccount_to = IDAccount_to;
		this.amount = amount;
		this.isSuccess = isSuccess;
	}

	public int getIDTransaction() {
		return IDTransaction;
	}

	public void setIDTransaction(int IDTransaction) {
		this.IDTransaction = IDTransaction;
	}

	public int getIDClient_from() {
		return IDClient_from;
	}

	public void setIDClient_from(int IDClient_from) {
		this.IDClient_from = IDClient_from;
	}

	public int getIDAccount_from() {
		return IDAccount_from;
	}

	public void setIDAccount_from(int IDAccount_from) {
		this.IDAccount_from = IDAccount_from;
	}

	public int getIDClient_to() {
		return IDClient_to;
	}

	public void setIDClient_to(int IDClient_to) {
		this.IDClient_to = IDClient_to;
	}

	public int getIDAccount_to() {
		return IDAccount_to;
	}

	public void setIDAccount_to(int IDAccount_to) {
		this.IDAccount_to = IDAccount_to;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean success) {
		isSuccess = success;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"IDTransaction=" + IDTransaction +
				", IDClient_from=" + IDClient_from +
				", IDAccount_from=" + IDAccount_from +
				", IDClient_to=" + IDClient_to +
				", IDAccount_to=" + IDAccount_to +
				", amount=" + amount +
				", isSuccess=" + isSuccess +
				'}';
	}
}
