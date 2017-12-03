package dao;

import connectionManager.ConnectionManager;
import entity.Witch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WithDao {

    private static final Object LOCK = new Object();
    private static WithDao INSTANCE = null;

    public static WithDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new WithDao();
                }
            }
        }
        return INSTANCE;
    }

    public void save(Witch witch) {
        String sql = "INSERT INTO witch (name, manna, helth) values (?, ?, ?);";
        try (Connection connection = ConnectionManager.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, witch.getName());
                preparedStatement.setLong(2, witch.getManna());
                preparedStatement.setLong(3, witch.getHelth());
                preparedStatement.executeUpdate();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
