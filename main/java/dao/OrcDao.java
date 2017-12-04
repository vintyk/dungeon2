package dao;

import connectionManager.ConnectionManager;
import entity.Color;
import entity.Orc;
import entity.Witch;
import entity.dto.OrcDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrcDao {
    private static final Object LOCK = new Object();
    private static OrcDao INSTANCE = null;

    public static OrcDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new OrcDao();
                }
            }
        }
        return INSTANCE;
    }

    public void save(Orc orc) {
        String sql = "INSERT INTO orc (name, helth, color, force_orc) values (?, ?, ?, ?);";
        try (Connection connection = ConnectionManager.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                OrcDto orcDto = new OrcDto();
                orcDto.setName(orc.getName());
                orcDto.setHelth(orc.getHelth());
                orcDto.setColor(orc.getColor().getColor());
                orcDto.setForce(orc.getForce());

                preparedStatement.setString(1, orcDto.getName());
                preparedStatement.setLong(2, orcDto.getHelth());
                preparedStatement.setString(3, orcDto.getColor());
                preparedStatement.setLong(4, orcDto.getForce());

                preparedStatement.executeUpdate();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
