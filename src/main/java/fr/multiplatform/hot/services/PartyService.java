package fr.multiplatform.hot.services;

import fr.multiplatform.hot.dal.MongoDAL;
import fr.multiplatform.hot.entities.party.Party;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class PartyService extends MongoDAL<Party> {

	public PartyService() {
		super(Party.class);
	}

	public List<Party> findAllOfUser(String userEmail) {
		return getCollection().find(eq("owner.email", userEmail)).into(new ArrayList<>());
	}

	public ObjectId add(Party party) {
		return getCollection()
				.insertOne(party)
				.getInsertedId()
				.asObjectId()
				.getValue();
	}

	public Party update(Party party) {
		return getCollection()
				.replaceOne();
	}
}
