package dao;

import connectionManager.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class UtilitesDao {

    public static Long getIdFromGhost(String tableNameForMaxNumId){
        Long idFromGhost = 0L;
        String sql = "select max(id) as result from " + tableNameForMaxNumId + ";";
        try(Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    idFromGhost = resultSet.getLong("result");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return idFromGhost;
    }

    public static void deleteFromTableById(String tableName, Long id){
        String sqlDelete = "DELETE FROM "+ tableName +" where id = " + id + "; ";
        try (Connection connection = ConnectionManager.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)){
                preparedStatement.executeUpdate();

                connection.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
