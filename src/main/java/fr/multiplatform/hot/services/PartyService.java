package fr.multiplatform.hot.services;

import fr.multiplatform.hot.dal.MongoDAL;
import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
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

	public List<Party> findAllOfUser(User user) {
		return getCollection().find(eq("owner.email", user.getEmail())).into(new ArrayList<>());
	}
}
