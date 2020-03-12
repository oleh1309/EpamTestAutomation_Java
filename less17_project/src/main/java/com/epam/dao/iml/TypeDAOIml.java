package com.epam.dao.iml;

import com.epam.dao.TypeDAO;
import com.epam.model.account.type.TypeAccount;
import com.epam.services.ConnectionManager;
import com.epam.services.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeDAOIml implements TypeDAO {
	private static final Logger logger = LogManager.getLogger(TypeDAOIml.class);
	private static final String FIND_ALL_BY_ID = "SELECT * FROM type WHERE IDType=?";
	private static final String FIND_ALL = "SELECT * FROM type";
	@Override
	public List<TypeAccount> findAll() throws SQLException {
		List<TypeAccount> types = new ArrayList<>();
		Connection connection = ConnectionManager.getConnection();
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
				while (resultSet.next()) {
					types.add((TypeAccount)new Transformer(TypeAccount.class).fromResultSetToEntity(resultSet));
				}
			}catch (SQLException e){
				logger.error(e.getStackTrace());
			}
		}
		return types;
	}

	@Override
	public TypeAccount findById(Integer integer) throws SQLException {
		TypeAccount type = null;
		Connection connection = ConnectionManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_BY_ID)) {
			ps.setInt(1,integer);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					type=(TypeAccount)new Transformer(TypeAccount.class).fromResultSetToEntity(resultSet);
					break;
				}
			}catch (SQLException e){
				logger.error(e.getStackTrace());
			}
		}
		return type;
	}

	@Override
	public int create(TypeAccount entity) throws SQLException {
		return 0;
	}

	@Override
	public int update(TypeAccount entity) throws SQLException {
		return 0;
	}

	@Override
	public int delete(Integer integer) throws SQLException {
		return 0;
	}
}
