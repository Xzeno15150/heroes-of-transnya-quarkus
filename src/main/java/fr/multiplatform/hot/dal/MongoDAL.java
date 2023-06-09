package fr.multiplatform.hot.dal;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public abstract class MongoDAL<T> {

	@ConfigProperty(name = "mongo.db.name")
	private String databaseName;

	private final Class<T> clazz;

	public MongoDAL(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Inject
	protected MongoClient mongoClient;

	public MongoCollection<T> getCollection() {
		return mongoClient.getDatabase(databaseName).getCollection(clazz.getSimpleName(), clazz);
	}
}
