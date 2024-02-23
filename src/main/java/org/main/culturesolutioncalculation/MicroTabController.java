package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;

public class MicroTabController extends TabController {

    @Override
    protected String[] getColumnTitles() {
        return new String[]{"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
    }

    @Override
    protected String[] getRowTitles() {
        return new String[]{"설정농도(mM)", "시비농도(mM)", "질산(액상)", "인산(액상)", "중탄산칼륨", "황산망간", "황산구리", "황산아연", "붕산", "붕사",
                "몰리브덴산암모늄", "몰리브덴산나트륨", "킬레이트 철(pH 7까지)", "킬레이트 철(pH 8까지)", "킬레이트 철(pH 전 영역)", "합계"};
    }

    @Override
    public void initialize() {
        super.initialize(); // 상위 클래스의 메서드 호출

        String[] formulas = {"", "", "HNO3", "H3PO4", "KHCO3", "MnSO4·H2O", "CuSO4·5H2O", "ZnSO4·7H2O", "H3BO3", "Na2B4O·7H2O",
                            "(NH4)2Mo7O24·4H2O", "Na2MoO4·2H2O", "Fe-EDTA", "Fe-DTPA", "Fe-EDDHA", ""};

        for (int i = 0; i < rowTitles.length; i++) {
            String[] row = new String[columnTitles.length];
            row[0] = rowTitles[i];
            row[1] = formulas[i];
            tableView.getItems().add(row);
        }
    }
}
