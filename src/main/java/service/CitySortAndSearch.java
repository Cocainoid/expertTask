package service;

import model.City;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitySortAndSearch {

    public static void sortByName(List<City> cityList) {
        cityList.sort(Comparator.comparing(City::getName));
        cityList.forEach(System.out::println);
    }

    public static void sortByDistrictThenName(List<City> cityList) {
        cityList.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        cityList.forEach(System.out::println);
    }

    public static String findMostPopulatedCity(List<City> cityList) {
        City[] citiesArr = new City[cityList.size()];
        cityList.toArray(citiesArr);
        int max = 0;
        int num = 0;
        for (int i = 0; i < citiesArr.length; i++) {
            if (citiesArr[i].getPopulation() > max) {
                max = citiesArr[i].getPopulation();
                num = i;
            }
        }
        System.out.println("[" + num + "] = " + max);
        return ("[" + num + "] = " + max);
    }

    public static Map<String, Integer> findCitiesByRegions(List<City> cityList) {
        Map<String, Integer> regionMap = new HashMap<>();
        cityList.forEach(city -> regionMap.merge(city.getRegion(), 1, (o, n) -> 1 + n));
        regionMap.forEach((a, b) -> System.out.println(a + " - " + b));
        return regionMap;
    }
}
