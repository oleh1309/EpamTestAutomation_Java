package com.epam.dao;

import com.epam.model.account.MainAccount;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO{

	List<MainAccount> findAllByID(Integer id) throws SQLException;
	List<MainAccount> findAll() throws SQLException;
	int create(MainAccount entity) throws SQLException;
}
