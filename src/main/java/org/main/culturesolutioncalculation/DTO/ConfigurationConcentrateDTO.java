package org.main.culturesolutioncalculation.DTO;

public class ConfigurationConcentrateDTO {
    private final int setAtomSeq;
    private final Double NO3_N;
    private final Double NH4_N;
    private final Double P;
    private final Double K;
    private final Double Ca;
    private final Double Mg;
    private final Double SO4_S;

    public ConfigurationConcentrateDTO(int set_atom_seq, Double NO3_N, Double NH4_N, Double p, Double k, Double ca, Double mg, Double SO4_S) {
        this.setAtomSeq = set_atom_seq;
        this.NO3_N = NO3_N;
        this.NH4_N = NH4_N;
        this.P = p;
        this.K = k;
        this.Ca = ca;
        this.Mg = mg;
        this.SO4_S = SO4_S;
    }

    public int getSetAtomSeq() {
        return setAtomSeq;
    }

    public Double getNO3_N() {
        return NO3_N;
    }

    public Double getNH4_N() {
        return NH4_N;
    }

    public Double getP() {
        return P;
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

    public Double getSO4_S() {
        return SO4_S;
    }

    @Override
    public String toString() {
        return "ConfigurationConcentrateDTO{" +
                "set_atom_seq=" + setAtomSeq +
                ", NO3_N=" + NO3_N +
                ", NH4_N=" + NH4_N +
                ", P=" + P +
                ", K=" + K +
                ", Ca=" + Ca +
                ", Mg=" + Mg +
                ", SO4_S=" + SO4_S +
                '}';
    }
}
