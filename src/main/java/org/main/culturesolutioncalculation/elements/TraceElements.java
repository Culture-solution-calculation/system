package org.main.culturesolutioncalculation.elements;

public enum TraceElements {
    Fe_EDTA("킬레이트철","Fe-EDTA(13%)",430),
    Fe_DTPA("킬레이트철","Fe-DTPA(6%)",932),
    Fe_EDDHA("킬레이트철","Fe-EDDHA(5%)",1118),
    CupricSulfate("황산구리","CuSO4•5H2O",249.7),
    BoricAcid("붕산","H3BO3",61.8),
    boraxAcid("붕사","Na2B4O7•7H2O",381.2),
    ManganeseSulfateMonohydrate("황산망간 1수염","MnSO4•H2O",169),
    ManganeseSulfatePentahydrate("황산망간 5수염","MnSO4•5H2O",241.08),
    ZincSulfate("황산아연","ZnSO4•7H2O",287.56),
    SodiumMolybdate("몰리브덴산나트륨","Na2MoO4•2H2O",241.9),
    AmmoniumMolybdate("몰리브덴산암모늄","(NH4)2Mo7O24•4H2O",1163.3);

    private final String name;
    private final String symbol;
    private final double atomicWeight; // 분자량(g/mol)

    TraceElements(String name, String symbol, double atomicWeight) {
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
