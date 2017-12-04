package dao;


import connectionManager.ConnectionManager;
import entity.Ghost;
import entity.gnomeFamily.Armor;
import entity.gnomeFamily.TypeArmor;

import java.sql.*;
import java.util.Optional;

public class ArmorDao {
    private static final Object LOCK = new Object();
    private static ArmorDao INSTANCE = null;
    public static ArmorDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ArmorDao();
                }
            }
        }
        return INSTANCE;
    }

    public Long save(Armor armor) {
        Long savedArmorId = null;
        String sql = "INSERT INTO armor (type_armor, absorb_damage, weight) value (?, ?, ?);";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, armor.getTypeArmor().getTypeArmor());
                preparedStatement.setLong(2, armor.getAbsorbDamage());
                preparedStatement.setLong(3, armor.getWeight());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()){
                    savedArmorId = generatedKeys.getLong(1);
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return savedArmorId;
    }
    public Optional<Armor> findById(Long id) {
        String sql = "SELECT * FROM armor WHERE id=?;";
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Armor(
                            id,
                            resultSet.getLong("absorb_damage"),
                            resultSet.getLong("weight"),
                            resultSet.getString("type_armor")
                            ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
