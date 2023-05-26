package fr.multiplatform.hot.entities.character;

import fr.multiplatform.hot.entities.user.UserPartial;

public class CharacterPartial {
    private String id;
    private String name;
    private String element;
    private UserPartial user;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public UserPartial getUser() {
        return user;
    }

    public void setUser(UserPartial user) {
        this.user = user;
    }

    public CharacterPartial() {
    }

    public CharacterPartial(String name, String element, UserPartial user) {
        this.name = name;
        this.element = element;
        this.user = user;
    }

    public CharacterPartial(String id, String name, String element, UserPartial user) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.user = user;
    }
}
