package com.epam.DAO.implementation;

import com.epam.DAO.EmployeeDAO;
import com.epam.model.EmployeeEntity;
import com.epam.persistant.ConnectionManager;
import com.epam.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    private static final String FIND_ALL = "SELECT * FROM employee";
    private static final String DELETE = "DELETE FROM employee WHERE emp_no=?";
    private static final String CREATE = "INSERT employee (emp_no, emp_fname, emp_lname, dept_no) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE employee SET emp_fname=?, emp_lname=?, dept_no=? WHERE emp_no=?";
    private static final String FIND_BY_ID = "SELECT * FROM employee WHERE emp_no=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM employee WHERE emp_fname=?";
    private static final String FIND_BY_DEPT_NO = "SELECT * FROM employee WHERE dept_no=?";

    @Override
    public List<EmployeeEntity> findAll() throws SQLException {
        List<EmployeeEntity> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    employees.add((EmployeeEntity) new Transformer(EmployeeEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return employees;
    }

    @Override
    public EmployeeEntity findById(Integer id) throws SQLException {
        EmployeeEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(EmployeeEntity)new Transformer(EmployeeEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(EmployeeEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getEmpNo());
            ps.setString(2,entity.getEmpFirstName());
            ps.setString(3,entity.getEpmLastName());
            ps.setString(4,entity.getDeptNo());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(EmployeeEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,entity.getEmpFirstName());
            ps.setString(2,entity.getEpmLastName());
            ps.setString(3,entity.getDeptNo());
            ps.setInt(4,entity.getEmpNo());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
    }

    @Override
    public List<EmployeeEntity> findByName(String name) throws SQLException {
        List<EmployeeEntity> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_FIRST_NAME)) {
            ps.setString(1,name);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    employees.add((EmployeeEntity) new Transformer(EmployeeEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return employees;
    }

    @Override
    public List<EmployeeEntity> findByDeptNo(String deptNo) throws SQLException {
        List<EmployeeEntity> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_DEPT_NO)) {
            ps.setString(1,deptNo);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    employees.add((EmployeeEntity) new Transformer(EmployeeEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return employees;
    }
}
