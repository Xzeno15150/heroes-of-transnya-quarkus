package fr.multiplatform.hot.entities.party;

public class PartyPartial {
    private String id;
    private String name;

    public PartyPartial() {
    }

    public PartyPartial(String name) {
        this.name = name;
    }

    public PartyPartial(String id, String name) {
        this.id = id;
        this.name = name;
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
