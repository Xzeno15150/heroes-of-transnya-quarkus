package fr.multiplatform.hot.resources.mappers;

import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.resources.dtos.party.PartyResponse;
import fr.multiplatform.hot.resources.dtos.party.PartyRequest;
import jakarta.annotation.Nonnull;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
	componentModel = "cdi",
	uses = {
		CharacterPartialMapper.class
	}
)
public interface PartyMapper {

	@Mapping(target = "owner", expression = "java(user)")
	@Mapping(target = "id", expression = "java(party.getId() == null ? null : new org.bson.types.ObjectId(party.getId()))")
	Party toEntity(@Nonnull PartyRequest party, @Context User user);

	@Mapping(target = "id", expression = "java(party.getId() != null ? null : party.getId().toHexString())")
	PartyResponse toResource(@Nonnull Party party);
}
