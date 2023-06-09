package fr.multiplatform.hot.entities.party;

import fr.multiplatform.hot.entities.character.CharacterPartial;
import fr.multiplatform.hot.entities.user.User;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Party {
    @BsonId
    private ObjectId id;
    private String name;
    private User owner;
    private List<CharacterPartial> characters = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }

    public Party setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public Party setOwner(User owner) {
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

    public String getName() {
        return name;
    }

    public Party setName(String name) {
        this.name = name;
        return this;
    }
}
