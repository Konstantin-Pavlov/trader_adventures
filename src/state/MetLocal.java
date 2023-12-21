package state;

import interfaces.Event;
import model.Trader;

public class MetLocal implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("встретили местного - прошли 5 лиг вместо обычных 3");
        trader.setDistance(trader.getDistance() - trader.getSpeed() - 2);
    }
}
