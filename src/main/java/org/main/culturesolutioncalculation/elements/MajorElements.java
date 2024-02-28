package org.main.culturesolutioncalculation.elements;

public enum MajorElements {
    CalciumNitrateTetrahydrate("질산칼슘 4수염","Ca(NO3)2•4H2O",236),
    CalciumNitrateDecahydrate("질산칼슘 10수염","5[Ca(NO3)2•2H2O]NH4NO3",1080),
    PotassiumNitrate("질산칼륨","KNO3",101),
    AmmoniumNitrate("질산암모늄","NH4NO3",80),
    AmmoniumDihydrogenPhosphate("제1인산암모늄","NH4H2PO4",115),
    PotassiumDihydrogenPhosphate("제1인산칼륨","KH2PO4",136),
    PotassiumSulfate("황산칼륨","K2SO4",174),
    MagnesiumSulfate("황산마그네슘","MgSO•7H2O",246),
    AmmoniumSulfate("황산암모늄","Mg(NO3)2•6H2O",256),
    NitricAcid("질산","HNO3",63),
    SulfuricAcid("황산","H2SO4",98),
    PhosphoricAcid("인산","H3PO4",98),
    PotassiumChloride("염화칼륨","KOH",75);

    private final String name;
    private final String symbol;
    private final double atomicWeight; // 분자량(g/mol)

    MajorElements(String name, String symbol, double atomicWeight) {
        this.name = name;
        this.symbol = symbol;
        this.atomicWeight = atomicWeight;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }
}
