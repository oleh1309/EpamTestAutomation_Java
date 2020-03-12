package com.epam.model.account.factory;

import com.epam.model.account.MainAccount;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

public class CreditMainAccount extends MainAccount {
	private static final Logger logger = LogManager.getLogger(CreditMainAccount.class);
	private double count_repayment;
	private double total_credit_count;

	public CreditMainAccount() {
	}

	public CreditMainAccount(TypeAccount creditType, int total_count, Client client) {
		super(creditType, total_count,client);
			total_credit_count = total_count + total_count * creditType.getCommission();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR,creditType.getDuration());
			long dateEnd = calendar.getTimeInMillis();
			setDateEnd(dateEnd);
	}

	@Override
	protected void setMoney(double count) {
		count_repayment += count;
	}

	@Override
	protected void getMoney(double count) {
		if (getBalance() > count) {
			setTotal_count(getTotal_count() - count);
		} else if (getBalance() == 0) {
			logger.error("You have used all the credit money!!!");
		} else {
			logger.error("There isn`t enough money in your credit account!");
		}
	}

	@Override
	public String toString() {
		return "CreditAccountIml{" +
				", count_repayment=" + count_repayment +
				", total_credit_count=" + total_credit_count + " ," + super.toString() +
				'}';
	}
}
