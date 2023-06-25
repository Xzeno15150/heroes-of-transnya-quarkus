package fr.multiplatform.hot.entities.character;

import fr.multiplatform.hot.entities.HealthPoint;
import fr.multiplatform.hot.entities.item.ItemPartial;
import fr.multiplatform.hot.entities.party.PartyPartial;
import fr.multiplatform.hot.entities.skill.SkillPartial;
import fr.multiplatform.hot.entities.user.User;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;

public class Character {
    @BsonId
    private ObjectId id;
    private String name;
    private String element;
    private String imagePath;
    private HealthPoint healthPoint;
    private List<SkillPartial> skills;
    private List<ItemPartial> items;
    private PartyPartial party;
    private User user;
    private int level = 1;

    public Character() {
    }

    public Character(String name, String element, String imagePath, HealthPoint healthPoint, List<SkillPartial> skills, List<ItemPartial> items, PartyPartial party) {
        this.name = name;
        this.element = element;
        this.imagePath = imagePath;
        this.healthPoint = healthPoint;
        this.skills = skills;
        this.items = items;
        this.party = party;
    }
    public Character(ObjectId id, String name, String element, String imagePath, HealthPoint healthPoint, List<SkillPartial> skills, List<ItemPartial> items, PartyPartial party) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.imagePath = imagePath;
        this.healthPoint = healthPoint;
        this.skills = skills;
        this.items = items;
        this.party = party;
    }
    public ObjectId getId() {
        return id;
    }

    public Character setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Character setName(String name) {
        this.name = name;
        return this;
    }

    public String getElement() {
        return element;
    }

    public Character setElement(String element) {
        this.element = element;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Character setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }

    public Character setHealthPoint(HealthPoint healthPoint) {
        this.healthPoint = healthPoint;
        return this;
    }

    public List<SkillPartial> getSkills() {
        return skills;
    }

    public Character setSkills(List<SkillPartial> skills) {
        this.skills = skills;
        return this;
    }

    public List<ItemPartial> getItems() {
        return items;
    }

    public Character setItems(List<ItemPartial> items) {
        this.items = items;
        return this;
    }

    public PartyPartial getParty() {
        return party;
    }

    public Character setParty(PartyPartial party) {
        this.party = party;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public Character setLevel(int level) {
        this.level = level;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Character setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
