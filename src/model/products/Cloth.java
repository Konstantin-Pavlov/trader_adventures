package model.products;

import emums.Quality;
import model.Goods;

public class Cloth extends Goods {
    public Cloth(int weight, Quality qualityCoefficient, int purchasePrice) {
        super(weight, "type", qualityCoefficient, purchasePrice);
    }
}
