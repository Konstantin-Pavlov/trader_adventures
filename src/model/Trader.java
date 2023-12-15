package model;

public class Trader {
    private int totalCash;
    private int speed;
    private int capacity;

    public Trader(int totalCash, int speed, int capacity) {
        this.totalCash = totalCash;
        this.speed = speed;
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
