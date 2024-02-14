package org.main.culturesolutioncalculation.DAO;

import org.main.culturesolutioncalculation.DTO.CultureMediumDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*  배양액 org.main.culturesolutioncalculation.DAO */
public class CultureMediumManager {
    private final Connection connection;
    public CultureMediumManager() throws SQLException {
        this.connection = getConnection();
    }
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/culture_fluid_composition";
        String userName = "root";
        String password = "1111";

        return DriverManager.getConnection(url, userName, password);
    }


    public void insertCultureMedium(String name) {
        String sql = "INSERT INTO culture_medium (culture_medium_name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query.", e);
        }
    }

    public List<CultureMediumDTO> getCultureMediumList() {
        String sql =  "SELECT * FROM culture_medium";
        List<CultureMediumDTO> cultureMediumDTOList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Long cultureMediumSeq = resultSet.getLong("culture_medium_seq");
                String cultureMediumName= resultSet.getString("culture_medium_name");

                CultureMediumDTO configurationDTO = new CultureMediumDTO(
                        cultureMediumSeq,cultureMediumName
                );

                cultureMediumDTOList.add(configurationDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cultureMediumDTOList;
    }

    public void deleteCultureMedium(int seq) {
        String sql = "DELETE FROM culture_medium WHERE culture_medium_seq = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, seq);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query.", e);
        }
    }
}