package model.products;

import emums.Quality;
import model.Goods;

public class DiedFruits extends Goods {
    public DiedFruits(int weight, String type, Quality qualityCoefficient, int purchasePrice) {
        super(weight, type, qualityCoefficient, purchasePrice);
    }
}
