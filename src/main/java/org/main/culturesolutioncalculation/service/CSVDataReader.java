package org.main.culturesolutioncalculation.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.main.culturesolutioncalculation.model.CropNutrientStandard;
import org.main.culturesolutioncalculation.model.NutrientSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVDataReader {
    private final ClassLoader classLoader = CSVDataReader.class.getClassLoader();
    private final Logger logger = Logger.getLogger(CSVDataReader.class.getName());
    private final Path resourcePath;

    public CSVDataReader() {
        URL resourceUrl = classLoader.getResource("");
        if (resourceUrl == null) {
            throw new IllegalStateException("Resource directory not found.");
        }
        try {
            URI uri = new URI(resourceUrl.toString() + "org/main/culturesolutioncalculation/data");
            this.resourcePath = Paths.get(uri);
            
            System.out.println("Final URL: " + uri.toURL());
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalStateException("Error creating resource path.", e);
        }
    }

    public ArrayList<String> readDir() {
        ArrayList<String> nutrientSolutionList = new ArrayList<>();
        try {
            // 리소스 디렉토리의 파일들 출력
            Files.list(resourcePath)
                    .filter(Files::isRegularFile)
                    .forEach(file ->{
                        String name = file.getFileName().toString().split("\\.")[0];
                        nutrientSolutionList.add(name);
                        System.out.println(name);
                    });

        } catch (IOException e) {
            // IOException을 처리하도록 수정
            logger.log(Level.SEVERE, "Error reading directory", e);
        }
        return nutrientSolutionList;
    }

    public NutrientSolution readFile(String fileName){
        ArrayList<CropNutrientStandard> crops = new ArrayList<>();
        // CSV 파일 경로 확인
        Path csvFilePath = resourcePath.resolve(fileName+".txt");

        // CSVReader를 try-with-resources로 사용하여 리소스 해제
        try (InputStream inputStream = Files.newInputStream(csvFilePath);
             InputStreamReader reader = new InputStreamReader(inputStream, "euc-kr");
             BufferedReader bufferedReader = new BufferedReader(reader);
             CSVReader csvReader = new CSVReader(bufferedReader)) {

            csvReader.readNext();

            String[] row = csvReader.readNext();
            while (row != null){
                String name = row[0];
                double EC = Double.parseDouble(row[1]);
                double NO3 = Double.parseDouble(row[2]);
                double NH4 = Double.parseDouble(row[3]);
                double H2PO4 = Double.parseDouble(row[4]);
                double K = Double.parseDouble(row[5]);
                double Ca = Double.parseDouble(row[6]);
                double Mg = Double.parseDouble(row[7]);
                double SO4 = Double.parseDouble(row[8]);
                double Fe = Double.parseDouble(row[9]);
                double Cu = Double.parseDouble(row[10]);
                double B = Double.parseDouble(row[11]);
                double Mn = Double.parseDouble(row[12]);
                double Zn = Double.parseDouble(row[13]);
                double Mo = Double.parseDouble(row[14]);
                crops.add(new CropNutrientStandard(name, fileName,EC,NO3,NH4,H2PO4,K,Ca,Mg,SO4,Fe,Cu,B,Mn,Zn,Mo));
                row = csvReader.readNext();
            }

        } catch (IOException | CsvException e) {
            logger.log(Level.SEVERE, "Error reading file: " + fileName, e);
        }

        return new NutrientSolution(fileName,crops);
    }
}
