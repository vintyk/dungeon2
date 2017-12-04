package dao;

import connectionManager.ConnectionManager;
import entity.gnomeFamily.Gnome;

import java.sql.*;

public class GnomeDao {
    private static final Object LOCK = new Object();
    private static GnomeDao INSTANCE = null;

    public static GnomeDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new GnomeDao();
                }
            }
        }
        return INSTANCE;
    }

    public Long save(Gnome gnome) {
        Long savedGnomeId = null;
        String sql = "INSERT INTO gnome (gender, armor_id, name, helth) VALUE (?, ?, ?, ?);";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, gnome.getGender().getGender());
                preparedStatement.setLong(2, gnome.getArmor().getId());
                preparedStatement.setString(3, gnome.getName());
                preparedStatement.setLong(4, gnome.getHelth());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    savedGnomeId = generatedKeys.getLong(1);
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedGnomeId;
    }
}
