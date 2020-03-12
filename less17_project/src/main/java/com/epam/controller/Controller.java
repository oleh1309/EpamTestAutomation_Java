package com.epam.controller;

import java.sql.SQLException;
import java.util.List;

public interface Controller<T> {

	List<T> getAll() throws SQLException;
	T getById(int id) throws SQLException;
	int create(T entity) throws SQLException;
	int update(T entity) throws SQLException;
	int delete(int id) throws SQLException;
}
