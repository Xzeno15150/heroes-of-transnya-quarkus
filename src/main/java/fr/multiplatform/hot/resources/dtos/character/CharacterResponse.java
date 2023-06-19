package fr.multiplatform.hot.resources.dtos.character;

import fr.multiplatform.hot.entities.HealthPoint;
import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.entities.item.ItemPartial;
import fr.multiplatform.hot.entities.party.PartyPartial;
import fr.multiplatform.hot.entities.skill.SkillPartial;
import fr.multiplatform.hot.entities.user.User;
import org.bson.types.ObjectId;

import java.util.List;

public class CharacterResponse {
    private String id;
    private String name;
    private String element;
    private String imagePath;
    private HealthPoint healthPoint;
    private List<SkillPartial> skills;
    private List<ItemPartial> items;
    private PartyPartial party;
    private User user;
    private int level = 1;

    public String getId() {
        return id;
    }

    public CharacterResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CharacterResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getElement() {
        return element;
    }

    public CharacterResponse setElement(String element) {
        this.element = element;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public CharacterResponse setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }

    public CharacterResponse setHealthPoint(HealthPoint healthPoint) {
        this.healthPoint = healthPoint;
        return this;
    }

    public List<SkillPartial> getSkills() {
        return skills;
    }

    public CharacterResponse setSkills(List<SkillPartial> skills) {
        this.skills = skills;
        return this;
    }

    public List<ItemPartial> getItems() {
        return items;
    }

    public CharacterResponse setItems(List<ItemPartial> items) {
        this.items = items;
        return this;
    }

    public PartyPartial getParty() {
        return party;
    }

    public CharacterResponse setParty(PartyPartial party) {
        this.party = party;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public CharacterResponse setLevel(int level) {
        this.level = level;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CharacterResponse setUser(User user) {
        this.user = user;
        return this;
    }
}
