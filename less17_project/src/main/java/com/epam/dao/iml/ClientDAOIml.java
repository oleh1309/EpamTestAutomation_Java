package com.epam.dao.iml;

import com.epam.dao.ClientDAO;
import com.epam.model.client.Client;
import com.epam.services.ConnectionManager;
import com.epam.services.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOIml implements ClientDAO {
	private static final Logger logger = LogManager.getLogger(ClientDAOIml.class);
    private static final String FIND_ALL = "SELECT * FROM client";
    private static final String DELETE = "DELETE FROM client WHERE IDClient=?";
    private static final String CREATE = "INSERT client (IDClient, Surname, Name, City, Email, Password," +
            " QuestionToReset, AnswerToReset, IDBank) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE client SET Surname=?, Name=?," +
            " City=?, Email=?, Password=?, QuestionToReset=?, AnswerToReset=? WHERE IDClient=?";
    private static final String FIND_BY_ID = "SELECT * FROM client WHERE IDClient=?";
    private static final String FIND_BY_EMAIL_PASSWORD = "SELECT * FROM client WHERE Email=? AND Password =?";

    @Override
    public List<Client> findAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    clients.add((Client) new Transformer(Client.class).fromResultSetToEntity(resultSet));
                }
            } catch (SQLException e) {
                logger.error(e.getStackTrace());
            }
        }
        return clients;
    }

    @Override
    public Client findById(Integer id) throws SQLException {
        Client entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (Client) new Transformer(Client.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(Client entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getIDClient());
            ps.setString(2, entity.getSurname());
            ps.setString(3, entity.getName());
            ps.setString(4, entity.getCity());
            ps.setString(5, entity.getEmail());
            ps.setString(6, entity.getPassword());
            ps.setString(7, entity.getQuestionToReset());
            ps.setString(8, entity.getAnswerToReset());
            ps.setInt(9, entity.getIDBank());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Client entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try ( PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(8, entity.getIDClient());
            ps.setString(1, entity.getSurname());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getCity());
            ps.setString(4, entity.getEmail());
            ps.setString(5, entity.getPassword());
            ps.setString(6, entity.getQuestionToReset());
            ps.setString(7, entity.getAnswerToReset());

            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public Client findByEmailPassword(String email, String password) throws SQLException {
        Client entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_EMAIL_PASSWORD)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (Client) new Transformer(Client.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }
}
