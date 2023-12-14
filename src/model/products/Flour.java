package model.products;

import emums.Quality;
import model.Goods;

public class Flour extends Goods {
    public Flour(int weight, String type, Quality qualityCoefficient, int purchasePrice) {
        super(weight, type, qualityCoefficient, purchasePrice);
    }
}
