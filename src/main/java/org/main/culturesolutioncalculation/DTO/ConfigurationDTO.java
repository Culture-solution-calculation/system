package org.main.culturesolutioncalculation.DTO;

public class ConfigurationDTO {
    private static final int conSeq = 0;
    private final int multiUnitSeq;
    private final int traceUnitSeq;
    private final int cnFertilizerSeq;
    private final int feFertilizerSeq;
    private final int bFertilizerSeq;
    private final int mnFertilizerSeq;
    private final int moFertilizerSeq;
    private final int inputUnitSeq;
    private final String elementalYn;

    public ConfigurationDTO(int multiUnitSeq, int traceUnitSeq, int cnFertilizerSeq, int feFertilizerSeq, int bFertilizerSeq, int mnFertilizerSeq, int moFertilizerSeq, int inputUnitSeq, String elementalYn) {
        this.multiUnitSeq = multiUnitSeq;
        this.traceUnitSeq = traceUnitSeq;
        this.cnFertilizerSeq = cnFertilizerSeq;
        this.feFertilizerSeq = feFertilizerSeq;
        this.bFertilizerSeq = bFertilizerSeq;
        this.mnFertilizerSeq = mnFertilizerSeq;
        this.moFertilizerSeq = moFertilizerSeq;
        this.inputUnitSeq = inputUnitSeq;
        this.elementalYn = elementalYn;
    }

    public int getConSeq() {
        return conSeq;
    }

    public int getMultiUnitSeq() {
        return multiUnitSeq;
    }

    public int getTraceUnitSeq() {
        return traceUnitSeq;
    }

    public int getCnFertilizerSeq() {
        return cnFertilizerSeq;
    }

    public int getFeFertilizerSeq() {
        return feFertilizerSeq;
    }

    public int getBFertilizerSeq() {
        return bFertilizerSeq;
    }

    public int getMnFertilizerSeq() {
        return mnFertilizerSeq;
    }

    public int getMoFertilizerSeq() {
        return moFertilizerSeq;
    }

    public int getInputUnitSeq() {
        return inputUnitSeq;
    }

    public String getElementalYn() {
        return elementalYn;
    }

    @Override
    public String toString() {
        return "ConfigurationDTO{" +
                "conSeq=" + conSeq +
                ", multiUnitSeq=" + multiUnitSeq +
                ", traceUnitSeq=" + traceUnitSeq +
                ", cnFertilizerSeq=" + cnFertilizerSeq +
                ", feFertilizerSeq=" + feFertilizerSeq +
                ", bFertilizerSeq=" + bFertilizerSeq +
                ", mnFertilizerSeq=" + mnFertilizerSeq +
                ", moFertilizerSeq=" + moFertilizerSeq +
                ", inputUnitSeq=" + inputUnitSeq +
                ", elementalYn='" + elementalYn + '\'' +
                '}';
    }
}
