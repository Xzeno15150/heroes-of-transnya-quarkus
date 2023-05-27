package fr.multiplatform.hot.entities.party;

import fr.multiplatform.hot.entities.character.CharacterPartial;
import fr.multiplatform.hot.entities.user.UserPartial;

import java.util.List;

public class Party {
    private String id;
    private UserPartial owner;
    private List<CharacterPartial> characters;
    public Party() {
    }

    public Party(UserPartial owner, List<CharacterPartial> characters) {
        this.owner = owner;
        this.characters = characters;
    }

    public Party(String id, UserPartial owner, List<CharacterPartial> characters) {
        this.id = id;
        this.owner = owner;
        this.characters = characters;
    }

    public String getId() {
        return id;
    }

    public UserPartial getOwner() {
        return owner;
    }

    public Party setOwner(UserPartial owner) {
        this.owner = owner;
        return this;
    }

    public List<CharacterPartial> getCharacters() {
        return characters;
    }

    public Party setCharacters(List<CharacterPartial> characters) {
        this.characters = characters;
        return this;
    }
}
