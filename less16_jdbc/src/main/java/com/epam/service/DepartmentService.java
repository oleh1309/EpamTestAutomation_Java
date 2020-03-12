package com.epam.service;

import com.epam.DAO.implementation.DepartmentDaoImpl;
import com.epam.DAO.implementation.EmployeeDaoImpl;
import com.epam.model.DepartmentEntity;
import com.epam.model.EmployeeEntity;
import com.epam.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {

    public List<DepartmentEntity> findAll() throws SQLException {
        return new DepartmentDaoImpl().findAll();
    }

    public DepartmentEntity findById(String id) throws SQLException {
        return new DepartmentDaoImpl().findById(id);
    }

    public int create(DepartmentEntity entity) throws SQLException {
        return new DepartmentDaoImpl().create(entity);
    }

    public int update(DepartmentEntity entity) throws SQLException {
        return new DepartmentDaoImpl().update(entity);
    }

    public int delete(String id) throws SQLException {
        return new DepartmentDaoImpl().delete(id);
    }

    public int deleteWithMoveOfEmployees(String idDeleted, String idMoveTo) throws SQLException {
        int deletedAmount = 0;
        Connection connection = ConnectionManager.getConnection();
        try {
            connection.setAutoCommit(false);
            if (new DepartmentDaoImpl().findById(idMoveTo) == null)
                throw new SQLException();

            List<EmployeeEntity> employees = new EmployeeDaoImpl().findByDeptNo(idDeleted);
            for (EmployeeEntity entity : employees) {
                entity.setDeptNo(idMoveTo);
                new EmployeeDaoImpl().update(entity);
            }
            deletedAmount = new DepartmentDaoImpl().delete(idDeleted);
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            }
        } finally {
            connection.setAutoCommit(true);
        }
        return deletedAmount;
    }


}
