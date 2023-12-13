package model.cities;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class City {
    private Map<String, Integer> cities;

    public City() {
        this.cities = new HashMap<>();
        initializationDistance();
    }

    private static int getRandomDistance(){
        Random rnd = new Random();
        return rnd.nextInt(51)+50;
    }
    private void initializationDistance(){
        cities.put("Berlin", getRandomDistance());
        cities.put("Bremen", getRandomDistance());
        cities.put("Munchen", getRandomDistance());
        cities.put("Grimen", getRandomDistance());
        cities.put("Stralsund", getRandomDistance());
    }

    public Map<String, Integer> getCities() {
        return cities;
    }
}
