package fr.multiplatform.hot.dal;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public abstract class MongoDAL {

	@ConfigProperty(name = "mongo.db.name")
	private String databaseName;

	@Inject
	private MongoClient mongoClient;

	public MongoCollection<Document> getCollection(Class<?> clazz) {
		return mongoClient.getDatabase(databaseName).getCollection(clazz.getName());
	}
}
