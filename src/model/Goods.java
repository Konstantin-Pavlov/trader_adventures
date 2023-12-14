package model;

import emums.Quality;

public abstract class Goods {
    protected int weight;
    protected String type;
    protected Quality qualityCoefficient;
    protected int purchasePrice;

    public Goods(int weight, String type, Quality qualityCoefficient, int purchasePrice) {
        this.weight = weight;
        this.type = type;
        this.qualityCoefficient = qualityCoefficient;
        this.purchasePrice = purchasePrice;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public Quality getQualityCoefficient() {
        return qualityCoefficient;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}