package org.main.culturesolutioncalculation.service;

import javafx.util.Pair;
import org.main.culturesolutioncalculation.model.MajorAtom;
import org.main.culturesolutioncalculation.model.TraceAtom;


public class ElementalCompositionCalculator {

    public void calculateMajorRatio(MajorAtom[] majorAtoms, int majorSetting) {

    }

    public void calculateTraceRatio(TraceAtom[] traceAtoms) {
    }

    public double[][]  autoCalculateMajor(double[] fertilizer, int majorSetting) {

        double[][] compounds = getMajorCompoundRatio(majorSetting);

        for(int i=0; i<13; i++) {
            setTraceCompoundValue(fertilizer, compounds[i]);
        }

        return compounds;
    }

    public double[][] manualCalculateMajor(double[][] oldCompounds, double[][] newCompound, double[] fertilizer, int majorSetting) {
        // 변경된 화합물 원소 농도 좌표 찾기
        int[] changePosition = findChangeableCompounds(oldCompounds, newCompound);
        if (changePosition[0] == -1) return oldCompounds;
        int y = changePosition[0];
        int x = changePosition[1];
        double[][] compounds = getMajorCompoundRatio(majorSetting);

        // 변경된 화합물 원소의 우선순위를 0순위로 두고 먼저 계산
        double min = newCompound[y][x] / compounds[y][x];

        for (int i = 0; i < 7; i++) {
            compounds[y][i] *= min;
            fertilizer[i] -= compounds[y][i];
        }

        // 나머지 화합물 계산
        for(int i=0; i<13; i++) {
            if (i == y) continue;
            setMajorCompoundValue(fertilizer, compounds[i]);
        }
        return compounds;
    }

    private static void setMajorCompoundValue(double[] fertilizer, double[] compound) {
        double min;
        min = 1000000;
        // 최소값 찾기
        for (int j = 0; j < 7; j++) {
            if (compound[j] != 0 && fertilizer[j] / compound[j] < min) {
                min = fertilizer[j] / compound[j];
            }
        }
        // 최소값을 원소 비율에 대해 곱하고 시비량 업데이트
        for (int j = 0; j < 7; j++) {
            min = Math.floor(min * 100) / 100.0;
            compound[j] *= min;
            fertilizer[j] -= compound[j];
        }
    }

    private static double[][] getMajorCompoundRatio(int majorSetting) {
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
        return compounds;
    }

    public int[] findChangeableCompounds(double[][] oldCompounds, double[][] newCompound) {
        for(int i = 0; i < 13; i++) {
            for (int j = 0; j < 7; j++) {
                if(oldCompounds[i][j] != newCompound[i][j]) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }


    public void printMajor(double[][] compounds, double[] fertilizer) {
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

    public double[][] autoCalculateTrace(double[] fertilizer, int[] traceSetting) {
        double[][] compounds = getTraceCompoundRatio(traceSetting);
        for(int i=0; i<11; i++) {
            setTraceCompoundValue(fertilizer, compounds[i]);
        }
        return compounds;
    }

    private double[][] getTraceCompoundRatio(int[] traceSetting) {
        double[][] compounds = new double[11][7];
        compounds[0] = new double[]{0, 0, 0, 0, 0, 0, 0};   // Fe-EDTA
        compounds[1] = new double[]{0, 0, 0, 0, 0, 0, 0};   // Fe-DTPA
        compounds[2] = new double[]{0, 0, 0, 0, 0, 0, 0};   // Fe-EDDHA
        compounds[3] = new double[]{0, 1, 0, 0, 0, 0, 0};   // Cu
        compounds[4] = new double[]{0, 0, 0, 0, 0, 0, 0};   // 붕산
        compounds[5] = new double[]{0, 0, 0, 0, 0, 0, 0};   // 붕사
        compounds[6] = new double[]{0, 0, 0, 0, 0, 0, 0};   // 황산망간 1수염
        compounds[7] = new double[]{0, 0, 0, 0, 0, 0, 0};   // 황산망간 5수염
        compounds[8] = new double[]{0, 0, 0, 0, 1, 0, 0};   // 황산아연
        compounds[9] = new double[]{0, 0, 0, 0, 0, 0, 0};   // 몰리브덴산나트륨
        compounds[10] = new double[]{0, 0, 0, 0, 0, 0, 0};  // 몰리브덴산암모늄

        if (traceSetting[0] == 0) {
            compounds[0][0] = 1.0;
        } else if (traceSetting[0] == 1) {
            compounds[1][0] = 1.0;
        } else if (traceSetting[0] == 2) {
            compounds[2][0] = 1.0;
        }

        if (traceSetting[1] == 0) {
            compounds[4][2] = 1.0;
        } else if (traceSetting[1] == 1) {
            compounds[5][2] = 1.0;
        }

        if(traceSetting[2] == 0){
            compounds[6][3] = 1.0;
        } else if(traceSetting[2] == 1){
            compounds[7][3] = 1.0;
        }

        if(traceSetting[3] == 0){
            compounds[9][5] = 1.0;
        } else if (traceSetting[3] == 1) {
            compounds[10][5] = 1.0;
        }

        return compounds;
    }

    private static void setTraceCompoundValue(double[] fertilizer, double[] compound) {
        double min;
        min = 1000000;
        // 최소값 찾기
        for (int j = 0; j < 6; j++) {
            if (compound[j] != 0 && fertilizer[j] / compound[j] < min) {
                min = fertilizer[j] / compound[j];
            }
        }
        // 최소값을 원소 비율에 대해 곱하고 시비량 업데이트
        for (int j = 0; j < 6; j++) {
            min = Math.floor(min * 100) / 100.0;
            compound[j] *= min;
            fertilizer[j] -= compound[j];
        }
    }

    public void printTrace(double[][] compounds, double[] fertilizer) {
        String[] compoundName = {
                "Fe-EDTA\t",
                "Fe-DTPA\t",
                "Fe-EDDHA\t",
                "황산구리\t\t",
                "붕산\t\t",
                "붕사\t\t",
                "황산망간1수염\t",
                "황산망간5수염\t",
                "황산아연\t\t",
                "몰리브덴산나트륨",
                "몰리브덴산암모늄",
        };
        String[] traceSymbol={
                "Fe\t",
                "Cu\t",
                "B\t",
                "Mn\t",
                "Zn\t",
                "Mo\t"
        };
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
        System.out.print("|\t\t\t");
        System.out.print("|\t");
        for(int i=0; i<6;i++){
            System.out.print(traceSymbol[i]+"\t|\t");
        }
        System.out.println();
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
        System.out.print("|시비량\t\t|");
        for (int i = 0; i < 6; i++) {
            System.out.print(fertilizer[i] + "\t\t|");
        }
        System.out.println();
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
        for (int i = 0; i < 11; i++) {
            System.out.print("|"+compoundName[i]+"|");
            for (int j = 0; j < 6; j++) {
                System.out.print(compounds[i][j] + "\t\t|");
            }
            System.out.println();
            System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
        }

        System.out.print("|농도합\t\t|");
        for (int i = 0; i < 6; i++) {
            double sum = 0;
            for(int j=0; j<10; j++){
                sum += compounds[j][i];
            }
            System.out.print(sum+"\t\t|");
        }
        System.out.println();
        System.out.println("├-----------┼-----------┼-----------┼-----------┼-----------┼-----------┼-----------┤");
    }
}
