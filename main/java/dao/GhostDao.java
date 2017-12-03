package dao;

import connectionManager.ConnectionManager;
import entity.Ghost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class GhostDao {
    private static final Object LOCK = new Object();
    private static GhostDao INSTANCE = null;

    public static GhostDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new GhostDao();
                }
            }
        }
        return INSTANCE;
    }

    public void save(Ghost ghost) {
        String sql = "INSERT INTO ghost(name, transparency, helth) value (?, ?, ?);";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, ghost.getName());
                preparedStatement.setLong(2, ghost.getTransparency());
                preparedStatement.setLong(3, ghost.getHelth());
                preparedStatement.executeUpdate();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Ghost> findById(Long id) {
        String sql = "SELECT * FROM ghost WHERE id=?;";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Ghost(
                            id,
                            resultSet.getString("name"),
                            resultSet.getLong("transparency"),
                            resultSet.getLong("helth")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
