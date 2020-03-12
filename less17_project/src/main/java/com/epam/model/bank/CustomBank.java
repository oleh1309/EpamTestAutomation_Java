package com.epam.model.bank;

import com.epam.model.account.MainAccount;
import com.epam.model.account.factory.CreditMainAccount;
import com.epam.model.account.factory.DebutMainAccount;
import com.epam.model.account.factory.DepositMainAccount;
import com.epam.model.account.type.AccountType;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.client.Client;

public class CustomBank extends GeneralBank {

	public CustomBank() {
	}

	public CustomBank(int id, String name, String city) {
		super(id,name,city);
	}

	@Override
	protected MainAccount chooseAccount(TypeAccount type, int total_count, Client client) {
		MainAccount account = null;
		if (type.getTypeName().equals(AccountType.CREDIT_LIGHT.toString()) ||
				type.getTypeName().equals(AccountType.CREDIT_MEDIUM.toString())) {
			account = new CreditMainAccount(type, total_count,client);
		} else if (type.getTypeName().equals(AccountType.DEBIT_LIGHT.toString()) ||
				type.getTypeName().equals(AccountType.DEBIT_MEDIUM.toString())) {
			account = new DebutMainAccount(type, total_count,client);
		} else if (type.getTypeName().equals(AccountType.DEPOSIT_LIGHT.toString()) ||
				type.getTypeName().equals(AccountType.DEPOSIT_MEDIUM.toString())) {
			account = new DepositMainAccount(type, total_count,client);
		}
		return account;
	}
}
