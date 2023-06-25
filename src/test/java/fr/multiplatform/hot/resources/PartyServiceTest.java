package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.entities.character.CharacterPartial;
import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.services.PartyService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@QuarkusTest
class PartyServiceTest {

	@Inject
	private PartyService partyService;

	private Party partyExemple;
	private User userExemple;

	@BeforeEach
	void setUp() {
		userExemple = new User("test@tests.fr", "test", "testtest", Arrays.asList(Role.ROLE_USER));
		partyExemple = new Party().setName("Mangez des pommes mais mangez des bourgeois surout!").setOwner(userExemple);
		partyService.createParty(partyExemple);
	}

	@AfterEach
	void tearDown() {
		partyService.deleteParty(partyExemple.getId());
	}

	@Test
	void getParties() {
		List<Party> parties = partyService.findAllOfUser(userExemple);
		Assertions.assertEquals(1, parties.size());
		Assertions.assertEquals(partyExemple.getName(), parties.get(0).getName());
	}

	@Test
	void addParty(){
		Party newParty = new Party().setName("test party").setOwner(userExemple);
		Party newPartySend = partyService.createParty(newParty);
		List<Party> partiesRecived = partyService.findAllOfUser(userExemple);
		Assertions.assertTrue(partiesRecived.contains(newPartySend));
		partyService.deleteParty(newPartySend.getId());
	}

	@Test
	void updateParty(){
		CharacterPartial newCharactrer = new CharacterPartial().setName("Rebekka");
		Party updatedParty = partyService.findAllOfUser(userExemple).get(0).setCharacters(List.of(newCharactrer));
		partyService.updateParty(updatedParty);
		Party foundParty = partyService.findAllOfUser(userExemple).get(0);
		Assertions.assertEquals(1, foundParty.getCharacters().size());
		Assertions.assertEquals(newCharactrer.getName(), foundParty.getCharacters().get(0).getName());
	}

	@Test
	void deleteParty(){
		Party foundParty = partyService.findAllOfUser(userExemple).get(0);
		partyService.deleteParty(foundParty.getId());
		Assertions.assertEquals(0, partyService.findAllOfUser(userExemple).size());
	}
}