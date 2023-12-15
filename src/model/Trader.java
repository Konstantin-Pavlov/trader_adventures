package model;

import emums.Goods;
import state.Event;
import state.Rain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trader {
    private int totalCash;
    private int speed;
    private int capacity;
    private Event event;
    private Goods[] goods;
    private List<Goods> purchasedGoods;

    private Random random;

    public Trader(int totalCash, int speed, int capacity) {
        this.totalCash = totalCash;
        this.speed = speed;
        this.capacity = capacity;
        this.goods = Goods.values();
        this.purchasedGoods = new ArrayList<>();
        this.random = new Random();

    }

    public void buyGoods() {
        System.out.println("покупаем товар");
        while (capacity >= 0 && totalCash >= 0) {
            Goods newItem = goods[random.nextInt(goods.length)];
            if (capacity - newItem.getWeight()<=0 ||  totalCash - newItem.getPriceOnPoint()<=0){
                break;
            }
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

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Goods> getPurchasedGoods() {
        return purchasedGoods;
    }

    public Goods getRandomGood(){
        return this.purchasedGoods.get(random.nextInt(purchasedGoods.size()));
    }

    public void rainEvent(){
        this.event.run(this);
    }

}
