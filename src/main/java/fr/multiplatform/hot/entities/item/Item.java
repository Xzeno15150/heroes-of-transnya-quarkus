package fr.multiplatform.hot.entities.item;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Item {
    @BsonId
    private ObjectId id;
    private String name;
    private String description;
    private String imagePath;

    public Item() {
    }

    public Item(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Item(ObjectId id, String name, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Item setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }
}
