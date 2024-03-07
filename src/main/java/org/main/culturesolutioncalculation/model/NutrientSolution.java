package org.main.culturesolutioncalculation.model;

import java.util.ArrayList;
import java.util.List;

// 배양액 작물들
public class NutrientSolution {
    private final String name;
    private final ArrayList<CropNutrientStandard> cropList;

    public NutrientSolution(String name, ArrayList<CropNutrientStandard> cropList) {
        this.name = name;
        this.cropList = cropList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<CropNutrientStandard> getCropList() {
        return cropList;
    }

    @Override
    public String toString() {
        return "NutrientSolution{" +
                "name='" + name + '\'' +
                ", cropList=" + cropList +
                '}';
    }
}
