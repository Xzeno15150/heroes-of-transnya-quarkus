package fr.multiplatform.hot.entities.item;

public class ItemPartial {
    private String id;
    private String name;

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

    public void setName(String name) {
        this.name = name;
    }
}
