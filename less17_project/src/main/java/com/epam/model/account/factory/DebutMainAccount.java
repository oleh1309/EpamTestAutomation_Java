package com.epam.model.account.factory;

import com.epam.model.account.MainAccount;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DebutMainAccount extends MainAccount {
    private static final Logger logger = LogManager.getLogger(DebutMainAccount.class);

    public DebutMainAccount() {
    }

    public DebutMainAccount(TypeAccount debitType, int total_count, Client client) {
        super(debitType, total_count,client);
            long dateEnd = TimeUnit.DAYS.toMillis(debitType.getDuration()*365);
            setDateEnd(dateEnd);
    }

    @Override
    public void setMoney(double count) {
        setTotal_count(getTotal_count() + count);
    }

    @Override
    public void getMoney(double count) {
        if (getBalance() > count) {
            setTotal_count(getTotal_count() - count);
        } else {
            logger.error("There isn`t enough money in your account!");
        }
    }

    @Override
    public String toString() {
        return "DebutAccountIml{" + super.toString() +
                '}';
    }
}
