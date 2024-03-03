package org.main.culturesolutioncalculation.model;

// 다량원소 원소 농도
public class MajorAtom {
    private double NO3_N;
    private double NH4_N;
    private double P;
    private double K;
    private double Ca;
    private double Mg;
    private double SO4_S;
    private double fertilizerAmount; // 시비량

    public MajorAtom(double NO3_N, double NH4_N, double P, double K, double Ca, double Mg, double SO4_S, double fertilizerAmount) {
        this.NO3_N = NO3_N;
        this.NH4_N = NH4_N;
        this.P = P;
        this.K = K;
        this.Ca = Ca;
        this.Mg = Mg;
        this.SO4_S = SO4_S;
        this.fertilizerAmount = fertilizerAmount;
    }

    public double getNO3_N() {
        return NO3_N;
    }

    public void setNO3_N(double NO3_N) {
        this.NO3_N = NO3_N;
    }

    public double getNH4_N() {
        return NH4_N;
    }

    public void setNH4_N(double NH4_N) {
        this.NH4_N = NH4_N;
    }

    public double getP() {
        return P;
    }

    public void setP(double P) {
        this.P = P;
    }

    public double getK() {
        return K;
    }

    public void setK(double K) {
        this.K = K;
    }

    public double getCa() {
        return Ca;
    }

    public void setCa(double Ca) {
        this.Ca = Ca;
    }

    public double getMg() {
        return Mg;
    }

    public void setMg(double Mg) {
        this.Mg = Mg;
    }

    public double getSO4_S() {
        return SO4_S;
    }

    public void setSO4_S(double SO4_S) {
        this.SO4_S = SO4_S;
    }

    public double getFertilizerAmount() {
        return fertilizerAmount;
    }

    public void setFertilizerAmount(double fertilizerAmount) {
        this.fertilizerAmount = fertilizerAmount;
    }
}
