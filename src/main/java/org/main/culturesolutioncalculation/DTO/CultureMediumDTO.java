package org.main.culturesolutioncalculation.DTO;

public class CultureMediumDTO {
    private final Long cultureMediumSeq;
    private String cultureMediumName;

    public CultureMediumDTO(Long cultureMediumSeq, String cultureMediumName) {
        this.cultureMediumSeq = cultureMediumSeq;
        this.cultureMediumName = cultureMediumName;
    }

    public Long getCultureMediumSeq() {
        return cultureMediumSeq;
    }

    public String getCultureMediumName() {
        return cultureMediumName;
    }

    public void setCultureMediumName(String cultureMediumName) {
        this.cultureMediumName = cultureMediumName;
    }
}
