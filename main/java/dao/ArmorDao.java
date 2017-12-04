package dao;


import connectionManager.ConnectionManager;
import entity.Ghost;
import entity.gnomeFamily.Armor;
import entity.gnomeFamily.TypeArmor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArmorDao {
    private static final String ARMOR_TABLE_NAME = "armor";

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

    private Armor createArmorFromResultSet(ResultSet resultSet) throws SQLException {
        return new Armor(
                resultSet.getLong(ARMOR_TABLE_NAME + ".id"),
                resultSet.getLong(ARMOR_TABLE_NAME + ".absorb_damage"),
                resultSet.getLong(ARMOR_TABLE_NAME + ".weight"),
                resultSet.getString(ARMOR_TABLE_NAME + ".type_armor"));
    }

    public List<Armor> findAll() {
        List<Armor> armors = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT armor.id,  \n" +
                            "   armor.type_armor,\n" +
                            "   armor.absorb_damage,  \n" +
                            "   armor.weight \n" +
                            "FROM armor  AS  armor;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        armors.add(createArmorFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armors;
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
                    return Optional.of(createArmorFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
