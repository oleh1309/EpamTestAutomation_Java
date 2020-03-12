package com.epam.dao.iml;

import com.epam.dao.AccountDAO;
import com.epam.model.account.MainAccount;
import com.epam.model.bank.CustomBank;
import com.epam.model.bank.GeneralBank;
import com.epam.model.transaction.Transaction;
import com.epam.services.ConnectionManager;
import com.epam.services.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOIml implements AccountDAO {
	private static final Logger logger = LogManager.getLogger(AccountDAOIml.class);
	private static final String FIND_ALL = "SELECT * FROM account";
	private static final String FIND_ALL_BY_ID = "SELECT * FROM account WHERE IDClient=?";
	private static final String CREATE = "INSERT account (IDAccount, IDClient, IDType, Amount, DateStart, DateEnd) " +
			"VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE account SET Amount=? WHERE IDAccount=? AND IDClient=?";
	private static final String FIND_BY_ID = "SELECT * FROM account WHERE IDAccount=?";

	@Override
	public List<MainAccount> findAllByID(Integer id) throws SQLException {
		List<MainAccount> accounts = new ArrayList<>();
		Connection connection = ConnectionManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_BY_ID)) {
			ps.setInt(1, id);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					accounts.add((MainAccount) new Transformer(MainAccount.class).fromResultSetToEntity(resultSet));
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		return accounts;
	}

	@Override
	public List<MainAccount> findAll() throws SQLException {
		List<MainAccount> accounts = new ArrayList<>();
		Connection connection = ConnectionManager.getConnection();
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
				while (resultSet.next()) {
					accounts.add((MainAccount)new Transformer(MainAccount.class).fromResultSetToEntity(resultSet));
				}
			}catch (SQLException e){
				logger.error(e.getStackTrace());
			}
		}
		return accounts;
	}

	@Override
	public int create(MainAccount entity) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
			ps.setInt(1, entity.getIDAccount());
			ps.setInt(2, entity.getIDClient());
			ps.setInt(3, entity.getIDType());
			ps.setDouble(4, entity.getBalance());
			ps.setDate(5, entity.getDateStart());
			ps.setDate(6, entity.getDateEnd());
			return ps.executeUpdate();
		}
	}

	public MainAccount findByID(int id) {
		MainAccount account = null;
		Connection connection = ConnectionManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
			ps.setInt(1, id);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					account = (MainAccount) new Transformer(MainAccount.class).fromResultSetToEntity(resultSet);
				}
			}
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
		return account;
	}

	public Transaction sendMoney(MainAccount from_account, MainAccount to_account, double money) {
		Transaction transaction = null;
		Connection conn = ConnectionManager.getConnection();
		try (PreparedStatement get = conn.prepareStatement(UPDATE);
				PreparedStatement set = conn.prepareStatement(UPDATE)) {
			conn.setAutoCommit(false);

			get.setDouble(1, from_account.getBalance() - money);
			get.setInt(2, from_account.getIDAccount());
			get.setInt(3, from_account.getIDClient());
			get.executeUpdate();

			set.setDouble(1, to_account.getBalance() + money);
			set.setInt(2, to_account.getIDAccount());
			set.setInt(3, to_account.getIDClient());
			set.executeUpdate();

			conn.setAutoCommit(true);

			transaction = new Transaction(from_account.getIDClient(), from_account.getIDAccount(),
					to_account.getIDClient(), to_account.getIDAccount(), money, true);
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}

		return transaction;
	}
}
