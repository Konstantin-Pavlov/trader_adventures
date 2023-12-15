package emums;

public enum Goods {
    MEAT(10, 1.2,1000),
    DRIED_FRUITS(20, 1.2,250),
    GRAIN(30, 1.2,400),
    FLOUR(30, 1.2,500),
    CLOTH(20, 1.2,700),
    PAINT(50, 1.2,800);


    private final int weight;
    private final double qualityCoef;
    private int priceOnPoint;

    Goods(int weight, double qualityCoef, int priceOnPoint) {
        this.weight = weight;
        this.qualityCoef = qualityCoef;
        this.priceOnPoint = priceOnPoint;
    }



    public int getWeight() {
        return weight;
    }

    public double getQualityCoef() {
        return qualityCoef;
    }

    public int getPriceOnPoint() {
        return priceOnPoint;
    }
}
