package model;

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
                // не готовые события закоментированы
                Arrays.asList(
                        new Bandits(),
                        new BrokenWheel(),
                        new GoodSpoiled(),
                        new MetLocal(),
                        new NormalDay(),
                        new Rain(),
                        new River(),
//                        new RoadsideInn(),
                        new SmoothRoad())
        );
    }

    public void hitTheRoad() {
        while (trader.getDistance() >= 0) {
            System.out.println("day on the road: " + trader.getDayOnTheRoad());
            System.out.println("distance remains: " + trader.getDistance());
            trader.setEvent(getRandomEvent());
            trader.runEventScenario();
            trader.setDayOnTheRoad(trader.getDayOnTheRoad() + 1);
            System.out.println("the day is over");
            System.out.println("\n" + "#".repeat(50) + "\n");
        }
        System.out.println("days spent on the road: " + trader.getDayOnTheRoad());
    }

    private Event getRandomEvent() {
        Random random = new Random();
        int eventIndex = random.nextInt(events.size());
        return events.get(eventIndex);
    }
}


