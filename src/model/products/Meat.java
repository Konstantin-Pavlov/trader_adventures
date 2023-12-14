package model.products;

import emums.Quality;
import model.Goods;

public class Meat extends Goods {
    public Meat(int weight, String type, Quality qualityCoefficient, int purchasePrice) {
        super(weight, type, qualityCoefficient, purchasePrice);
    }
}
