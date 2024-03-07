package org.main.culturesolutioncalculation.eum.elements;

// 다량원소 계산
public enum MajorElements {
    CalciumNitrateTetrahydrate("질산칼슘 4수염","Ca(NO₃)₂•4H₂O",236,2,0,0,0,1,0,0),
    CalciumNitrateDecahydrate("질산칼슘 10수염","5[Ca(NO₃)₂•2H₂O]NH₄NO₃",1080,2.2,0.2,0,0,1,0,0),
    PotassiumNitrate("질산칼륨","KNO₃",101,1,0,0,1,0,0,0),
    AmmoniumNitrate("질산암모늄","NH₄NO₃",80,1,1,0,0,0,0,0),
    AmmoniumDihydrogenPhosphate("제1인산암모늄","NH₄H₂PO₄",115,1,0,1,0,0,0,0),
    PotassiumDihydrogenPhosphate("제1인산칼륨","KH₂PO₄",136,0,0,1,1,0,0,0),
    PotassiumSulfate("황산칼륨","K₂SO₄",174,0,0,0,2,0,0,1),
    MagnesiumSulfate("황산마그네슘","MgSO₄•7H₂O",246,0,0,0,0,0,1,1),
    AmmoniumSulfate("황산암모늄","Mg(NO₃)₂•6H₂O",256,2,0,0,0,0,1,0),
    NitricAcid("질산","HNO₃",63,1,0,0,0,0,0,0),
    SulfuricAcid("황산","H₂SO₄",98,0,0,0,0,0,0,1),
    PhosphoricAcid("인산","H₃PO₄",98,0,1,0,0,0,0,0),
    PotassiumChloride("염화칼륨","KOH",75,0,0,0,1,0,0,0);

    private final String name;
    private final String symbol;
    private final double molecularWeight;
    private final double NO3_N;
    private final double NH4_N;
    private final double H2PO4;
    private final double K;
    private final double Ca;
    private final double Mg;
    private final double SO4_S;

    MajorElements(String name, String symbol, double molecularWeight, double NO3_N, double NH4_N, double H2PO4, double K, double Ca, double Mg, double SO4_S) {
        this.name = name;
        this.symbol = symbol;
        this.molecularWeight = molecularWeight;
        this.NO3_N = NO3_N;
        this.NH4_N = NH4_N;
        this.H2PO4 = H2PO4;
        this.K = K;
        this.Ca = Ca;
        this.Mg = Mg;
        this.SO4_S = SO4_S;
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

    public double getNO3_N() {
        return NO3_N;
    }

    public double getNH4_N() {
        return NH4_N;
    }

    public double getH2PO4() {
        return H2PO4;
    }

    public double getK() {
        return K;
    }

    public double getCa() {
        return Ca;
    }

    public double getMg() {
        return Mg;
    }

    public double getSO4_S() {
        return SO4_S;
    }

    public double getQuantity(double count){
        return this.molecularWeight * count;
    }
}
