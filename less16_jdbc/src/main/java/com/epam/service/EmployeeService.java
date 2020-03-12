package com.epam.service;

import com.epam.DAO.implementation.EmployeeDaoImpl;
import com.epam.model.EmployeeEntity;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    public List<EmployeeEntity> findAll() throws SQLException {
        return new EmployeeDaoImpl().findAll();
    }

    public EmployeeEntity findById(Integer id) throws SQLException {
        return new EmployeeDaoImpl().findById(id);
    }

    public int create(EmployeeEntity entity) throws SQLException {
        return new EmployeeDaoImpl().create(entity);
    }

    public int update(EmployeeEntity entity) throws SQLException {
        return new EmployeeDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new EmployeeDaoImpl().delete(id);
    }

    public List<EmployeeEntity> findByName(String name) throws SQLException {
        return new EmployeeDaoImpl().findByName(name);
    }
}
