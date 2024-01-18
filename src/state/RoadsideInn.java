package state;

import emums.Goods;
import interfaces.Event;
import model.Trader;

import java.util.*;

// add goods for sale
public class RoadsideInn implements Event {
    private final Random random = new Random();
    Set<String> desiredGoods = generateDesiredGoods();

    @Override
    public void run(Trader trader) {
        int pricePerNight = 10;
        boolean hasSold = false;
        System.out.println("мы остановились в гостинице, c вероятностью 50% мы можем продать часть товара");

//      if not use iterator, got ConcurrentModificationException exception
//      The ConcurrentModificationException occurs when you try to modify a collection (such as removing elements)
//      while iterating over it using an enhanced for loop or a traditional for loop.
//      This exception is thrown to prevent potential data inconsistencies that can occur when multiple threads modify a collection concurrently.
        Iterator<Goods> iterator = trader.getPurchasedGoods().iterator();
        while (iterator.hasNext()) {
            Goods good = iterator.next();
            if (desiredGoods.contains(good.getName()) && random.nextBoolean()) {
                hasSold = true;
                System.out.println("бросили монетку и решили продать товар " + good.getName());
                System.out.printf("было денег: %.2f%n" +
                                "продали товар %s%n" +
                                "заработали %.2f%n",
                        trader.getTotalCash(),
                        good.getName(),
                        good.getFinalPrice()
                );
                trader.setTotalCash(trader.getTotalCash() + good.getFinalPrice());
                System.out.printf("теперь денег в кармане: %.2f%n%n", trader.getTotalCash());
                iterator.remove();
            }
        }
        if (!hasSold) {
            System.out.println("решили ничего не продавать");
        }
        if (trader.getTotalCash() - pricePerNight >= 0) {
            System.out.println("заплатили за ночлег: " + pricePerNight);
            trader.setTotalCash(trader.getTotalCash() - pricePerNight);
            System.out.printf("теперь денег в кармане: %.2f%n", trader.getTotalCash());
        } else {
            System.out.println("не денег на ночлег, отдыхаем на улице (");
        }
    }


    private Set<String> generateDesiredGoods() {
        Set<String> goods = new HashSet<>();
        String[] goodNames = Arrays.stream(Goods.values()).map(Goods::getName).toArray(String[]::new);

        while (goods.size() != 3) {
            goods.add(goodNames[random.nextInt(goodNames.length)]);
        }
        return goods;
    }

}
