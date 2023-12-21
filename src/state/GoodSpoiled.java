package state;

import emums.Goods;
import emums.Quality;
import interfaces.Event;
import model.Trader;

public class GoodSpoiled implements Event {
    @Override
    public void run(Trader trader) {
        trader.setDistance(trader.getDistance() - trader.getSpeed() + 1);
        System.out.print("сегодня проехали 2 лиги. К сожалению один товар испортился, это: ");
        Goods good = trader.getRandomGood();
        System.out.println(good.getName());
        if(good.getQuality() == Quality.COMPLETELY_RUINED){
            System.out.printf("товар %s уже полность испорчен, он стоит %2f%n", good.getName(), good.getFinalPrice());
            return;
        }
        System.out.println("он стоил: " + good.getFinalPrice());
        good.setQuality(Quality.COMPLETELY_RUINED);
        System.out.println("теперь он стоит: " + good.getFinalPrice());
    }
}
