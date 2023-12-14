package model;

import java.util.*;

public class City {
    private List<Integer> distanceAndCoef;
    private Map<String, List<Integer>> cities;

    public City() {
        this.cities = new HashMap<>();
        this.distanceAndCoef = new ArrayList<>();
        initializationDistance();
    }

    private static int getRandomDistance() {
        Random rnd = new Random();
        return rnd.nextInt(51) + 50;
    }
    private static int getRandomCoefToBuy() {
        Random rnd = new Random();
        return rnd.nextInt(3)+1 ;
    }

    private void initializationDistance() {
        for (String city : Arrays.asList("Berlin", "Bremen", "Munchen", "Grimen", "Stralsund")) {
            List<Integer> distances = new ArrayList<>();
            distances.add(getRandomDistance());
            distances.add(getRandomCoefToBuy());

            cities.put(city, distances);
        }
    }

    public Map<String, List<Integer>> getCities() {
        return cities;
    }


    //у каждого города будет свой кэф, чтобы задать цену на товар
    //этот метод чтобы получить кэф, чтобы задать цену товару при покупке
    public int getCoefToBuyForCity(String cityName) {
        List<Integer> distances = cities.get(cityName);
        if (distances != null && distances.size() == 2) {
            return distances.get(1);
        } else {
            throw new IllegalArgumentException("Нету такого города");
        }
    }

    //а это чтобы получить дистанцию до города от точки где мы находимя
    public int getDistanceForCity(String cityName) {
        List<Integer> distances = cities.get(cityName);
        if (distances != null && distances.size() == 2) {
            return distances.get(0);
        } else {
            throw new IllegalArgumentException("Нету такого города");
        }
    }
}

