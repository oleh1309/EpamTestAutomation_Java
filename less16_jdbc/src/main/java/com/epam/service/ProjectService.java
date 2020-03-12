package com.epam.service;

import com.epam.DAO.implementation.ProjectDaoImpl;
import com.epam.model.ProjectEntity;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    public List<ProjectEntity> findAll() throws SQLException {
        return new ProjectDaoImpl().findAll();
    }

   public ProjectEntity findById(String id) throws SQLException{
       return new ProjectDaoImpl().findById(id);
    }

    public int create(ProjectEntity entity) throws SQLException{
        return new ProjectDaoImpl().create(entity);
    }

    public int update(ProjectEntity entity) throws SQLException{
        return new ProjectDaoImpl().update(entity);
    }

    public int delete(String id) throws SQLException{
        return new ProjectDaoImpl().delete(id);
    }
}
