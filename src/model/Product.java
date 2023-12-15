package model;

import emums.Quality;

public class Product {
    private Quality quality;
     public Product(Quality quality) {
        this.quality = quality;
    }

    public void decreaseQuality() {
        switch (quality) {
            case EXCELLENT:
                quality = Quality.GOOD;
                break;
            case GOOD:
                quality = Quality.AVERAGE;
                break;
            case AVERAGE:
                quality = Quality.POOR;
                break;
            case POOR:
                break;
        }
    }

    public Quality getQuality() {
        return quality;
    }
}
