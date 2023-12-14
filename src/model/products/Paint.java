package model.products;

import emums.Quality;
import model.Goods;

public class Paint extends Goods {
    public Paint(int weight, String type, Quality qualityCoefficient, int purchasePrice) {
        super(weight, type, qualityCoefficient, purchasePrice);
    }
}
