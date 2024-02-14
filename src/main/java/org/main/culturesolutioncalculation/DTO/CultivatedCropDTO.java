package org.main.culturesolutioncalculation.DTO;

public class CultivatedCropDTO {
    private final Long cropSeq;
    private String cropName;

    public CultivatedCropDTO(Long cropSeq, String cropName) {
        this.cropSeq = cropSeq;
        this.cropName = cropName;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Long getCropSeq() {
        return cropSeq;
    }
}
