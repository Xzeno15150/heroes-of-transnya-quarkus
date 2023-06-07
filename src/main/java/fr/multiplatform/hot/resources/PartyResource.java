package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.services.PartyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path("/parties")
public class PartyResource {

    @Inject
    PartyService partyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Party> getParties() {
        return partyService.findAllOfUser("");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Party createParty(Party party) {
        return party.setId(partyService.add(party.setId(null)));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Party modifParty(Party party) {
        return partyService.update(party);
    }
}
