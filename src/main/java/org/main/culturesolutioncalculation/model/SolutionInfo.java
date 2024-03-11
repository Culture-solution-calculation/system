package org.main.culturesolutioncalculation.model;

public class SolutionInfo {
    // 분자이름
    private String name;
    // 기준량
    private double standardAmount;

    // 기준량 단위
    private String stdUnit;

    // 원수성분
    private double originComponent;

    // 원수 단위
    private String originUnit;

    // 처방농도
    private double prescriptionConcentration;

    private String prescriptionUnit;

    // 100배액 기준
    private double hundredfoldDilutionStandard;

    // 100배액 단위
    private String hundredfoldUnit;

    public SolutionInfo(String name){
        this.name = name;
    }

    public SolutionInfo(String name, double standardAmount, String stdUnit, double originComponent, String originUnit, double prescriptionConcentration, String prescriptionUnit, double hundredfoldDilutionStandard, String hundredfoldUnit) {
        this.name = name;
        this.standardAmount = standardAmount;
        this.stdUnit = stdUnit;
        this.originComponent = originComponent;
        this.originUnit = originUnit;
        this.prescriptionConcentration = prescriptionConcentration;
        this.prescriptionUnit = prescriptionUnit;
        this.hundredfoldDilutionStandard = hundredfoldDilutionStandard;
        this.hundredfoldUnit = hundredfoldUnit;
    }

    public void setValue(double standardAmount, String stdUnit, double originComponent, String originUnit, double prescriptionConcentration, String prescriptionUnit, double hundredfoldDilutionStandard, String hundredfoldUnit){
        this.standardAmount = standardAmount;
        this.stdUnit = stdUnit;
        this.originComponent = originComponent;
        this.originUnit = originUnit;
        this.prescriptionConcentration = prescriptionConcentration;
        this.prescriptionUnit = prescriptionUnit;
        this.hundredfoldDilutionStandard = hundredfoldDilutionStandard;
        this.hundredfoldUnit = hundredfoldUnit;
    }

    public double getStandardAmount() {
        return standardAmount;
    }

    public void setStandardAmount(double standardAmount) {
        this.standardAmount = standardAmount;
    }

    public String getStdUnit() {
        return stdUnit;
    }

    public void setStdUnit(String stdUnit) {
        this.stdUnit = stdUnit;
    }

    public double getOriginComponent() {
        return originComponent;
    }

    public void setOriginComponent(double originComponent) {
        this.originComponent = originComponent;
    }

    public String getOriginUnit() {
        return originUnit;
    }

    public void setOriginUnit(String originUnit) {
        this.originUnit = originUnit;
    }

    public double getPrescriptionConcentration() {
        return prescriptionConcentration;
    }

    public void setPrescriptionConcentration(double prescriptionConcentration) {
        this.prescriptionConcentration = prescriptionConcentration;
    }

    public String getPrescriptionUnit() {
        return prescriptionUnit;
    }

    public void setPrescriptionUnit(String prescriptionUnit) {
        this.prescriptionUnit = prescriptionUnit;
    }

    public double getHundredfoldDilutionStandard() {
        return hundredfoldDilutionStandard;
    }

    public void setHundredfoldDilutionStandard(double hundredfoldDilutionStandard) {
        this.hundredfoldDilutionStandard = hundredfoldDilutionStandard;
    }

    public String getHundredfoldUnit() {
        return hundredfoldUnit;
    }

    public void setHundredfoldUnit(String hundredfoldUnit) {
        this.hundredfoldUnit = hundredfoldUnit;
    }

    public String getName() {
        return name;
    }
}
