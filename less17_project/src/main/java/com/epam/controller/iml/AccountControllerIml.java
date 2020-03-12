package com.epam.controller.iml;

import com.epam.controller.Controller;
import com.epam.dao.iml.AccountDAOIml;
import com.epam.dao.iml.TypeDAOIml;
import com.epam.model.account.MainAccount;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.transaction.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountControllerIml implements Controller<MainAccount> {
	private static final Logger logger = LogManager.getLogger(AccountControllerIml.class);
    @Override
    public List<MainAccount> getAll() {
        List<MainAccount> mainAccounts = new ArrayList<>();
        try {
            mainAccounts = new AccountDAOIml().findAll();
        } catch (SQLException e) {
            logger.error(e);
        }
        return mainAccounts;
    }

    @Override
    public MainAccount getById(int id) {
        return new AccountDAOIml().findByID(id);
    }

    @Override
    public int create(MainAccount entity) {
        int res = 0;
        try {
            res = new AccountDAOIml().create(entity);
        } catch (SQLException e) {
			logger.error(e);
        }
        return res;
    }

    @Override
    public int update(MainAccount entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    public List<MainAccount> findAllByID(int id) {
        List<MainAccount> mainAccounts = new ArrayList<>();
        try {
            mainAccounts = new AccountDAOIml().findAllByID(id);
        } catch (SQLException e) {
			logger.error(e);
        }
        return mainAccounts;
    }

    public TypeAccount findByID(int id) {
        TypeAccount typeAccount = null;
        try {
            typeAccount = new TypeDAOIml().findById(id);
        } catch (SQLException e) {
			logger.error(e);
        }
        return typeAccount;
    }

    public List<TypeAccount> find() {
        List<TypeAccount> mainAccounts = new ArrayList<>();
        try {
            mainAccounts = new TypeDAOIml().findAll();
        } catch (SQLException e) {
			logger.error(e);
        }
        return mainAccounts;
    }

    public Transaction sendMoney(MainAccount from_account, MainAccount to_account, double money) {
        return new AccountDAOIml().sendMoney(from_account, to_account, money);
    }
}
