package fr.multiplatform.hot.entities;

public class Statistic {
    private int strength;
    private int intelligence;

    public Statistic(int strength, int intelligence) {
        this.strength = strength;
        this.intelligence = intelligence;
    }

    public Statistic() {
    }

    public int getStrength() {
        return strength;
    }

    public Statistic setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public Statistic setIntelligence(int intelligence) {
        this.intelligence = intelligence;
        return this;
    }
}
