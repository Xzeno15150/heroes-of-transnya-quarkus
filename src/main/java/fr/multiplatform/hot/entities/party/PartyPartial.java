package fr.multiplatform.hot.entities.party;

import org.bson.types.ObjectId;

public class PartyPartial {
    private ObjectId id;
    private String name;

    public PartyPartial() {
    }

    public PartyPartial(String name) {
        this.name = name;
    }

    public PartyPartial(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PartyPartial setName(String name) {
        this.name = name;
        return this;
    }
}
