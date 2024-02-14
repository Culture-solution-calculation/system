package org.main.culturesolutioncalculation.DAO;

import org.main.culturesolutioncalculation.DTO.AtomsConcentrationDTO;
import org.main.culturesolutioncalculation.DTO.ConfigurationConcentrateDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtomsConcentrationManager {
    private final Connection connection;
    public AtomsConcentrationManager() throws SQLException {
        this.connection = getConnection();
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/culture_fluid_composition";
        String userName = "root";
        String password = "1111";
        return DriverManager.getConnection(url, userName, password);
    }
    public void insertAtomsConcentration(AtomsConcentrationDTO atomsConcentrationDTO) {
        String sql = "INSERT INTO atoms_concentration ("+
                "set_atom_seq, atom_seq, atom_name, molecular_formula, fertilizer_concentration, unit_seq, unit,"+
                "NO3_N, NH4_N, P, K, Ca, Mg, SO4_S)"+
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,atomsConcentrationDTO.getSet_atom_seq());
            statement.setInt(2,atomsConcentrationDTO.getAtom_seq());
            statement.setString(3,atomsConcentrationDTO.getAtom_name());
            statement.setString(4,atomsConcentrationDTO.getMolecular_formula());
            statement.setDouble(5,atomsConcentrationDTO.getFertilizer_concentration());
            statement.setInt(6,atomsConcentrationDTO.getUnit_seq());
            statement.setString(7,atomsConcentrationDTO.getUnit());
            statement.setDouble(8,atomsConcentrationDTO.getNO3_N());
            statement.setDouble(9,atomsConcentrationDTO.getNH4_N());
            statement.setDouble(10,atomsConcentrationDTO.getP());
            statement.setDouble(11,atomsConcentrationDTO.getK());
            statement.setDouble(12,atomsConcentrationDTO.getCa());
            statement.setDouble(13,atomsConcentrationDTO.getMg());
            statement.setDouble(14,atomsConcentrationDTO.getSO4_S());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AtomsConcentrationDTO getAtomsConcentration(int setAtomSeq, int atomSeq) {
        String sql = "SELECT * FROM atoms_concentration WHERE set_atom_seq = ? AND atom_seq = ?";
        AtomsConcentrationDTO atomsConcentrationDTO;
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,setAtomSeq);
            statement.setInt(2,atomSeq);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    atomsConcentrationDTO = new AtomsConcentrationDTO(
                            resultSet.getInt("set_atom_seq"),
                            resultSet.getInt("atom_seq"),
                            resultSet.getString("atom_name"),
                            resultSet.getString("molecular_formula"),
                            resultSet.getDouble("fertilizer_concentration"),
                            resultSet.getInt("unit_seq"),
                            resultSet.getString("unit"),
                            resultSet.getDouble("NO3_N"),
                            resultSet.getDouble("NH4_N"),
                            resultSet.getDouble("P"),
                            resultSet.getDouble("K"),
                            resultSet.getDouble("Ca"),
                            resultSet.getDouble("Mg"),
                            resultSet.getDouble("SO4_S")
                    );
                } else {
                    // Handle case where no matching row is found
                    atomsConcentrationDTO = null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return atomsConcentrationDTO;
    }

    public void deleteAtomsConcentration(int setAtomSeq, int atomSeq) {
        String sql = "DELETE FROM atoms_concentration WHERE set_atom_seq = ? AND atom_seq = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,setAtomSeq);
            statement.setInt(2,atomSeq);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AtomsConcentrationDTO> getAtomsConcentrationList(int setAtomSeq) {
        String sql = "SELECT * FROM atoms_concentration WHERE set_atom_seq = ?";
        List<AtomsConcentrationDTO> atomsConcentrationDTOList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,setAtomSeq);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    atomsConcentrationDTOList.add(new AtomsConcentrationDTO(
                            resultSet.getInt("set_atom_seq"),
                            resultSet.getInt("atom_seq"),
                            resultSet.getString("atom_name"),
                            resultSet.getString("molecular_formula"),
                            resultSet.getDouble("fertilizer_concentration"),
                            resultSet.getInt("unit_seq"),
                            resultSet.getString("unit"),
                            resultSet.getDouble("NO3_N"),
                            resultSet.getDouble("NH4_N"),
                            resultSet.getDouble("P"),
                            resultSet.getDouble("K"),
                            resultSet.getDouble("Ca"),
                            resultSet.getDouble("Mg"),
                            resultSet.getDouble("SO4_S")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return atomsConcentrationDTOList;
    }

    public void setAtomsConcentration(AtomsConcentrationDTO atomsConcentrationDTO) {
        String sql = "UPDATE atoms_concentration SET atom_name = ?," +
                "molecular_formula = ?, fertilizer_concentration = ?, unit_seq = ?, unit = ?," +
                "NO3_N = ?, NH4_N = ?, P = ?, K = ?, Ca = ?, Mg = ?, SO4_S = ?" +
                "WHERE set_atom_seq = ? AND atom_seq = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,atomsConcentrationDTO.getAtom_name());
            statement.setString(2,atomsConcentrationDTO.getMolecular_formula());
            statement.setDouble(3,atomsConcentrationDTO.getFertilizer_concentration());
            statement.setInt(4,atomsConcentrationDTO.getUnit_seq());
            statement.setString(5,atomsConcentrationDTO.getUnit());
            statement.setDouble(6,atomsConcentrationDTO.getNO3_N());
            statement.setDouble(7,atomsConcentrationDTO.getNH4_N());
            statement.setDouble(8,atomsConcentrationDTO.getP());
            statement.setDouble(9,atomsConcentrationDTO.getK());
            statement.setDouble(10,atomsConcentrationDTO.getCa());
            statement.setDouble(11,atomsConcentrationDTO.getMg());
            statement.setDouble(12,atomsConcentrationDTO.getSO4_S());
            statement.setInt(13,atomsConcentrationDTO.getSet_atom_seq());
            statement.setInt(14,atomsConcentrationDTO.getAtom_seq());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAtomsConcentrationList(List<AtomsConcentrationDTO> atomsConcentrationDTOList) {
        atomsConcentrationDTOList.forEach(this::setAtomsConcentration);
    }

    public void insertConfigurationConcentration(ConfigurationConcentrateDTO configurationConcentrateDTO) {
        String sql = "INSERT INTO con_concentration ("+
                "set_atom_seq, NO3_N, NH4_N, P, K, Ca, Mg, SO4_S)"+
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,configurationConcentrateDTO.getSetAtomSeq());
            statement.setDouble(2,configurationConcentrateDTO.getNO3_N());
            statement.setDouble(3,configurationConcentrateDTO.getNH4_N());
            statement.setDouble(4,configurationConcentrateDTO.getP());
            statement.setDouble(5,configurationConcentrateDTO.getK());
            statement.setDouble(6,configurationConcentrateDTO.getCa());
            statement.setDouble(7,configurationConcentrateDTO.getMg());
            statement.setDouble(8,configurationConcentrateDTO.getSO4_S());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ConfigurationConcentrateDTO getConfigurationConcentration(int setAtomSeq) {
        String sql = "SELECT * FROM con_concentration WHERE set_atom_seq = ?";
        ConfigurationConcentrateDTO configurationConcentrateDTO = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,setAtomSeq);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    configurationConcentrateDTO = new ConfigurationConcentrateDTO(
                            resultSet.getInt("set_atom_seq"),
                            resultSet.getDouble("NO3_N"),
                            resultSet.getDouble("NH4_N"),
                            resultSet.getDouble("P"),
                            resultSet.getDouble("K"),
                            resultSet.getDouble("Ca"),
                            resultSet.getDouble("Mg"),
                            resultSet.getDouble("SO4_S")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return configurationConcentrateDTO;
    }

    public void setConfigurationConcentration(ConfigurationConcentrateDTO configurationConcentrateDTO) {
        String sql = "UPDATE con_concentration SET NO3_N = ?, NH4_N = ?, P = ?, K = ?, Ca = ?, Mg = ?, SO4_S = ?" +
                "WHERE set_atom_seq = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setDouble(1,configurationConcentrateDTO.getNO3_N());
            statement.setDouble(2,configurationConcentrateDTO.getNH4_N());
            statement.setDouble(3,configurationConcentrateDTO.getP());
            statement.setDouble(4,configurationConcentrateDTO.getK());
            statement.setDouble(5,configurationConcentrateDTO.getCa());
            statement.setDouble(6,configurationConcentrateDTO.getMg());
            statement.setDouble(7,configurationConcentrateDTO.getSO4_S());
            statement.setInt(8,configurationConcentrateDTO.getSetAtomSeq());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteConfigurationConcentration(int setAtomSeq) {
        String sql = "DELETE FROM con_concentration WHERE set_atom_seq = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,setAtomSeq);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
