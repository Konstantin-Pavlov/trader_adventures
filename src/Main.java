import model.Road;
import model.Trader;
import state.GoodSpoiled;

public class Main {
    public static void main(String[] args) {
        Trader trader = new Trader(5000, 500, 50);
        trader.buyGoods();
        Road road = new Road(trader);
        road.hitTheRoad();
    }
}   