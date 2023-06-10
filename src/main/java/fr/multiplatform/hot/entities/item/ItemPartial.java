package fr.multiplatform.hot.entities.item;

import org.bson.types.ObjectId;

public class ItemPartial {
    private ObjectId id;
    private String name;
    private int nbOfItems = 1;

    public ItemPartial(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemPartial(String name) {
        this.name = name;
    }

    public ItemPartial() {
    }

    public ObjectId getId() {
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
