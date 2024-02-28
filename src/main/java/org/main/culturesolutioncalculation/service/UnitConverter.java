package org.main.culturesolutioncalculation.service;

public class UnitConverter {
    public double getPpmFromMillimole(double millimoles, double molecularWeight){
        return millimoles * molecularWeight;
    }

    public  double getPpmFromMicromole(double micromoles, double molecularWeight,double equivalents){
        return micromoles / molecularWeight * equivalents;
    }

    public double getMillimoleFromPpm(double ppm, double molecularWeight){
        return ppm * molecularWeight;
    }

    public double getMillimoleFromMicromole(double micromoles, double equivalents){
        return micromoles / equivalents;
    }

    public double getMicromoleFromPpm(double ppm, double molecularWeight, double equivalents){
        return ppm / molecularWeight * equivalents;
    }

    public double getMicroFromMillimole(double millimoles, double equivalents){
        return millimoles * equivalents;
    }
}
