package com.epam.service;

import com.epam.DAO.implementation.WorksOnDaoImpl;
import com.epam.model.PK_WorksOn;
import com.epam.model.WorksOnEntity;

import java.sql.SQLException;
import java.util.List;

public class WorkOnService {
    public List<WorksOnEntity> findAll() throws SQLException {
        return new WorksOnDaoImpl().findAll();
    }

//   public List<WorksOnEntity> findById(ID id) throws SQLException{
//
//    };

    public int create(WorksOnEntity entity) throws SQLException{
        return new WorksOnDaoImpl().create(entity);
    }

    public int update(WorksOnEntity entity) throws SQLException{
        return new WorksOnDaoImpl().update(entity);
    }

    public int delete(PK_WorksOn pk) throws SQLException{
        return new WorksOnDaoImpl().delete(pk);
    }
}
