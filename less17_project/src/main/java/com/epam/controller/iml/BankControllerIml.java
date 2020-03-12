package com.epam.controller.iml;

import com.epam.controller.Controller;
import com.epam.dao.iml.BankDAOIml;
import com.epam.model.bank.GeneralBank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankControllerIml implements Controller<GeneralBank> {
    private static final Logger logger = LogManager.getLogger(BankControllerIml.class);

    @Override
    public List<GeneralBank> getAll() {
        List<GeneralBank> generalBanks = new ArrayList<>();
        try {
            generalBanks = new BankDAOIml().findAll();
        } catch (SQLException e) {
            logger.error(e);
        }
        return generalBanks;
    }

    @Override
    public GeneralBank getById(int id) {
        GeneralBank generalBank = null;
        try {
            generalBank = new BankDAOIml().findById(id);
        } catch (SQLException e) {
            logger.error(e);
        }
        return generalBank;
    }

    @Override
    public int create(GeneralBank entity) {
        return 0;
    }

    @Override
    public int update(GeneralBank entity) {
        int res = 0;
        try {
            res = new BankDAOIml().update(entity);
        } catch (SQLException e) {
            logger.error(e);
        }
        return res;
    }

    @Override
    public int delete(int id) {
        int res = 0;
        try {
            res = new BankDAOIml().delete(id);
        } catch (SQLException e) {
            logger.error(e);
        }
        return res;
    }
}
