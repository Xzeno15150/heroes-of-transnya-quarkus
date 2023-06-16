package fr.multiplatform.hot.services;

import fr.multiplatform.hot.dal.MongoDAL;
import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.exceptions.dal.CannotInsertException;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.BsonValue;
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
}
