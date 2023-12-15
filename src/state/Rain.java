package state;

import emums.Goods;
import emums.Quality;
import model.Trader;

import java.util.Random;

public class Rain implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("сегодня идет дождь, скорость снижеа на две лиги ");
        trader.setSpeed(trader.getSpeed()-2);
        if (new Random().nextInt(10) < 3){
            System.out.println("с вероятностью 30% 1 товар испортился качество и цена снижены");
            Goods good = trader.getRandomGood();
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

            }
        }
    }
}
