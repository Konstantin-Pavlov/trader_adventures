package model;

import emums.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trader {
    private double totalCash;
    private final int speed;
    private int capacity;
    private final Goods[] goods;
    private final List<Goods> purchasedGoods;
    private final Random random;
    private int distance;
    private int dayOnTheRoad;

    public Trader(int totalCash, int capacity, int distance) {
        this.totalCash = totalCash;
        this.speed = 3;
        this.capacity = capacity;
        this.goods = Goods.values();
        this.purchasedGoods = new ArrayList<>();
        this.random = new Random();
        this.distance = distance;
        this.dayOnTheRoad = 1;
    }

    public void buyGoods() {
        System.out.println("покупаем товар");
        while (capacity >= 0 && totalCash >= 0) {
            Goods newItem = goods[random.nextInt(goods.length)];
            if (capacity - newItem.getWeight() <= 0 || totalCash - newItem.getPriceOnPoint() <= 0) {
                break;
            }
            purchasedGoods.add(newItem);
            this.capacity -= newItem.getWeight();
            this.totalCash -= newItem.getPriceOnPoint();
            System.out.println("купили товар:  " + newItem.name());
            System.out.printf("товар весит %d, в телегу можно погрузить %d веса, денег осталось %.2f%n",
                    newItem.getWeight(), this.capacity, this.totalCash);
        }
        System.out.println("закупка товара закончена, купили: ");
        getPurchasedGoods().forEach(System.out::println);
        System.out.println("\n" + "#".repeat(50) + "\n");
    }

    public int getSpeed() {
        return speed;
    }

    public List<Goods> getPurchasedGoods() {
        return purchasedGoods;
    }

    public Goods getRandomGood() {
        if (purchasedGoods.isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }
        return this.purchasedGoods.get(random.nextInt(purchasedGoods.size()));
    }

    public double getTotalCash() {
        return totalCash;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    public int getDayOnTheRoad() {
        return dayOnTheRoad;
    }

    public void setDayOnTheRoad(int dayOnTheRoad) {
        this.dayOnTheRoad = dayOnTheRoad;
    }
}
