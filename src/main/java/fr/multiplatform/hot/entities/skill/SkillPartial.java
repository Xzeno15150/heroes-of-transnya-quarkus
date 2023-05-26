package fr.multiplatform.hot.entities.skill;

public class SkillPartial {
    private String id;
    private String name;

    public SkillPartial(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkillPartial(String name) {
        this.name = name;
    }

    public SkillPartial() {
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
}
