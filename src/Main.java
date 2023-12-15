import emums.Goods;
import emums.Quality;
import model.Trader;
import state.Rain;

public class Main {
    public static void main(String[] args) {
        Trader trader= new Trader(5000, 5, 200);
        trader.buyGoods();
        System.out.println(trader.getPurchasedGoods());
        trader.setEvent(new Rain());
        trader.rainEvent();
    }
}   