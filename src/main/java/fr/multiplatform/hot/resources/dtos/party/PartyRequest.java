package fr.multiplatform.hot.resources.dtos.party;

import fr.multiplatform.hot.resources.dtos.character.CharacterPartialRequest;

import java.util.ArrayList;
import java.util.List;

public class PartyRequest {
    private String id;
    private String name;
    private List<CharacterPartialRequest> characters = new ArrayList<>();
    public String getName() {
        return name;
    }

    public PartyRequest setName(String name) {
        this.name = name;
        return this;
    }

    public List<CharacterPartialRequest> getCharacters() {
        return characters;
    }

    public PartyRequest setCharacters(List<CharacterPartialRequest> characters) {
        this.characters = characters;
        return this;
    }

    public String getId() {
        return id;
    }

    public PartyRequest setId(String id) {
        this.id = id;
        return this;
    }
}
