package emums;

public enum Goods {
    MEAT(10, 1.2,0),
    DRIED_FRUITS(20, 1.2,0),
    GRAIN(30, 1.2,0),
    FLOUR(30, 1.2,0),
    CLOTH(20, 1.2,0),
    PAINT(50, 1.2,0);

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
}
