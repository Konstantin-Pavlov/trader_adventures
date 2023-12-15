package state;

import model.Trader;

public interface Event {
     void run(Trader trader) ;
}
