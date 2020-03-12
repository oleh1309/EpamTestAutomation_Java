package com.epam.dao;

import com.epam.model.client.Client;

import java.sql.SQLException;

public interface ClientDAO extends GeneralDAO<Client,Integer> {
	Client findByEmailPassword(String email, String password) throws SQLException;
}
