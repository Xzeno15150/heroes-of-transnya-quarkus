package fr.multiplatform.hot.resources.dtos.character;

import fr.multiplatform.hot.entities.HealthPoint;
import fr.multiplatform.hot.entities.item.ItemPartial;
import fr.multiplatform.hot.entities.party.PartyPartial;
import fr.multiplatform.hot.entities.skill.SkillPartial;
import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

public class CharacterRequest {
    private String id;
    @Nonnull
    private String name="";
    @Nonnull
    private String element="";
    @Nonnull
    private String imagePath ="";

    private PartyPartial party;
    @Nonnull
    private HealthPoint healthPoint = new HealthPoint();
    @Nonnull
    private List<SkillPartial> skills = new ArrayList<>();
    @Nonnull
    private List<ItemPartial> items = new ArrayList<>();
    @Nonnull
    private int level=1;

    @Nonnull
    public String getId() {
        return id;
    }

    public CharacterRequest setId(String id) {
        this.id = id;
        return this;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public CharacterRequest setName(String name) {
        this.name = name;
        return this;
    }

    @Nonnull
    public String getElement() {
        return element;
    }

    public CharacterRequest setElement(String element) {
        this.element = element;
        return this;
    }

    @Nonnull
    public String getImagePath() {
        return imagePath;
    }

    public CharacterRequest setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public PartyPartial getParty() {
        return party;
    }

    public CharacterRequest setParty(PartyPartial party) {
        this.party = party;
        return this;
    }

    @Nonnull
    public HealthPoint getHealthPoint() {
        return healthPoint;
    }

    public CharacterRequest setHealthPoint(HealthPoint healthPoint) {
        this.healthPoint = healthPoint;
        return this;
    }

    @Nonnull
    public List<SkillPartial> getSkills() {
        return skills;
    }

    public CharacterRequest setSkills(List<SkillPartial> skills) {
        this.skills = skills;
        return this;
    }

    @Nonnull
    public List<ItemPartial> getItems() {
        return items;
    }

    public CharacterRequest setItems(List<ItemPartial> items) {
        this.items = items;
        return this;
    }

    @Nonnull
    public int getLevel() {
        return level;
    }

    public CharacterRequest setLevel(int level) {
        this.level = level;
        return this;
    }
}
