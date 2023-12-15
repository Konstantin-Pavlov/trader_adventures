package emums;

public enum Quality
{
    NORMAL (1.2),
    SLIGHTLY_DAMAGED( 0.95),
    HALF_DAMAGED (0.55),
    ALMOST_DAMAGED(0.25),
    COMPLETELY_RUINED( 0.1);


    private double qualityCoefficient;

    Quality(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }
}