package fr.multiplatform.hot.entities.skill;

public class Skill {
    private String id;
    private String name;
    private String description;
    private String imagePath;

    public Skill(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Skill(String id, String name, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Skill() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Skill setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Skill setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Skill setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }
}

