package fr.multiplatform.hot.entities.party;

import fr.multiplatform.hot.entities.character.CharacterPartial;
import fr.multiplatform.hot.entities.user.UserPartial;

import java.util.List;

public class Party {
    private String id;
    private UserPartial owner;
    private List<CharacterPartial> characters;

    public String getId() {
        return id;
    }

    public UserPartial getOwner() {
        return owner;
    }

    public void setOwner(UserPartial owner) {
        this.owner = owner;
    }

    public List<CharacterPartial> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterPartial> characters) {
        this.characters = characters;
    }

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
}
