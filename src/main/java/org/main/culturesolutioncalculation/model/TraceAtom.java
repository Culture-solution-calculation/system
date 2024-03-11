package org.main.culturesolutioncalculation.model;

import org.main.culturesolutioncalculation.eum.elements.TraceElements;
public class TraceAtom{
    private final TraceElements Enum;
    private double Fe;
    private double Cu;
    private double B;
    private double Mn;
    private double Zn;
    private double Mo;
    private double fertilizerAmount;

    public TraceAtom(TraceElements anEnum, double fe, double cu, double b, double mn, double zn, double mo, double fertilizerAmount) {
        Enum = anEnum;
        Fe = fe;
        Cu = cu;
        B = b;
        Mn = mn;
        Zn = zn;
        Mo = mo;
        this.fertilizerAmount = fertilizerAmount;
    }

    public double getFe() {
        return Fe;
    }

    public void setFe(double fe) {
        Fe = fe;
    }

    public double getCu() {
        return Cu;
    }

    public void setCu(double cu) {
        Cu = cu;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getMn() {
        return Mn;
    }

    public void setMn(double mn) {
        Mn = mn;
    }

    public double getZn() {
        return Zn;
    }

    public void setZn(double zn) {
        Zn = zn;
    }

    public double getMo() {
        return Mo;
    }

    public void setMo(double mo) {
        Mo = mo;
    }

    public double getFertilizerAmount() {
        return fertilizerAmount;
    }

    public void setFertilizerAmount(double fertilizerAmount) {
        this.fertilizerAmount = fertilizerAmount;
    }

    public TraceElements getEnum() {
        return Enum;
    }

    @Override
    public String toString() {
        return "TraceAtom{" +
                "Enum=" + Enum +
                ", Fe=" + Fe +
                ", Cu=" + Cu +
                ", B=" + B +
                ", Mn=" + Mn +
                ", Zn=" + Zn +
                ", Mo=" + Mo +
                ", fertilizerAmount=" + fertilizerAmount +
                '}';
    }
}
