/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.anna.jserver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.anna.models.Attraction;
import ru.anna.models.City;

/**
 *
 * @author admin
 */
public class CityDao {

    private List<City> cities;
    private static final Attraction[] aCity1 = {
        new Attraction(1, "Театр", "им Данченко"),
        new Attraction(2, "Театр", "им Данченко")};
    private static final Attraction[] aCity2 = {
        new Attraction(1, "Театр2", "им Данченко2"),
        new Attraction(2, "Театр3", "им Данченко3")};
    private static final Attraction[] aCity3 = {
        new Attraction(1, "Театр3", "им Данченко3"),
        new Attraction(2, "Театр4", "им Данченк4")};

    private static final Attraction[] aCity4 = {
        new Attraction(1, "Театр4", "им Данченко3"),
        new Attraction(2, "Театр44", "им Данченк4")};

    private static final Attraction[] aCity5 = {
        new Attraction(1, "Театр45", "им Данченко3"),
        new Attraction(2, "Театр44", "им Данченк4")};

    public CityDao() {
        cities = new ArrayList<>();

        cities.add(new City(1, "Москва", "Столица РФ", "http://msk.msk.ru", "msk@mail.mail"));

        cities.add(new City(2, "Москва2", "Столица РФ", "http://msk.msk.ru", "msk2@mail.mail"));

        cities.add(new City(3, "Москва3", "Столица3", "http://msk.msk.ru", "msk3@mail.mail"));
        cities.add(new City(4, "Москва4", "Столица4", "http://msk.msk.ru", "msk4@mail.mail"));
        cities.add(new City(5, "Москва5", "Столица5", "http://msk.msk.ru", "msk5@mail.mail"));
        //cities.add(new City(6, "Москва6", "Столица6", "http://msk.msk.ru", "msk6@mail.mail"));
        cities.get(0).setAttractions(Arrays.asList(aCity1));
        cities.get(1).setAttractions(Arrays.asList(aCity2));
        cities.get(2).setAttractions(Arrays.asList(aCity3));
        cities.get(3).setAttractions(Arrays.asList(aCity4));
        cities.get(4).setAttractions(Arrays.asList(aCity5));

    }

    private static void print(List<City> ct) {
        for (City item : ct) {
            System.out.println("+++City+++");

            System.out.println(item.getId() + " " + item.getName()
                    + " " + item.getEmail() + " " + item.getUrl() + " " + item.getInfo());
            System.out.println("---attractions---:");
            for (Attraction aItem : item.getAttractions()) {
                System.out.println(aItem.getId());
                System.out.println(aItem.getName());
                System.out.println(aItem.getNote());

            }

        }

    }

    public List<City> getCities() {
        return cities;
    }

    public static void main(String[] ar) {
        List<City> cities = new CityDao().getCities();
        System.out.println("------" + cities + "----");
        print(cities);
        Gson g = new Gson();

        String ss = g.toJson(cities);
        System.out.println(ss);

        Type listType = new TypeToken<ArrayList<City>>() {
        }.getType();

        List<City> cities2 = g.fromJson(ss, listType);
        System.out.println("------" + cities2 + "----");
        print(cities2);
    }

}
