package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.exceptions.CharacterNotFoundException;
import fr.multiplatform.hot.exceptions.PartyNotFoundException;
import fr.multiplatform.hot.resources.common.UserJWTResource;
import fr.multiplatform.hot.resources.dtos.character.CharacterRequest;
import fr.multiplatform.hot.resources.dtos.character.CharacterResponse;
import fr.multiplatform.hot.resources.mappers.CharacterMapper;
import fr.multiplatform.hot.services.CharacterService;
import jakarta.annotation.Nonnull;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.reactive.RestPath;
import org.mapstruct.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public CharacterResponse addCharacter(CharacterRequest characterRequest) {
        characterRequest
                .setId(null);
        Character character = characterService.createCharacter(
                characterMapper.toEntity(characterRequest, user())
        );
        return characterMapper.toResource(character);
    }
    @GET
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    @Produces(MediaType.APPLICATION_JSON)
    public List<CharacterResponse> getCharacters(@Context SecurityContext context){
        if(!context.getUserPrincipal().getName().equals(jwt.getName())){
            throw new NotAcceptableException("Nom du JWT différent du nom pricipal");
        }
        return characterService.findAllOfUser(user()).stream().map(character -> characterMapper.toResource(character)).collect(Collectors.toList());
    }
    
    @PUT
    @Path("/{id}")
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CharacterResponse updateCharacter(@Nonnull @RestPath String id, @Nonnull CharacterRequest dto){
        if (!id.equals(dto.getId())) {
            throw new CharacterNotFoundException(id);
        }
        Character character = characterService.updateCharacter(
                characterMapper.toEntity(dto, user())
        );
        return characterMapper.toResource(character);
    }



}
