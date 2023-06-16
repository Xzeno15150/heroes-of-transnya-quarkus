package fr.multiplatform.hot.services;

import com.mongodb.client.model.Updates;
import fr.multiplatform.hot.dal.MongoDAL;
import fr.multiplatform.hot.entities.character.CharacterPartial;
import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.exceptions.dal.CannotInsertException;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.BsonValue;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class PartyService extends MongoDAL<Party> {

	public PartyService() {
		super(Party.class);
	}

	public List<Party> findAllOfUser(User user) {
		return getCollection().find(eq("owner.email", user.getEmail())).into(new ArrayList<>());
	}

	public Party createParty(Party party) {
		BsonValue insertedId = getCollection().insertOne(party).getInsertedId();
		if(insertedId == null) {
			throw new CannotInsertException(Party.class);
		}

		return party.setId(insertedId.asObjectId().getValue());
	}

	public Party updateParty(Party party) {
		Bson updates = Updates.combine(
				Updates.set("characters", party.getCharacters()),
				Updates.set("name", party.getName())
		);

		getCollection()
			.updateOne(
				and(
					eq("_id", party.getId()),
					eq("owner.email", party.getOwner().getEmail())
			), updates);
		return party;
	}
}
