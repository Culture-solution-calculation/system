package org.main.culturesolutioncalculation.eum.elements;


// 이온,원자 원자량
public enum Amu {
    NO3_N("질산 이온(NO₃⁻)","NO3-N",14.01),
    NH4_N("암모늄 이온(NH₄⁺)","NH4-N",14.01),
    H2PO4("이산화수소 이온(H₂PO₄⁻)","H2PO4",30.97),
    K("칼륨","K",39.1),
    Ca("칼슘","Ca",40.08),
    Mg("마그네슘","Mg",24.31),
    SO4_S("황산 이온(SO₄²⁻)","SO4-S",32.06),
    Fe("철","Fe",55.85),
    Cu("구리","Cu",63.54),
    B("붕소","B",10.81),
    Mn("망간","Mn",54.94),
    Zn("아연","Zn",65.37),
    Mo("Mo","몰리브덴",95.94);
    private final String name;
    private final String symbol;
    private final double amu;

    Amu(String name, String symbol, double amu) {
        this.name = name;
        this.symbol = symbol;
        this.amu = amu;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getAmu() {
        return amu;
    }
}
