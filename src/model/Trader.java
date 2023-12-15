package model;

import emums.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trader {
    private int totalCash;
    private int speed;
    private int capacity;

    private Goods[] goods;
    private List<Goods> purchasedGoods;

    public Trader(int totalCash, int speed, int capacity) {
        this.totalCash = totalCash;
        this.speed = speed;
        this.capacity = capacity;
        this.goods = Goods.values();
        this.purchasedGoods = new ArrayList<>();

    }

    public void buyGoods() {
        Random random = new Random();
        System.out.println("покупаем товар");
        while (capacity >= 0 || totalCash >= 0) {
            Goods newItem = goods[random.nextInt(goods.length)];
            purchasedGoods.add(newItem);
            this.capacity -= newItem.getWeight();
            this.totalCash -= newItem.getPriceOnPoint();
            System.out.println("купили товар:  " + newItem.name());
            System.out.printf("товар весит %d, в телегу можно погрузить %d веса, денег осталось %d%n ",
                    newItem.getWeight(), this.capacity, this.totalCash);
        }
        System.out.println(" закупка товара закончена ");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
