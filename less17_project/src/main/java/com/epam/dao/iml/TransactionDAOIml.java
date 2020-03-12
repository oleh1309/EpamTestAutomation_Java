package com.epam.dao.iml;

import com.epam.dao.TransactionDAO;
import com.epam.model.transaction.Transaction;
import com.epam.services.ConnectionManager;
import com.epam.services.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOIml implements TransactionDAO {
	private static final Logger logger = LogManager.getLogger(TransactionDAOIml.class);
	private static final String FIND_ALL = "SELECT * FROM transaction";
	private static final String CREATE = "INSERT transaction (IDTransaction, IDClient_from, IDAccount_from," +
			" IDClient_to, IDAccount_to, Amount, IsSuccess) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String FIND_BY_ID = "SELECT * FROM transaction WHERE IDTransaction=?";
	private static final String FIND_BY_ID_CLIENT = "SELECT * FROM transaction WHERE IDClient_from=? OR IDClient_to=?";

	@Override
	public List<Transaction> findAll() throws SQLException {
		List<Transaction> transactions = new ArrayList<>();
		Connection connection = ConnectionManager.getConnection();
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
				while (resultSet.next()) {
					transactions.add((Transaction)new Transformer(Transaction.class).fromResultSetToEntity(resultSet));
				}
			}catch (SQLException e){
				logger.error(e.getStackTrace());
			}
		}
		return transactions;
	}

	@Override
	public Transaction findById(Integer id) throws SQLException {
		Transaction transaction = null;
		Connection connection = ConnectionManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
			ps.setInt(1,id);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					transaction = (Transaction)new Transformer(Transaction.class).fromResultSetToEntity(resultSet);
				}
			}catch (SQLException e){
				logger.error(e.getStackTrace());
			}
		}
		return transaction;
	}

	@Override
	public List<Transaction> findByIdclient(int id) throws SQLException {
		List<Transaction> transactions = new ArrayList<>();
		Connection connection = ConnectionManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_CLIENT)) {
			ps.setInt(1,id);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					transactions.add((Transaction)new Transformer(Transaction.class).fromResultSetToEntity(resultSet));
				}
			}catch (SQLException e){
				logger.error(e.getStackTrace());
			}
		}
		return transactions;
	}

	@Override
	public int create(Transaction entity) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
			ps.setInt(1, entity.getIDTransaction());
			ps.setInt(2, entity.getIDClient_from());
			ps.setInt(3, entity.getIDAccount_from());
			ps.setInt(4,entity.getIDClient_to());
			ps.setInt(5,  entity.getIDAccount_to());
			ps.setDouble(6, entity.getAmount());
			ps.setBoolean(7, entity.isSuccess());
			return ps.executeUpdate();}
	}

	@Override
	public int update(Transaction entity){
		return 0;
	}

	@Override
	public int delete(Integer integer){
		return 0;
	}
}
