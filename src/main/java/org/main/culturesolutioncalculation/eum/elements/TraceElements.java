package org.main.culturesolutioncalculation.eum.elements;

public enum TraceElements{
    Fe_EDTA("킬레이트철","Fe-EDTA(13%)",430,55.85, 1),
    Fe_DTPA("킬레이트철","Fe-DTPA(6%)",932,55.85, 1),
    Fe_EDDHA("킬레이트철","Fe-EDDHA(5%)",1118,55.85, 1),
    CupricSulfate("황산구리","CuSO₄ • 5H₂O",249.7,63.54, 1),
    BoricAcid("붕산","H₃BO₃",61.8,10.81, 1),
    BoraxAcid("붕사","Na₂B₄O₇•7H₂O",381.2,10.81, 4),
    ManganeseSulfateMonohydrate("황산망간 1수염","MnSO₄•H₂O",169,54.94, 1),
    ManganeseSulfatePentahydrate("황산망간 5수염","MnSO₄•5H₂O",241.08,54.94, 1),
    ZincSulfate("황산아연","ZnSO₄•7H₂O",287.56,65.37, 1),
    SodiumMolybdate("몰리브덴산나트륨","Na₂MoO₄•2H₂O",241.9,95.94, 1),
    AmmoniumMolybdate("몰리브덴산암모늄","(NH₄)₂Mo₇O₂₄•4H₂O",1163.3,95.94, 7);

    private final String name;
    private final String symbol;
    private final String type = "trace";
    private final double molecularWeight;
    private final double atomicWeight;

    private final double contentQuantity;

    TraceElements(String name, String symbol, double molecularWeight, double atomicWeight, double contentQuantity) {
        this.name = name;
        this.symbol = symbol;
        this.molecularWeight = molecularWeight;
        this.atomicWeight = atomicWeight;
        this.contentQuantity = contentQuantity;
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

    public double getContentQuantity() {
        return contentQuantity;
    }

    public double getQuantity(double fertilizerAmount, double count){
        return  molecularWeight * fertilizerAmount / atomicWeight / contentQuantity* count;
    }
}
