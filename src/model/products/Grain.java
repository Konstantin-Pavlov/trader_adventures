package model.products;

import emums.Quality;
import model.Goods;

public class Grain extends Goods {
    public Grain(int weight, String type, Quality qualityCoefficient, int purchasePrice) {
        super(weight, type, qualityCoefficient, purchasePrice);
    }
}
