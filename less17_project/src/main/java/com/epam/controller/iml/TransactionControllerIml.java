package com.epam.controller.iml;

import com.epam.controller.Controller;
import com.epam.dao.iml.TransactionDAOIml;
import com.epam.model.transaction.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionControllerIml implements Controller<Transaction> {
	private static final Logger logger = LogManager.getLogger(TransactionControllerIml.class);
	@Override
	public List<Transaction> getAll() {
		List<Transaction> transactions = new ArrayList<>();
		try {
			transactions = new TransactionDAOIml().findAll();
		} catch (SQLException e) {
			logger.error(e);
		}
		return transactions;
	}

	@Override
	public Transaction getById(int id) {
		Transaction transaction = null;
		try {
			transaction = new TransactionDAOIml().findById(id);
		} catch (SQLException e) {
			logger.error(e);
		}
		return transaction;
	}

	@Override
	public int create(Transaction entity) {
		int res = 0;
		try {
			res = new TransactionDAOIml().create(entity);
		} catch (SQLException e) {
			logger.error(e);
		}
		return res;
	}

	@Override
	public int update(Transaction entity) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	public List<Transaction> findByIdclient(int id) {
		List<Transaction> transactions = new ArrayList<>();
		try {
			transactions = new TransactionDAOIml().findByIdclient(id);
		} catch (SQLException e) {
			logger.error(e);
		}
		return transactions;
	}
}
