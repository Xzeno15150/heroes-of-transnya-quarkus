package fr.multiplatform.hot.entities.character;

import fr.multiplatform.hot.entities.user.UserPartial;
import org.bson.types.ObjectId;

public class CharacterPartial {
    private ObjectId id;
    private String name;
    private String element;
    private UserPartial user;
    private int level = 1;

    public ObjectId getId() {
        return id;
    }

    public CharacterPartial() {
    }

    public CharacterPartial(String name, String element, UserPartial user) {
        this.name = name;
        this.element = element;
        this.user = user;
    }

    public CharacterPartial(ObjectId id, String name, String element, UserPartial user) {
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

    public UserPartial getUser() {
        return user;
    }

    public CharacterPartial setUser(UserPartial user) {
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
