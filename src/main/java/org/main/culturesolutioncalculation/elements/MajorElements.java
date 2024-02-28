package org.main.culturesolutioncalculation.elements;

public enum MajorElements {
    CalciumNitrateTetrahydrate("질산칼슘 4수염","Ca(NO₃)₂•4H₂O",236),
    CalciumNitrateDecahydrate("질산칼슘 10수염","5[Ca(NO₃)₂•2H₂O]NH₄NO₃",1080),
    PotassiumNitrate("질산칼륨","KNO₃",101),
    AmmoniumNitrate("질산암모늄","NH₄NO₃",80),
    AmmoniumDihydrogenPhosphate("제1인산암모늄","NH₄H₂PO₄",115),
    PotassiumDihydrogenPhosphate("제1인산칼륨","KH₂PO₄",136),
    PotassiumSulfate("황산칼륨","K₂SO₄",174),
    MagnesiumSulfate("황산마그네슘","MgSO₄•7H₂O",246),
    AmmoniumSulfate("황산암모늄","Mg(NO₃)₂•6H₂O",256),
    NitricAcid("질산","HNO₃",63),
    SulfuricAcid("황산","H₂SO₄",98),
    PhosphoricAcid("인산","H₃PO₄",98),
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
