package state;

import emums.Goods;
import emums.Quality;
import interfaces.Event;
import model.Trader;

import java.util.Random;

public class Rain implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("сегодня идет дождь, скорость снижена на две лиги. Проехали 1 лигу ");
//        trader.setSpeed(trader.getSpeed() - 2);
        trader.setDistance(trader.getDistance() - trader.getSpeed() + 2);
        if (new Random().nextInt(10) < 3) {
            System.out.println("с вероятностью 30% 1 товар испортился качество и цена снижены");
            Goods good = trader.getRandomGood();
            if (good.getQuality() == Quality.COMPLETELY_RUINED) {
                System.out.printf("товар %s уже полностью испорчен, он стоит %.2f%n", good.getName(), good.getFinalPrice());
                return;
            }
            System.out.println("товар испорчен: " + good.name());
            System.out.println("он стоил: " + good.getFinalPrice());
            switch (good.getQuality()) {
                case NORMAL:
                    good.setQuality(Quality.SLIGHTLY_DAMAGED);
                    break;
                case SLIGHTLY_DAMAGED:
                    good.setQuality(Quality.HALF_DAMAGED);
                    break;
                case HALF_DAMAGED:
                    good.setQuality(Quality.ALMOST_DAMAGED);
                    break;
                case ALMOST_DAMAGED:
                    good.setQuality(Quality.COMPLETELY_RUINED);
                    break;
                default:
                    System.err.println("товар максимально испорчен");
            }
            System.out.println("теперь он стоит: " + good.getFinalPrice());
        }
    }
}

