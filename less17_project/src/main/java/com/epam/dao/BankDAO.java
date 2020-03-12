package com.epam.dao;

import com.epam.model.bank.GeneralBank;

import java.sql.SQLException;
import java.util.List;

public interface BankDAO {

	List<GeneralBank> findAll() throws SQLException;

	GeneralBank findById(int id) throws SQLException;

	int update(GeneralBank entity) throws SQLException;

	int delete(int id) throws SQLException;


}
