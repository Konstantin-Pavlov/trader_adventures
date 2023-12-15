package state;

import model.Trader;

import java.util.Random;

public class Rain implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("сегодня идет дождь, скорость снижеа на две лиги ");
        trader.setSpeed(trader.getSpeed()-2);
        if (new Random().nextInt(10) < 3){
            System.out.println("с вероятностью 30% товар испортился качестово и цена снижеы");
        }
    }
}
