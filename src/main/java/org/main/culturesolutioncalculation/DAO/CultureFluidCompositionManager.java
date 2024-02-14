package org.main.culturesolutioncalculation.DAO;

import org.main.culturesolutioncalculation.DTO.CultureFluidCompositionDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* 배양액 테이블 org.main.culturesolutioncalculation.DAO*/
public class CultureFluidCompositionManager {
    private final Connection connection;

    public CultureFluidCompositionManager() throws SQLException {
        this.connection = getConnection();
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/culture_fluid_composition";
        String userName = "root";
        String password = "1111";

        return DriverManager.getConnection(url, userName, password);
    }
    public void insertCultureFluidComposition(CultureFluidCompositionDTO cultureFluidCompositionDTO) {
        String sql = "INSERT INTO tb_culture_fluid_composition (culture_medium_seq, crop_seq, EC, NO3, NH4, H2PO4, K, Ca, Mg, SO4, Fe, Cu, B, Mn, Zn, Mo)"+
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, cultureFluidCompositionDTO.getCultureMediumSeq());
            statement.setLong(2, cultureFluidCompositionDTO.getCropSeq());
            statement.setDouble(3, cultureFluidCompositionDTO.getEC());
            statement.setDouble(4, cultureFluidCompositionDTO.getNO3());
            statement.setDouble(5, cultureFluidCompositionDTO.getNH4());
            statement.setDouble(6, cultureFluidCompositionDTO.getH2PO4());
            statement.setDouble(7, cultureFluidCompositionDTO.getK());
            statement.setDouble(8, cultureFluidCompositionDTO.getCa());
            statement.setDouble(9, cultureFluidCompositionDTO.getMg());
            statement.setDouble(10, cultureFluidCompositionDTO.getSO4());
            statement.setDouble(11, cultureFluidCompositionDTO.getFe());
            statement.setDouble(12, cultureFluidCompositionDTO.getCu());
            statement.setDouble(13, cultureFluidCompositionDTO.getB());
            statement.setDouble(14, cultureFluidCompositionDTO.getMn());
            statement.setDouble(15, cultureFluidCompositionDTO.getZn());
            statement.setDouble(16, cultureFluidCompositionDTO.getMo());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CultureFluidCompositionDTO> getCultureFluidCompositionList(int cultureMediumSeq) throws SQLException {
        String sql = "SELECT *" +
                "FROM tb_culture_fluid_composition t JOIN cultivated_crop c ON t.crop_seq = c.crop_seq WHERE t.culture_medium_seq = ?";
        List<CultureFluidCompositionDTO> cultureFluidCompositionDTOList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
             statement.setLong(1,cultureMediumSeq);

             ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int cropSeq= resultSet.getInt("crop_seq");
                String cropName = resultSet.getString("crop_name");
                Double EC = resultSet.getDouble("EC");
                Double NO3 =resultSet.getDouble("NO3");
                Double NH4 = resultSet.getDouble("NH4");
                Double H2PO4 = resultSet.getDouble("H2PO4");
                Double K = resultSet.getDouble("K");
                Double Ca = resultSet.getDouble("Ca");
                Double Mg = resultSet.getDouble("Mg");
                Double SO4 = resultSet.getDouble("SO4");
                Double Fe = resultSet.getDouble("Fe");
                Double Cu = resultSet.getDouble("Cu");
                Double B = resultSet.getDouble("B");
                Double Mn = resultSet.getDouble("Mn");
                Double Zn = resultSet.getDouble("Zn");
                Double Mo = resultSet.getDouble("Mo");

                CultureFluidCompositionDTO cultureFluidCompositionDTO = new CultureFluidCompositionDTO(cultureMediumSeq,cropSeq,cropName,EC,NO3,NH4,H2PO4,K,Ca,Mg,SO4,Fe,Cu,B,Mn,Zn,Mo);
                cultureFluidCompositionDTOList.add(cultureFluidCompositionDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  cultureFluidCompositionDTOList;
    }

    public void setCultureFluidComposition(CultureFluidCompositionDTO cultureFluidCompositionDTO) {
        String sql = "UPDATE tb_culture_fluid_composition SET EC = ?, NO3 = ?, NH4 = ?, H2PO4 = ?,"+
                "K = ?, Ca = ?, Mg = ?, SO4 = ?, Fe = ?, Cu = ?, B = ?, Mn = ?, Zn = ?, Mo = ? "+
                "WHERE culture_medium_seq = ? AND crop_seq = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setDouble(1,cultureFluidCompositionDTO.getEC());
            statement.setDouble(2,cultureFluidCompositionDTO.getNO3());
            statement.setDouble(3,cultureFluidCompositionDTO.getNH4());
            statement.setDouble(4,cultureFluidCompositionDTO.getH2PO4());
            statement.setDouble(5,cultureFluidCompositionDTO.getK());
            statement.setDouble(6,cultureFluidCompositionDTO.getCa());
            statement.setDouble(7,cultureFluidCompositionDTO.getMg());
            statement.setDouble(8,cultureFluidCompositionDTO.getSO4());
            statement.setDouble(9,cultureFluidCompositionDTO.getFe());
            statement.setDouble(10,cultureFluidCompositionDTO.getCu());
            statement.setDouble(11,cultureFluidCompositionDTO.getB());
            statement.setDouble(12,cultureFluidCompositionDTO.getMn());
            statement.setDouble(13,cultureFluidCompositionDTO.getZn());
            statement.setDouble(14,cultureFluidCompositionDTO.getMo());
            statement.setLong(15,cultureFluidCompositionDTO.getCultureMediumSeq());
            statement.setLong(16,cultureFluidCompositionDTO.getCropSeq());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCultureFluidComposition(int cultureMediumSeq, int cropSeq) {
        String sql = "DELETE FROM tb_culture_fluid_composition WHERE culture_medium_seq = ? AND crop_seq = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cultureMediumSeq);
            statement.setInt(2, cropSeq);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query.", e);
        }
    }
}
