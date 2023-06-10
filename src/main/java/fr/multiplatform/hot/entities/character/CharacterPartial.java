package fr.multiplatform.hot.entities.character;

import fr.multiplatform.hot.entities.user.User;
import org.bson.types.ObjectId;

public class CharacterPartial {
    private ObjectId id;
    private String name;
    private String element;
    private User user;
    private int level = 1;

    public ObjectId getId() {
        return id;
    }

    public CharacterPartial setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public CharacterPartial() {
    }

    public CharacterPartial(String name, String element, User user) {
        this.name = name;
        this.element = element;
        this.user = user;
    }

    public CharacterPartial(ObjectId id, String name, String element, User user) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public CharacterPartial setName(String name) {
        this.name = name;
        return this;
    }

    public String getElement() {
        return element;
    }

    public CharacterPartial setElement(String element) {
        this.element = element;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CharacterPartial setUser(User user) {
        this.user = user;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public CharacterPartial setLevel(int level) {
        this.level = level;
        return this;
    }
}
