package fr.multiplatform.hot.entities;

public class HealthPoint {
    private int max;
    private int current;

    public HealthPoint() {
    }

    public HealthPoint(int max, int current) {
        this.max = max;
        this.current = current;
    }
    public HealthPoint(int max) {
        this.max = max;
        this.current=max;
    }

    public int getMax() {
        return max;
    }

    public int getCurrent() {
        return current;
    }

    public HealthPoint setMax(int max) {
        this.max = max;
        return this;
    }

    public HealthPoint setCurrent(int current) {
        this.current = current;
        return this;
    }
}
