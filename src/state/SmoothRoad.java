package state;

import interfaces.Event;
import model.Trader;

public class SmoothRoad implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("отличная дорога  скорость увеличена на две лиги ( но не более пяти лиг.) Проехали 5 лиг");
//        trader.setSpeed(trader.getSpeed() + 2);
//        if (trader.getSpeed() > 5) {
//            trader.setSpeed(5);
//        }
        trader.setDistance(trader.getDistance() - trader.getSpeed() - 2);

    }
}
