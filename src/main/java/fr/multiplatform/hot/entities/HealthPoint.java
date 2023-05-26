package fr.multiplatform.hot.entities;

public class HealthPoint {
    private int max;
    private int current;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public HealthPoint(int max) {
        this.max = max;
        this.current=max;
    }

    public HealthPoint(int max, int current) {
        this.max = max;
        this.current = current;
    }
}
