package com.epam.dao;

import com.epam.model.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO extends GeneralDAO<Transaction, Integer> {

    List<Transaction> findByIdclient(int id) throws SQLException;

}
