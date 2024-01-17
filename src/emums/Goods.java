package emums;

public enum Goods {
    MEAT("meat", 10, Quality.NORMAL.getQualityCoefficient(), 1000),
    DRIED_FRUITS("dried fruits", 20, Quality.NORMAL.getQualityCoefficient(), 250),
    GRAIN("grain", 30, Quality.NORMAL.getQualityCoefficient(), 400),
    FLOUR("flour", 30, Quality.NORMAL.getQualityCoefficient(), 500),
    CLOTH("cloth", 20, Quality.NORMAL.getQualityCoefficient(), 700),
    PAINT("paint", 50, Quality.NORMAL.getQualityCoefficient(), 800);


    private final int weight;
    private final String name;
    private double qualityCoefficient;
    private final int priceOnPoint;
    private Quality quality;

    Goods(String name, int weight, double qualityCoefficient, int priceOnPoint) {
        this.name = name;
        this.weight = weight;
        this.qualityCoefficient = qualityCoefficient;
        this.priceOnPoint = priceOnPoint;
        this.quality = Quality.NORMAL;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    private double getQualityCoefficient() {
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

    @Override
    public String toString() {
        return String.format(
                "%-20s %s%n" +
                        "%-20s %d%n" +
                        "%-20s %.2f%n" +
                        "%-20s %d%n" +
                        "%-20s %.2f%n" +
                        "%-20s %s%n",
                "name", name,
                "weight", weight,
                "qualityCoefficient", qualityCoefficient,
                "priceOnPoint", priceOnPoint,
                "final Price", getFinalPrice(),
                "quality", quality
        );

    }
}
