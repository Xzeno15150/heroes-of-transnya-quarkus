package fr.multiplatform.hot.resources.dtos.party;

import jakarta.annotation.Nonnull;

public class PartyPartialRequest {
    private String id;
    @Nonnull
    private String name = "";
    @Nonnull
    public String getName() {
        return name;
    }

    public PartyPartialRequest setName(String name) {
        this.name = name;
        return this;
    }

    @Nonnull
    public String getId() {
        return id;
    }

    public PartyPartialRequest setId(String id) {
        this.id = id;
        return this;
    }
}
