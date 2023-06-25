package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.entities.HealthPoint;
import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.entities.item.ItemPartial;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.services.CharacterService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CharacterServiceTest {
    @Inject
    private CharacterService characterService;

    private Character characterExemple;

    private User userExemple;

    @BeforeEach
    void setUp() {
        userExemple = new User("test@tests.fr", "test", "testtest", Arrays.asList(Role.ROLE_USER));
        characterExemple = new Character();
        characterExemple.setName("Ezekiel Lawha")
            .setElement("Wook")
            .setImagePath("non")
            .setHealthPoint(new HealthPoint(12))
            .setLevel(1)
            .setSkills(new ArrayList<>())
            .setItems(Arrays.asList((new ItemPartial()).setName("tableau").setNbOfItems(2)))
            .setUser(userExemple);
        characterService.createCharacter(characterExemple);
    }

    @AfterEach
    void tearDown() {
        characterService.deleteCharacter(characterExemple.getId());
    }

    @Test
    void getCharacter() {
        List<Character> foundCharacters = characterService.findAllOfUser(userExemple);
        Assertions.assertEquals(1, foundCharacters.size());
        Character foundCharacter = foundCharacters.get(0);
        Assertions.assertNotNull(foundCharacter.getId());
        Assertions.assertEquals(characterExemple.getName(), foundCharacter.getName());
    }

    @Test
    void deleteCharacter(){
        Character foundCharacter = characterService.findAllOfUser(userExemple).get(0);
        characterService.deleteCharacter(foundCharacter.getId());
        Assertions.assertEquals(0, characterService.findAllOfUser(userExemple).size());
    }

    @Test
    void updateCharacter(){
        Character foundCharacter = characterService.findAllOfUser(userExemple).get(0);
        int newLevel = 1312;
        foundCharacter.setLevel(newLevel);
        characterService.updateCharacter(foundCharacter);
        foundCharacter = characterService.findAllOfUser(userExemple).get(0);
        Assertions.assertEquals(newLevel, foundCharacter.getLevel());
    }

    @Test
    void addCharacter(){
        Character newCharacter = new Character()
                .setName("Rebekka")
                .setElement("COOL FUCKING GUN")
                .setLevel(45000)
                .setHealthPoint(new HealthPoint(Integer.MAX_VALUE))
                .setUser(userExemple);
        newCharacter = characterService.createCharacter(newCharacter);
        List<Character> foundCharacters = characterService.findAllOfUser(userExemple);
        Assertions.assertTrue(foundCharacters.contains(newCharacter));
        characterService.deleteCharacter(newCharacter.getId());
    }
}
