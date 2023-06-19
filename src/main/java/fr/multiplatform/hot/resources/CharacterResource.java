package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.resources.common.UserJWTResource;
import fr.multiplatform.hot.resources.dtos.character.CharacterRequest;
import fr.multiplatform.hot.resources.dtos.character.CharacterResponse;
import fr.multiplatform.hot.resources.mappers.CharacterMapper;
import fr.multiplatform.hot.services.CharacterService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.ArrayList;

@Path("/characters")
public class CharacterResource extends UserJWTResource {
    @Inject
    JsonWebToken jwt;

    @Inject
    CharacterMapper characterMapper;
    @Inject
    CharacterService characterService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    public CharacterResponse addCharacter(CharacterRequest characterRequest){
        characterRequest
                .setId(null);
        Character character = characterService.createCharacter(
                characterMapper.toEntity(characterRequest, user())
        );
        return characterMapper.toResource(character);
    }
}
