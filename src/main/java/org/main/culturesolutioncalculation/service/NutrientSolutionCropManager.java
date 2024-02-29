package org.main.culturesolutioncalculation.service;
import org.main.culturesolutioncalculation.model.NutrientSolution;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class NutrientSolutionCropManager {
    private final CSVDataReader csvDataReader;

    public NutrientSolutionCropManager() throws URISyntaxException {
        this.csvDataReader = new CSVDataReader();
    }

    public ArrayList<NutrientSolution> getCropData() {
        ArrayList<String> nutrientSolutionNameList = csvDataReader.readDir();
        ArrayList<NutrientSolution> nutrientSolutions = new ArrayList<>();
        nutrientSolutionNameList.forEach(name->{
            nutrientSolutions.add(csvDataReader.readFile(name));
        });

        return nutrientSolutions;
    }
}
