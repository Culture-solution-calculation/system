package org.main.culturesolutioncalculation;

import javafx.scene.control.TableView;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {

    // 데이터베이스 연결 정보
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fx_test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pearl2044";

    private static final String SELECT_QUERY = "SELECT 설정_다량원소_단위, 설정_미량원소_단위, 질산칼숨_비료, 철_비료, 붕소_비료, 망간_비료, 몰리브뎀_비료, 원수_고려_유무, 원수_입력_단위 FROM setting ORDER BY id DESC LIMIT 1";


    public static Map<String, String> getSettings() {
        Map<String, String> settings = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(columnName);
                    if (columnValue != null && !columnValue.isEmpty()) {
                        settings.put(columnName, columnValue);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Settings: " + settings);

        return settings;
    }

    public static List<String> getPrintData() {
        List<String> printData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM setting")) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(columnName);
                    // 가져온 데이터를 리스트에 추가합니다.
                    printData.add(columnValue);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return printData;
    }

    // SQL 쿼리문
    // insert 말고 덮어쓰기
    private static final String INSERT_QUERY = "INSERT INTO setting (%s) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static void insertSettings(Map<String, Integer> selectedValues) {
        try (
                // 데이터베이스 연결
                Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(String.format(INSERT_QUERY, String.join(", ", selectedValues.keySet())))
        ) {
            int index = 1;
            for (Integer value : selectedValues.values()) {
                if (value != null) {
                    statement.setInt(index++, value);
                } else {
                    statement.setNull(index++, Types.VARCHAR); // 라디오버튼 선택하지 않은 경우 null 값 설정
                }
            }

            // 쿼리 실행
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("설정이 성공적으로 저장되었습니다.");
            } else {
                System.out.println("설정 저장에 실패했습니다.");
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 또는 쿼리 실행 중 오류 발생: " + e.getMessage());
        }
    }

    public static void insertMacroSum(String[] sumRow) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO sum (`NO3-N`, `NH4-N`, `P`, `K`, `Ca`, `Mg`, `SO4-S`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            for (int i = 0; i < sumRow.length; i++) {
                statement.setString(i + 1, sumRow[i]); // PreparedStatement 인덱스는 1부터 시작
            }

            statement.executeUpdate();
            System.out.println("데이터베이스에 합계 행을 저장했습니다.");

        } catch (SQLException e) {
            System.err.println("데이터베이스 오류: " + e.getMessage());
        }
    }
}

//        -- setting
//        CREATE TABLE IF NOT EXISTS setting (
//        설정_다량원소_단위 VARCHAR(255) DEFAULT NULL,
//        설정_미량원소_단위 VARCHAR(255) DEFAULT NULL,
//        질산칼숨_비료 VARCHAR(255) DEFAULT NULL,
//        철_비료 VARCHAR(255) DEFAULT NULL,
//        붕소_비료 VARCHAR(255) DEFAULT NULL,
//        망간_비료 VARCHAR(255) DEFAULT NULL,
//        몰리브뎀_비료 VARCHAR(255) DEFAULT NULL,
//        원수_고려_유무 VARCHAR(255) DEFAULT NULL,
//        원수_입력_단위 VARCHAR(255) DEFAULT NULL
//        );

//        -- sum
//        CREATE TABLE IF NOT EXISTS `sum` (
//        `NO3-N` DECIMAL(10, 2) DEFAULT NULL,
//        `NH4-N` DECIMAL(10, 2) DEFAULT NULL,
//        `P` DECIMAL(10, 2) DEFAULT NULL,
//        `K` DECIMAL(10, 2) DEFAULT NULL,
//        `Ca` DECIMAL(10, 2) DEFAULT NULL,
//        `Mg` DECIMAL(10, 2) DEFAULT NULL,
//        `SO4-S` DECIMAL(10, 2) DEFAULT NULL
//        );
