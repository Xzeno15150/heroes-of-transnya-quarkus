package fr.multiplatform.hot.entities.skill;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class SkillPartial {
    @BsonId
    private ObjectId id;
    private String name;

    public SkillPartial(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkillPartial(String name) {
        this.name = name;
    }

    public SkillPartial() {
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SkillPartial setName(String name) {
        this.name = name;
        return this;
    }
}
