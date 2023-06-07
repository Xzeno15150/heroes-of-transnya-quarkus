package fr.multiplatform.hot.entities.item;

public class ItemPartial {
    private String id;
    private String name;
    private int nbOfItems = 1;


    public ItemPartial(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemPartial(String name) {
        this.name = name;
    }

    public ItemPartial() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemPartial setName(String name) {
        this.name = name;
        return this;
    }

    public int getNbOfItems() {
        return nbOfItems;
    }

    public ItemPartial setNbOfItems(int nbOfItems) {
        this.nbOfItems = nbOfItems;
        return this;
    }

}
