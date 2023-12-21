package state;

import interfaces.Event;
import model.Trader;

public class River implements Event {
    @Override
    public void run(Trader trader) {
        System.out.println("дошли до реки, весь день потратили на переправу, не продвинулись ни на сколько");
    }
}
