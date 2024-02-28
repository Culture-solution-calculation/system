package org.main.culturesolutioncalculation.eum.elements;

public enum TraceElements {
    Fe_EDTA("킬레이트철","Fe-EDTA(13%)",430,55.85),
    Fe_DTPA("킬레이트철","Fe-DTPA(6%)",932,55.85),
    Fe_EDDHA("킬레이트철","Fe-EDDHA(5%)",1118,55.85),
    CupricSulfate("황산구리","CuSO₄ • 5H₂O",249.7,63.54),
    BoricAcid("붕산","H₃BO₃",61.8,10.81),
    boraxAcid("붕사","Na₂B₄O₇•7H₂O",381.2,10.81),
    ManganeseSulfateMonohydrate("황산망간 1수염","MnSO₄•H₂O",169,54.94),
    ManganeseSulfatePentahydrate("황산망간 5수염","MnSO₄•5H₂O",241.08,54.94),
    ZincSulfate("황산아연","ZnSO₄•7H₂O",287.56,65.37),
    SodiumMolybdate("몰리브덴산나트륨","Na₂MoO₄•2H₂O",241.9,95.94),
    AmmoniumMolybdate("몰리브덴산암모늄","(NH₄)₂Mo₇O₂₄•4H₂O",1163.3,95.94);

    private final String name;
    private final String symbol;
    private final double molecularWeight;
    private final double atomicWeight;

    TraceElements(String name, String symbol, double molecularWeight, double atomicWeight) {
        this.name = name;
        this.symbol = symbol;
        this.molecularWeight = molecularWeight;
        this.atomicWeight = atomicWeight;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getMolecularWeight() {
        return molecularWeight;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public double getQuantity(double fertilizerAmount,double count){
        return molecularWeight * fertilizerAmount / atomicWeight / count;
    }
}
