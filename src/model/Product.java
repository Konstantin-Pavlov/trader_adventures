package model;

import emums.Quality;

public class Product {
    private Quality quality;
     public Product(Quality quality) {
        this.quality = quality;
    }

    public void decreaseQuality() {
        switch (quality) {
            case NORMAL:
                quality = Quality.NORMAL;
                break;
            case SLIGHTLY_DAMAGED:
                quality = Quality.SLIGHTLY_DAMAGED;
                break;
            case HALF_DAMAGED:
                quality = Quality.HALF_DAMAGED;
                break;
            case COMPLETELY_RUINED:
                break;
        }
    }

    public Quality getQuality() {
        return quality;
    }
}
