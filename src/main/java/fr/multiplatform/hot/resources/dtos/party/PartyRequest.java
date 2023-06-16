package fr.multiplatform.hot.resources.dtos.party;

import fr.multiplatform.hot.resources.dtos.character.CharacterPartialRequest;
import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

public class PartyRequest {
    private String id;
    @Nonnull
    private String name = "";
    @Nonnull
    private List<CharacterPartialRequest> characters = new ArrayList<>();
    @Nonnull
    public String getName() {
        return name;
    }

    public PartyRequest setName(String name) {
        this.name = name;
        return this;
    }

    @Nonnull
    public List<CharacterPartialRequest> getCharacters() {
        return characters;
    }

    public PartyRequest setCharacters(List<CharacterPartialRequest> characters) {
        this.characters = characters;
        return this;
    }

    @Nonnull
    public String getId() {
        return id;
    }

    public PartyRequest setId(String id) {
        this.id = id;
        return this;
    }
}
