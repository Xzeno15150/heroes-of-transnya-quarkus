package fr.multiplatform.hot.services;

import com.mongodb.client.model.Updates;
import fr.multiplatform.hot.dal.MongoDAL;
import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.exceptions.dal.CannotInsertException;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.BsonValue;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CharacterService extends MongoDAL<Character> {
    public CharacterService(){super(Character.class);}

    public Character createCharacter(Character character){
        BsonValue insertedId = getCollection().insertOne(character).getInsertedId();
        if(insertedId == null) {
            throw new CannotInsertException(Character.class);
        }

        return character.setId(insertedId.asObjectId().getValue());
    }

    public List<Character> findAllOfUser(User user){
        return getCollection().find(eq("user.email", user.getEmail())).into(new ArrayList<>());
    }

    public Character updateCharacter(Character character) {
        Bson updates = Updates.combine(
                Updates.set("element", character.getElement()),
                Updates.set("name", character.getName()),
                Updates.set("healthPoint", character.getHealthPoint()),
                Updates.set("imagePath", character.getImagePath()),
                Updates.set("items", character.getItems()),
                Updates.set("level", character.getLevel()),
                Updates.set("skills", character.getSkills())
        );

        getCollection()
                .updateOne(
                        and(
                                eq("_id", character.getId()),
                                eq("user.email", character.getUser().getEmail())
                        ), updates);
        return character;
    }
}
