package fr.multiplatform.hot.resources.mappers;

import fr.multiplatform.hot.entities.party.Party;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.resources.dtos.party.PartyResponse;
import fr.multiplatform.hot.resources.dtos.party.PartyRequest;
import fr.multiplatform.hot.resources.mappers.common.ObjectIdMapper;
import jakarta.annotation.Nonnull;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
	componentModel = "cdi",
	uses = {
		CharacterPartialMapper.class,
		ObjectIdMapper.class
	}
)
public interface PartyMapper {

	@Mapping(target = "owner", expression = "java(user)")
	Party toEntity(@Nonnull PartyRequest party, @Context User user);

	PartyResponse toResource(@Nonnull Party party);
}
