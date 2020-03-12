package com.epam.model.account.factory;

import com.epam.model.account.MainAccount;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

public class DepositMainAccount extends MainAccount {

	private static final Logger logger = LogManager.getLogger(DepositMainAccount.class);
	private double total_deposit_count;

	public DepositMainAccount() {
	}

	public DepositMainAccount(TypeAccount depositType, int total_count, Client client) {
		super(depositType, total_count, client);
			total_deposit_count = total_count + total_count * depositType.getCommission();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MONTH,depositType.getDuration());
			long dateEnd = calendar.getTimeInMillis();
			setDateEnd(dateEnd);
	}


	@Override
	protected void setMoney(double count) {

	}

	@Override
	protected void getMoney(double count) {
		if (getDateEnd().before(new Date())) {
			setTotal_count(getTotal_count() - count);
		} else {
			logger.error("Your deposit account is in process!!!");
		}
	}

	@Override
	public String toString() {
		return "DepositMainAccountIml{" +
				"total_deposit_count=" + total_deposit_count + " ," + super.toString() +
				'}';
	}
}
