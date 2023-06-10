package fr.multiplatform.hot.resources.dtos.character;

import fr.multiplatform.hot.entities.user.User;

public class CharacterPartialRequest {

	private String id;
	private String name;
	private String element;
	private User user;
	private int level;

	public String getId() {
		return id;
	}

	public CharacterPartialRequest setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public CharacterPartialRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getElement() {
		return element;
	}

	public CharacterPartialRequest setElement(String element) {
		this.element = element;
		return this;
	}

	public User getUser() {
		return user;
	}

	public CharacterPartialRequest setUser(User user) {
		this.user = user;
		return this;
	}

	public int getLevel() {
		return level;
	}

	public CharacterPartialRequest setLevel(int level) {
		this.level = level;
		return this;
	}
}
