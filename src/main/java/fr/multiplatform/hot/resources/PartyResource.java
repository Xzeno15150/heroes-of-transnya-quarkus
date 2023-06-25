package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.exceptions.PartyNotFoundException;
import fr.multiplatform.hot.resources.common.UserJWTResource;
import fr.multiplatform.hot.resources.dtos.delete.DeleteResponse;
import fr.multiplatform.hot.resources.dtos.party.PartyRequest;
import fr.multiplatform.hot.resources.dtos.party.PartyResponse;
import fr.multiplatform.hot.resources.mappers.PartyMapper;
import fr.multiplatform.hot.resources.mappers.common.ObjectIdMapper;
import fr.multiplatform.hot.services.PartyService;
import jakarta.annotation.Nonnull;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/parties")
public class PartyResource extends UserJWTResource {

    @Inject
    PartyService partyService;

    @Inject
    PartyMapper partyMapper;

    @Inject
    ObjectIdMapper objectIdMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    public List<PartyResponse> getParties() {
        return partyService.findAllOfUser(user()).stream()
                .map(party -> partyMapper.toResource(party))
                .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    public PartyResponse createParty(@Nonnull PartyRequest dto) {
        Party party = partyService.createParty(
            partyMapper.toEntity(dto, user())
        );
        return partyMapper.toResource(party);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    public PartyResponse updateParty(@Nonnull @RestPath String id, @Nonnull PartyRequest dto) {
        if (!id.equals(dto.getId())) {
            throw new PartyNotFoundException(id);
        }
        Party party = partyService.updateParty(
            partyMapper.toEntity(dto, user())
        );
        return partyMapper.toResource(party);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    public DeleteResponse deleteParty(@Nonnull @RestPath String id){
        return new DeleteResponse(partyService.deleteParty(objectIdMapper.toObjectId(id)));
    }
}
