package service;

import model.City;
import model.CityCRUD;

import java.io.File;
import java.util.*;

public class Main {
    
    public static City parseFile(String line) {
        String[] lineArr = line.split(";");

        String name = lineArr[1];
        String region = lineArr[2];
        String district = lineArr[3];
        int pop = Integer.parseInt(lineArr[4]);
        int found = Integer.parseInt(lineArr[5]);

        return new City(name, region, district, pop, found);
    }

    public static void readFromFile(String fileName, List<City> cities) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            cities.add(parseFile(scanner.nextLine()));
        }
    }

    public static void main(String[] args) throws Exception {
        List<City> cityList = new ArrayList<>();
        String fileName = "src/main/resources/Cities.txt";
        readFromFile(fileName, cityList);


        cityList.forEach(city -> insertRecord(city));

        CityCRUD table = new CityCRUD();
        table.createTable();
    }
}
