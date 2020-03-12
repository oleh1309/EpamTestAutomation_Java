package com.epam.dao.iml;

import com.epam.dao.BankDAO;
import com.epam.model.bank.CustomBank;
import com.epam.model.bank.GeneralBank;
import com.epam.services.ConnectionManager;
import com.epam.services.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankDAOIml implements BankDAO {
	private static final Logger logger = LogManager.getLogger(BankDAOIml.class);
	private static final String FIND_ALL = "SELECT * FROM bank";
	private static final String DELETE = "DELETE FROM bank WHERE IDBank =?";
	private static final String UPDATE = "UPDATE bank SET Name=?, City=? WHERE IDBank=?";
	private static final String FIND_BY_ID = "SELECT * FROM bank WHERE IDBank=?";

	@Override
	public List<GeneralBank> findAll() throws SQLException {
		List<GeneralBank> banks = new ArrayList<>();
		Connection connection = ConnectionManager.getConnection();
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
				while (resultSet.next()) {
					banks.add((CustomBank)new Transformer(CustomBank.class).fromResultSetToEntity(resultSet));
				}
			}catch (SQLException e){
				logger.error(e.getStackTrace());
			}
		}
		return banks;
	}

	@Override
	public GeneralBank findById(int id) throws SQLException {
		GeneralBank entity=null;
		Connection connection = ConnectionManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
			ps.setInt(1,id);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					entity=(CustomBank)new Transformer(CustomBank.class).fromResultSetToEntity(resultSet);
					break;
				}
			}
		}
		return entity;
	}

	@Override
	public int update(GeneralBank entity) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
			ps.setString(1,entity.getCity());
			ps.setString(2,entity.getName());
			ps.setInt(3,entity.getIdBank());
			return ps.executeUpdate();}
	}

	@Override
	public int delete(int id) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
			ps.setInt(1,id);
			return ps.executeUpdate();
		}
	}
}
