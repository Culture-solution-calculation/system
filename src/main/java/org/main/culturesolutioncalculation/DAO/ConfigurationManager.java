package org.main.culturesolutioncalculation.DAO;

import org.main.culturesolutioncalculation.DTO.ConfigurationDTO;

import java.sql.*;

/* 설정 테이블 org.main.culturesolutioncalculation.DAO*/
public class ConfigurationManager {
    private final Connection connection;
    public ConfigurationManager() throws SQLException {
        this.connection = getConnection();
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/culture_fluid_composition";
        String userName = "root";
        String password = "1111";

        return DriverManager.getConnection(url, userName, password);
    }

    /*설정 정보 삽입*/
    public void insertConfiguration(ConfigurationDTO configurationDTO){
        String sql = "INSERT INTO configuration (con_seq, multi_unit_seq, trace_unit_seq, cn_fertilizer_seq, " +
                "fe_fertilizer_seq, b_fertilizer_seq, mn_fertilizer_seq, mo_fertilizer_seq, input_unit_seq, elemental_yn) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, configurationDTO.getConSeq());
            statement.setLong(2, configurationDTO.getMultiUnitSeq());
            statement.setLong(3, configurationDTO.getTraceUnitSeq());
            statement.setLong(4, configurationDTO.getCnFertilizerSeq());
            statement.setLong(5, configurationDTO.getFeFertilizerSeq());
            statement.setLong(6, configurationDTO.getBFertilizerSeq());
            statement.setLong(7, configurationDTO.getMnFertilizerSeq());
            statement.setLong(8, configurationDTO.getMoFertilizerSeq());
            statement.setLong(9, configurationDTO.getInputUnitSeq());
            statement.setString(10, configurationDTO.getElementalYn());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*설정 정보 조회*/
    public ConfigurationDTO getConfiguration() throws SQLException {
        String sql = "SELECT * FROM configuration where con_seq = 0";
        try (Statement retrieveStatement = connection.createStatement();
             ResultSet resultSet = retrieveStatement.executeQuery(sql)) {

            resultSet.next();
            int multiUnitSeq = resultSet.getInt("multi_unit_seq");
            int traceUnitSeq = resultSet.getInt("trace_unit_seq");
            int cnFertilizerSeq = resultSet.getInt("cn_fertilizer_seq");
            int feFertilizerSeq = resultSet.getInt("fe_fertilizer_seq");
            int bFertilizerSeq = resultSet.getInt("b_fertilizer_seq");
            int mnFertilizerSeq = resultSet.getInt("mn_fertilizer_seq");
            int moFertilizerSeq = resultSet.getInt("mo_fertilizer_seq");
            int inputUnitSeq = resultSet.getInt("input_unit_seq");
            String elementalYn = resultSet.getString("elemental_yn");

            // ConfigurationDTO 객체 생성
            return new ConfigurationDTO(
                    multiUnitSeq, traceUnitSeq, cnFertilizerSeq, feFertilizerSeq,
                    bFertilizerSeq, mnFertilizerSeq, moFertilizerSeq, inputUnitSeq, elementalYn
            );
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*설정 정보 수정*/
    public void setConfiguration(ConfigurationDTO configurationDTO) {

        String updateSql = "UPDATE configuration SET " +
                "multi_unit_seq = ?, " +
                "trace_unit_seq = ?, " +
                "cn_fertilizer_seq = ?, " +
                "fe_fertilizer_seq = ?, " +
                "b_fertilizer_seq = ?, " +
                "mn_fertilizer_seq = ?, " +
                "mo_fertilizer_seq = ?, " +
                "input_unit_seq = ?, " +
                "elemental_yn = ? " +
                "WHERE con_seq = 0";

        try (PreparedStatement statement = connection.prepareStatement(updateSql)) {
            statement.setLong(1, configurationDTO.getMultiUnitSeq());
            statement.setLong(2, configurationDTO.getTraceUnitSeq());
            statement.setLong(3, configurationDTO.getCnFertilizerSeq());
            statement.setLong(4, configurationDTO.getFeFertilizerSeq());
            statement.setLong(5, configurationDTO.getBFertilizerSeq());
            statement.setLong(6, configurationDTO.getMnFertilizerSeq());
            statement.setLong(7, configurationDTO.getMoFertilizerSeq());
            statement.setLong(8, configurationDTO.getInputUnitSeq());
            statement.setString(9, configurationDTO.getElementalYn());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
