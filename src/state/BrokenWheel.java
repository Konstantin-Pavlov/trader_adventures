package state;

import interfaces.Event;
import model.Trader;

public class BrokenWheel implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("сломалось колесо, не продвинулись ни на сколько");

    }
}
