package state;

import model.Trader;

public class NormalDay implements Event {
    public void printNormal(){
        System.out.println("Normal day, all right!");
    }

    @Override
    public void run(Trader trader) {

    }
}
