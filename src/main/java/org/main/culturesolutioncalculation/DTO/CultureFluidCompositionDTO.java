package org.main.culturesolutioncalculation.DTO;

public class CultureFluidCompositionDTO {
    private final int cultureMediumSeq;
    private final int cropSeq;
    private String cropName = null;
    private Double EC = 0.0;
    private Double NO3 = 0.0;
    private Double NH4 = 0.0;
    private Double H2PO4 = 0.0;
    private Double K = 0.0;
    private Double Ca = 0.0;
    private Double Mg = 0.0;
    private Double SO4 = 0.0;
    private Double Fe = 0.0;
    private Double Cu = 0.0;
    private Double B = 0.0;
    private Double Mn = 0.0;
    private Double Zn = 0.0;
    private Double Mo = 0.0;

    public CultureFluidCompositionDTO(int cultureMediumSeq, int cropSeq) {
        this.cultureMediumSeq = cultureMediumSeq;
        this.cropSeq = cropSeq;
    }

    public CultureFluidCompositionDTO(int cultureMediumSeq, int cropSeq, Double EC, Double NO3, Double NH4, Double h2PO4, Double k, Double ca, Double mg, Double SO4, Double fe, Double cu, Double b, Double mn, Double zn, Double mo) {
        this.cultureMediumSeq = cultureMediumSeq;
        this.cropSeq = cropSeq;
        this.EC = EC;
        this.NO3 = NO3;
        this.NH4 = NH4;
        this.H2PO4 = h2PO4;
        this.K = k;
        this.Ca = ca;
        this.Mg = mg;
        this.SO4 = SO4;
        this.Fe = fe;
        this.Cu = cu;
        this.B = b;
        this.Mn = mn;
        this.Zn = zn;
        this.Mo = mo;
    }

    public CultureFluidCompositionDTO(int cultureMediumSeq, int cropSeq, String cropName, Double EC, Double NO3, Double NH4, Double h2PO4, Double k, Double ca, Double mg, Double SO4, Double fe, Double cu, Double b, Double mn, Double zn, Double mo) {
        this.cultureMediumSeq = cultureMediumSeq;
        this.cropSeq = cropSeq;
        this.cropName = cropName;
        this.EC = EC;
        this.NO3 = NO3;
        this.NH4 = NH4;
        this.H2PO4 = h2PO4;
        this.K = k;
        this.Ca = ca;
        this.Mg = mg;
        this.SO4 = SO4;
        this.Fe = fe;
        this.Cu = cu;
        this.B = b;
        this.Mn = mn;
        this.Zn = zn;
        this.Mo = mo;
    }


    public int getCultureMediumSeq() {
        return cultureMediumSeq;
    }

    public int getCropSeq() {
        return cropSeq;
    }

    public Double getEC() {
        return EC;
    }

    public Double getNO3() {
        return NO3;
    }

    public Double getNH4() {
        return NH4;
    }

    public Double getH2PO4() {
        return H2PO4;
    }

    public Double getK() {
        return K;
    }

    public Double getCa() {
        return Ca;
    }

    public Double getMg() {
        return Mg;
    }

    public Double getSO4() {
        return SO4;
    }

    public Double getFe() {
        return Fe;
    }

    public Double getCu() {
        return Cu;
    }

    public Double getB() {
        return B;
    }

    public Double getMn() {
        return Mn;
    }

    public Double getZn() {
        return Zn;
    }

    public Double getMo() {
        return Mo;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    @Override
    public String toString() {
        return "CultureFluidCompositionDTO{" +
                "cultureMediumSeq=" + cultureMediumSeq +
                ", cropSeq=" + cropSeq +
                ", cropName='" + cropName + '\'' +
                ", EC=" + EC +
                ", NO3=" + NO3 +
                ", NH4=" + NH4 +
                ", H2PO4=" + H2PO4 +
                ", K=" + K +
                ", Ca=" + Ca +
                ", Mg=" + Mg +
                ", SO4=" + SO4 +
                ", Fe=" + Fe +
                ", Cu=" + Cu +
                ", B=" + B +
                ", Mn=" + Mn +
                ", Zn=" + Zn +
                ", Mo=" + Mo +
                '}';
    }
}
