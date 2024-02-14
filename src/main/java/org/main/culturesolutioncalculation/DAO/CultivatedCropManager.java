package org.main.culturesolutioncalculation.DAO;

import org.main.culturesolutioncalculation.DTO.CultivatedCropDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* 재배작물 org.main.culturesolutioncalculation.DAO */
public class CultivatedCropManager {
    private final Connection connection;

    public CultivatedCropManager() throws SQLException {
        this.connection = getConnection();
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/culture_fluid_composition";
        String userName = "root";
        String password = "1111";

        return DriverManager.getConnection(url, userName, password);
    }

    public void insertCultivated(String name) {
        String sql = "INSERT INTO cultivated_crop (crop_name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query.", e);
        }
    }

    public List<CultivatedCropDTO> getCultivatedCropList() {
        String sql = "SELECT * FROM cultivated_crop";
        List<CultivatedCropDTO> cultivatedCropDTOList = new ArrayList<CultivatedCropDTO>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Long cropSeq = resultSet.getLong("crop_seq");
                String cropName = resultSet.getString("crop_name");

                CultivatedCropDTO cultivatedCropDTO = new CultivatedCropDTO(cropSeq, cropName);

                cultivatedCropDTOList.add(cultivatedCropDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cultivatedCropDTOList;
    }

    public void deleteCultivated(int seq) {
        String sql = "DELETE FROM cultivated_crop WHERE crop_seq = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, seq);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query.", e);
        }
    }
}