import model.City;
import org.junit.Assert;
import org.junit.Test;
import service.CitySortAndSearch;
import service.Main;

import java.io.FileNotFoundException;
import java.util.*;

public class TestClass {
    static List<City> actual = new ArrayList<>();

    // TODO: Проверка наличия файла
    @Test (expected = FileNotFoundException.class)
    public void checkFileExist() throws Exception {
        Main.readFromFile("", Collections.emptyList());
    }

    // TODO: Проверка полученных данных
    @Test
    public void checkDataCorrectness() throws Exception {
        List<City> expected = new ArrayList<>();
        expected.add(new City("Адыгейск","Адыгея","Южный",12248, 1973));
        expected.add(new City("Майкоп","Адыгея", "Южный", 144246, 1857));
        expected.add(new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830));

        Main.readFromFile("src/main/resources/TestFiles/test1.txt", actual);

        Assert.assertEquals(expected, actual);
        actual.clear();
    }

    // TODO: Проверка сортировки элементов по названию
    @Test
    public void checkDataSortedByName() throws Exception {
        List<City> expected = new ArrayList<>();
        expected.add(new City("Абаза", "Хакасия", "Сибирский", 17111, 1867));
        expected.add(new City("Абакан", "Хакасия", "Сибирский", 1651883, 1931));
        expected.add(new City("Абдулино", "Оренбургская область", "Приволжский", 20663, 1795));

        Main.readFromFile("src/main/resources/TestFiles/testSortByName.txt", actual);
        CitySortAndSearch.sortByName(actual);

        Assert.assertEquals(expected, actual);
        actual.clear();
    }

    // TODO: Проверка сортировки элементов по округу и имени
    @Test
    public void checkDataSortedByRegionAndName() throws Exception {
        List<City> expected = new ArrayList<>();
        expected.add(new City("Алдан", "Якутия", "Дальневосточный", 21277, 1924));
        expected.add(new City("Александровск-Сахалинский", "Сахалинская область", "Дальневосточный", 10613, 1869));
        expected.add(new City("Амурск", "Хабаровский край", "Дальневосточный", 42977,1958));

        Main.readFromFile("src/main/resources/TestFiles/testSortByRegionAndName.txt", actual);
        CitySortAndSearch.sortByDistrictThenName(actual);

        Assert.assertEquals(expected, actual);
        actual.clear();
    }

    // TODO: Проверка поиска города с наибольшим количеством жителей
    @Test
    public void checkFindMostPopulatedCity() throws Exception{
        String expected = "[" + 1 + "] = " + 144246;

        Main.readFromFile("src/main/resources/TestFiles/testSearchMostPopulated.txt", actual);

        Assert.assertEquals(expected, CitySortAndSearch.findMostPopulatedCity(actual));
        actual.clear();
    }

    // TODO: Проверка поиска количества городов в разрезе регионов
    @Test
    public void checkFindCitiesByRegions() throws Exception {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Хакасия", 2);
        expected.put("Башкортостан", 1);
        expected.put("Адыгея", 2);

        Main.readFromFile("src/main/resources/TestFiles/testSearchCitiesByRegions.txt", actual);
        Assert.assertEquals(expected, CitySortAndSearch.findCitiesByRegions(actual));
        actual.clear();
    }

}
