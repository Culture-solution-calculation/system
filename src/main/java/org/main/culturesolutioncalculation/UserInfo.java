package org.main.culturesolutioncalculation;

import java.time.LocalDate;


public class UserInfo {
    // 고객 이름
    private String customerName;
    // 처리 일자
    private LocalDate processingDate;
    // 시료 번호
    private String sampleNumber;

    // 배양액 종류
    private String selectedCulture;

    // 재배 작물
    private String selectedCrop;


    public UserInfo() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(LocalDate processingDate) {
        this.processingDate = processingDate;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getSelectedCrop() {
        return selectedCrop;
    }

    public void setSelectedCrop(String crop) {
        this.selectedCrop = crop;
    }

    public String getSelectedCulture() {
        return selectedCulture;
    }

    public void setSelectedCulture(String culture) {
        this.selectedCulture = culture;
    }
}
