package fr.multiplatform.hot.entities.character;

import fr.multiplatform.hot.entities.HealthPoint;
import fr.multiplatform.hot.entities.item.ItemPartial;
import fr.multiplatform.hot.entities.party.PartyPartial;
import fr.multiplatform.hot.entities.skill.SkillPartial;

import java.util.List;

public class Character {
    private String id;
    private String name;
    private String element;
    private String imagePath;
    private HealthPoint healthPoints;
    private List<SkillPartial> skills;
    private List<ItemPartial> items;
    private PartyPartial party;

    public Character() {
    }

    public Character(String name, String element, String imagePath, HealthPoint healthPoints, List<SkillPartial> skills, List<ItemPartial> items, PartyPartial party) {
        this.name = name;
        this.element = element;
        this.imagePath = imagePath;
        this.healthPoints = healthPoints;
        this.skills = skills;
        this.items = items;
        this.party = party;
    }
    public Character(String id, String name, String element, String imagePath, HealthPoint healthPoints, List<SkillPartial> skills, List<ItemPartial> items, PartyPartial party) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.imagePath = imagePath;
        this.healthPoints = healthPoints;
        this.skills = skills;
        this.items = items;
        this.party = party;
    }
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public HealthPoint getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(HealthPoint healthPoints) {
        this.healthPoints = healthPoints;
    }

    public List<SkillPartial> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillPartial> skills) {
        this.skills = skills;
    }

    public List<ItemPartial> getItems() {
        return items;
    }

    public void setItems(List<ItemPartial> items) {
        this.items = items;
    }

    public PartyPartial getParty() {
        return party;
    }

    public void setParty(PartyPartial party) {
        this.party = party;
    }
}
