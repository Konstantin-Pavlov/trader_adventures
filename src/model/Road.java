package model;

import emums.Goods;
import interfaces.Event;
import state.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Road {

    private final List<Event> events;
    private final Trader trader;

    public Road(Trader trader) {
        this.trader = trader;
        events = new ArrayList<>(
                Arrays.asList(
                        new Bandits(),
                        new BrokenWheel(),
                        new GoodSpoiled(),
                        new MetLocal(),
                        new NormalDay(),
                        new Rain(),
                        new River(),
                        new RoadsideInn(),
                        new SmoothRoad())
        );
    }

    public void hitTheRoad() {
        double moneyAtTheStart = trader.getTotalCash();
        System.out.println("начало пути, количество денег: " + trader.getTotalCash());
        trader.buyGoods();
        System.out.println("закупили товар, денег осталось: " + trader.getTotalCash());
        System.out.println();
        while (trader.getDistance() >= 0) {
            System.out.println("day on the road: " + trader.getDayOnTheRoad());
            System.out.println("distance remains: " + trader.getDistance());
            System.out.println("number of goods: " + trader.getPurchasedGoods().size());
            runEventScenario();
            trader.setDayOnTheRoad(trader.getDayOnTheRoad() + 1);
            System.out.println("the day is over");
            System.out.println("\n" + "#".repeat(50) + "\n");
            if(trader.getPurchasedGoods().isEmpty()){
                System.out.println("no goods left :(");
                break;
            }
        }
        System.out.println("days spent on the road: " + trader.getDayOnTheRoad());
        sellAllGoodsLeft();
        System.out.println("\n" + "#".repeat(50) + "\n");
        System.out.println("money at the start: " + moneyAtTheStart);
        System.out.println("current money: " + trader.getTotalCash());
        System.out.println("profit: " + (trader.getTotalCash() - moneyAtTheStart));

    }

    private Event getRandomEvent() {
        Random random = new Random();
        int eventIndex = random.nextInt(events.size());
        return events.get(eventIndex);
    }

    private void runEventScenario(){
        getRandomEvent().run(trader);
    }

    private void sellAllGoodsLeft(){
        if(trader.getPurchasedGoods().isEmpty()){
            System.out.println("no goods, nothing to sell :(");
            return;
        }
        System.out.println("arrived to the city and selling remaining goods:");
        for (Goods good : trader.getPurchasedGoods()) {
            System.out.printf("Balance: %.2f.Selling %s for  %.2f%n", trader.getTotalCash(), good.getName(), good.getFinalPrice());
            trader.setTotalCash(trader.getTotalCash() + good.getFinalPrice());
        }
        trader.getPurchasedGoods().clear();
    }
}


