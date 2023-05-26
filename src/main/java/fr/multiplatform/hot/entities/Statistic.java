package fr.multiplatform.hot.entities;

public class Statistic {
    private int strength;
    private int intelligence;

    public Statistic(int strength, int intelligence) {
        this.strength = strength;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
