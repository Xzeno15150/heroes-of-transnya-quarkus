package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.resources.dtos.common.UserJWTResource;
import fr.multiplatform.hot.resources.dtos.party.PartyRequest;
import fr.multiplatform.hot.resources.dtos.party.PartyResponse;
import fr.multiplatform.hot.resources.mappers.PartyMapper;
import fr.multiplatform.hot.services.PartyService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/parties")
public class PartyResource extends UserJWTResource {

    @Inject
    PartyService partyService;

    @Inject
    PartyMapper partyMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ Role.Names.ROLE_USER, Role.Names.ROLE_ADMIN })
    public List<PartyResponse> getParties() {
        return partyService.findAllOfUser(user()).stream()
                .map(party -> partyMapper.toResource(party))
                .collect(Collectors.toList());
    }
}
