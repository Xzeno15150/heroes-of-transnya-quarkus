package fr.multiplatform.hot.resources.dtos.party;

import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.resources.dtos.character.CharacterPartialResponse;

import java.util.List;
import java.util.stream.Collectors;

public class PartyResponse {

	private String id;
	private String name;

	private User owner;

	private List<CharacterPartialResponse> characters;

	public String getId() {
		return id;
	}

	public PartyResponse setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public PartyResponse setName(String name) {
		this.name = name;
		return this;
	}

	public User getOwner() {
		return owner;
	}

	public PartyResponse setOwner(User owner) {
		this.owner = owner;
		return this;
	}

	public List<CharacterPartialResponse> getCharacters() {
		return characters;
	}

	public PartyResponse setCharacters(List<CharacterPartialResponse> characters) {
		this.characters = characters;
		return this;
	}
}
