package com.epam.controller.iml;

import com.epam.controller.Controller;
import com.epam.dao.iml.ClientDAOIml;
import com.epam.model.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientControllerIml implements Controller<Client> {
    private static final Logger logger = LogManager.getLogger(ClientControllerIml.class);

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try {
            clients = new ClientDAOIml().findAll();
        } catch (SQLException e) {
            logger.error(e);
        }
        return clients;
    }

    @Override
    public Client getById(int id) {
        Client client = null;
        try {
            client = new ClientDAOIml().findById(id);
        } catch (SQLException e) {
            logger.error(e);
        }
        return client;
    }

    @Override
    public int create(Client entity){
		int res = 0;
		try {
			res = new ClientDAOIml().create(entity);
		} catch (SQLException e) {
			logger.error(e);
		}
		return res;
    }

    @Override
    public int update(Client entity) {
		int res = 0;
		try {
			res = new ClientDAOIml().update(entity);
		} catch (SQLException e) {
			logger.error(e);
		}
		return res;
    }

    @Override
    public int delete(int id) {
		int res = 0;
		try {
			res = new ClientDAOIml().delete(id);
		} catch (SQLException e) {
			logger.error(e);
		}
		return res;
    }

    public Client getByEmailPassword(String email, String password) {
		Client client = null;
		try {
			client = new ClientDAOIml().findByEmailPassword(email, password);
		} catch (SQLException e) {
			logger.error(e);
		}
		return client;
    }
}
