package emums;

public enum Goods {
    MEAT(10, Quality.NORMAL.getQualityCoefficient(), 1000),
    DRIED_FRUITS(20, Quality.NORMAL.getQualityCoefficient(), 250),
    GRAIN(30, Quality.NORMAL.getQualityCoefficient(), 400),
    FLOUR(30, Quality.NORMAL.getQualityCoefficient(), 500),
    CLOTH(20, Quality.NORMAL.getQualityCoefficient(), 700),
    PAINT(50, Quality.NORMAL.getQualityCoefficient(), 800);


    private final int weight;
    private double qualityCoefficient;
    private final int priceOnPoint;
    private Quality quality;

    Goods(int weight, double qualityCoefficient, int priceOnPoint) {
        this.weight = weight;
        this.qualityCoefficient = qualityCoefficient;
        this.priceOnPoint = priceOnPoint;
        this.quality = Quality.NORMAL;
    }


    public int getWeight() {
        return weight;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }

    public Quality getQuality() {
        return quality;
    }

    public double getFinalPrice() {
        return this.priceOnPoint * this.quality.getQualityCoefficient();
    }

    public int getPriceOnPoint() {
        return priceOnPoint;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
        this.qualityCoefficient = quality.getQualityCoefficient();
    }

}
