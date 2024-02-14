package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;


public class MacroTabController extends TabController {

    @Override
    protected String[] getColumnTitles() {
        return new String[]{"100 배액 기준", "분자식", "시비량", "단위", "NO3-N", "NH4-N", "P", "K", "Ca", "Mg", "SO4-S"};
    }

    @Override
    protected String[] getRowTitles() {
        return new String[]{"설정농도(mM)", "시비농도(mM)", "질산칼슘", "질산칼륨", "제1인산암모늄", "제1인산칼륨", "황산칼륨", "황산마그네슘", "질산마그네슘", "질산암모늄",
                "질산", "황산", "연산", "수산화칼륨", "초안", "유안", "염안", "황산칼리", "염화칼리", "염화칼슘", "합계"};
    }

    @Override
    public void initialize() {
        super.initialize(); // 상위 클래스의 메서드 호출

        String[] formulas = {"", "", "Ca(NO3)2-4H2O", "KNO3", "NH4H2PO4", "KH2PO4", "K2SO4", "MgSO4-7H2O", "Mg(NO3)2-6H2O",
                "NH4NO3", "HNO3", "H2SO4", "H3PO4", "KOH", "NH4NO3", "(NH4)2SO4", "NH4Cl", "K2SO4", "KCL",
                "CaCl2·2H2O", ""};

        for (int i = 0; i < rowTitles.length; i++) {
            String[] row = new String[columnTitles.length];
            row[0] = rowTitles[i];
            row[1] = formulas[i];
            tableView.getItems().add(row);
        }
    }

    @FXML
    protected void saveData() {
        // 데이터 저장
        // DatabaseManager.insertMacroSum(data);
    }
}

