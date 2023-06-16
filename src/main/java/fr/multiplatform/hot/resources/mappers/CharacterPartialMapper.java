package fr.multiplatform.hot.resources.mappers;

import fr.multiplatform.hot.entities.character.CharacterPartial;
import fr.multiplatform.hot.resources.dtos.character.CharacterPartialRequest;
import fr.multiplatform.hot.resources.dtos.character.CharacterPartialResponse;
import fr.multiplatform.hot.resources.mappers.common.ObjectIdMapper;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;

@Mapper(
	componentModel = "cdi",
	uses = {
		ObjectIdMapper.class
	}
)
public interface CharacterPartialMapper {

	CharacterPartial toEntity(@Nonnull CharacterPartialRequest characterPartial);

	CharacterPartialResponse toResource(@Nonnull CharacterPartial characterPartial);
}
