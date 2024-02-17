package org.main.culturesolutioncalculation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TypeData {
    public static ObservableList<String> getCropList(String type) {
        ObservableList<String> cropList = FXCollections.observableArrayList();

        if ("네덜란드 배양액".equals(type)) {
            cropList.addAll("딸기(파)", "딸기(순)", "꽃상추(순)", "가지(암)", "가지(암-순)", "쫑(암)");
        } else if ("야마자키 배양액".equals(type)) {
            cropList.addAll("");
        } else if ("대한민국 배양액".equals(type)) {
            cropList.addAll("");
        }

        return cropList;
    }

    public static ObservableList<String[]> getCompositionData(String type) {
        ObservableList<String[]> compositionData = FXCollections.observableArrayList();

        // 배양액 조성표 데이터 설정
        if ("네덜란드 배양액".equals(type)) {
            compositionData.addAll(
                    new String[]{"비료염", "딸기(파)", "딸기(순)", "꽃상추(순)", "가지(암)", "가지(암-순)", "쫑(암)"},
                    new String[]{"EC(dS • m-1)", "1.7", "1.5", "2.6", "2.1", "1.7", "1.7"},
                    new String[]{"NO3(mmol/L)", "11.5", "10", "19", "15.5", "11.75", "12"},
                    new String[]{"NH4", "1", "0.5", "1.25", "1.5", "1", "1"},
                    new String[]{"H2PO4", "1", "1.25", "2", "1.25", "1", "1.25"},
                    new String[]{"K", "5.5", "5.25", "9", "6.75", "6.5", "5.5"},
                    new String[]{"Ca", "3.25", "2.75", "5", "3.25", "2.25", "3.25"},
                    new String[]{"Mg", "1.25", "1.125", "1.5", "2.5", "1.5", "1.25"},
                    new String[]{"SO4", "1.5", "1.125", "1.125", "1.5", "1.125", "1.125"},
                    new String[]{"Fe(µmol/L)", "20", "20", "40", "15", "15", "10"},
                    new String[]{"Cu", "0.75", "0.75", "0.75", "0.75", "0.75", "0.5"},
                    new String[]{"B", "25", "20", "30", "30", "20", "20"},
                    new String[]{"Mn", "10", "10", "5", "10", "10", "10"},
                    new String[]{"Zn", "7", "4", "4", "5", "5", "4"},
                    new String[]{"Mo", "0.5", "0.5", "0.5", "0.5", "0.5", "0.5"}
            );
        } else if ("야마자키 배양액".equals(type)) {
        } else if ("대한민국 배양액".equals(type)) {
        }

        return compositionData;
    }
}
