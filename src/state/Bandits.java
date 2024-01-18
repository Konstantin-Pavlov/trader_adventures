package state;

import emums.Goods;
import interfaces.Event;
import model.Trader;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Bandits implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("it's a robbery!");
        if (new Random().nextBoolean()) {
            System.out.printf("you  have %.2f money, we take it%n", trader.getTotalCash());
            trader.setTotalCash(0);
        } else {
            banditsGetTheBestGood(trader.getPurchasedGoods());
        }
    }

    private void banditsGetTheBestGood(List<Goods> goods) {
        if (goods == null) {
            System.out.println("there's no goods");
            return;
        }
        Goods goodWithMaxPrice = goods.stream().max(Comparator.comparing(Goods::getFinalPrice)).orElse(null);
        System.out.println("украден один из самых дорогих товаров: \n" + goodWithMaxPrice);
        goods.remove(goodWithMaxPrice);

    }
}
