package state;

import interfaces.Event;
import model.Trader;

public class NormalDay implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("Обычный день - ничего не произошло. Проехали 3 лиги");
        trader.setDistance(trader.getDistance() - trader.getSpeed());
    }
}
