package org.main.culturesolutioncalculation.DTO;

public class AtomsConcentrationDTO {
    private final int set_atom_seq;
    private final int atom_seq;
    private final String atom_name;
    private final String molecular_formula;
    private final Double fertilizer_concentration;
    private final int unit_seq;
    private final String unit;
    private final Double NO3_N;
    private final Double NH4_N;
    private final Double P;
    private final Double K;
    private final Double Ca;
    private final Double Mg;
    private final Double SO4_S;

    public AtomsConcentrationDTO(int set_atom_seq, int atom_seq, String atom_name, String molecular_formula, Double fertilizer_concentration, int unit_seq, String unit, Double NO3_N, Double NH4_N, Double p, Double k, Double ca, Double mg, Double SO4_S) {
        this.set_atom_seq = set_atom_seq;
        this.atom_seq = atom_seq;
        this.atom_name = atom_name;
        this.molecular_formula = molecular_formula;
        this.fertilizer_concentration = fertilizer_concentration;
        this.unit_seq = unit_seq;
        this.unit = unit;
        this.NO3_N = NO3_N;
        this.NH4_N = NH4_N;
        this.P = p;
        this.K = k;
        this.Ca = ca;
        this.Mg = mg;
        this.SO4_S = SO4_S;
    }

    public int getSet_atom_seq() {
        return set_atom_seq;
    }

    public int getAtom_seq() {
        return atom_seq;
    }

    public String getAtom_name() {
        return atom_name;
    }

    public String getMolecular_formula() {
        return molecular_formula;
    }

    public Double getFertilizer_concentration() {
        return fertilizer_concentration;
    }

    public int getUnit_seq() {
        return unit_seq;
    }

    public String getUnit() {
        return unit;
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
        return "AtomsConcentrationDTO{" +
                "set_atom_seq=" + set_atom_seq +
                ", atom_seq=" + atom_seq +
                ", atom_name='" + atom_name + '\'' +
                ", molecular_formula='" + molecular_formula + '\'' +
                ", fertilizer_concentration=" + fertilizer_concentration +
                ", unit_seq=" + unit_seq +
                ", unit='" + unit + '\'' +
                ", NO3_N='" + NO3_N + '\'' +
                ", NH4_N='" + NH4_N + '\'' +
                ", P='" + P + '\'' +
                ", K='" + K + '\'' +
                ", Ca='" + Ca + '\'' +
                ", Mg='" + Mg + '\'' +
                ", SO4_S='" + SO4_S + '\'' +
                '}';
    }
}
