package org.main.culturesolutioncalculation.service;

import org.example.model.MajorAtom;
import org.example.model.TraceAtom;

import java.util.Arrays;

public class ElementalCompositionCalculator {

    public void calculateMajor(double[] fertilizer, int majorSetting) {
        String[] compoundName = {
                "질산칼슘4수염\t",
                "질산칼슘10수염",
                "질산칼륨\t\t",
                "질산암모늄\t",
                "제1인산암모늄\t",
                "제1인산칼륨\t",
                "황산칼륨 \t",
                "황산마그네슘\t",
                "질산마그네슘\t",
                "질산\t\t",
                "황산\t\t",
                "인산\t\t",
                "염화칼륨\t\t"
        };
        String[] majorSymbol={
                "NO3-N",
                "NH4-N",
                "H2PO4",
                "K\t",
                "Ca\t",
                "Mg\t",
                "SO4-S"
        };
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
        System.out.print("|\t\t\t");
        System.out.print("|\t");
        for(int i=0; i<7;i++){
            System.out.print(majorSymbol[i]+"\t|\t");
        }
        System.out.println();
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
        System.out.print("|시비량\t\t|");
        for (int i = 0; i < 7; i++) {
            System.out.print(fertilizer[i] + "\t\t|");
        }
        System.out.println();
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");



        double[][] compounds = new double[13][7];
        compounds[0] = new double[]{0, 0, 0, 0, 0, 0, 0};   // 질산칼슘 4수염
        compounds[1] = new double[]{0, 0, 0, 0, 0, 0, 0};   // 질산칼슘 10수염
        compounds[2] = new double[]{1, 0, 0, 1, 0, 0, 0};   // 질산칼륨
        compounds[3] = new double[]{1, 1, 0, 0, 0, 0, 0};   // 질산암모늄
        compounds[4] = new double[]{0, 1, 1, 0, 0, 0, 0};   // 제1인산암모늄
        compounds[5] = new double[]{0, 0, 0, 1, 1, 0, 0};   // 제1인산칼륨
        compounds[6] = new double[]{0, 0, 0, 0, 2, 0, 1};   // 황산칼륨
        compounds[7] = new double[]{0, 0, 0, 0, 0, 1, 1};   // 황산마그네슘
        compounds[8] = new double[]{2, 0, 0, 0, 0, 1, 0};   // 질산마그네슘
        compounds[9] = new double[]{1, 0, 0, 0, 0, 0, 0};   // 질산
        compounds[10] = new double[]{0, 0, 0, 0, 0, 0, 1};  // 황산
        compounds[11] = new double[]{0, 0, 1, 0, 0, 0, 0};  // 인사
        compounds[12] = new double[]{0, 0, 0, 1, 0, 0, 0};  // 염화칼륨

        if (majorSetting == 0){
            compounds[0][0] = 2.0;
            compounds[0][4] = 1.0;
        } else if (majorSetting == 1) {
            compounds[1][0] = 2.2;
            compounds[1][1] = 0.2;
            compounds[1][4] = 1.0;
        }

        for(int i=0; i<13; i++) {
            double min = 1000000;
            if(Arrays.stream(fertilizer).sum()==0.0) min = 0.0;
            double[] compound = compounds[i];

            for (int j = 0; j < 7; j++) {
                if (compound[j] != 0 && fertilizer[j] / compound[j] < min) {
                    min = fertilizer[j] / compound[j];
                }
            }
            for (int j = 0; j < 7; j++) {
                min = Math.floor(min * 100) / 100.0;
                compound[j] *= min;
                fertilizer[j] -= compound[j];
            }
        }

        for (int i = 0; i < 13; i++) {
            System.out.print("|"+compoundName[i]+"|");
            for (int j = 0; j < 7; j++) {
                System.out.print(compounds[i][j] + "\t\t|");
            }
            System.out.println();
            System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
        }

        System.out.print("|시비량\t\t|");
        for (int i = 0; i < 7; i++) {
            double sum = 0;
            for(int j=0; j<13; j++){
                sum += compounds[j][i];
            }
            System.out.print(sum+"\t\t|");
        }
        System.out.println();
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
    }
}
