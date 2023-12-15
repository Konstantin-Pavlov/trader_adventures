package state;

import model.Trader;

public class NormalDay implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("Обычный день - ничего не произошло.");
    }
}
