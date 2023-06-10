package fr.multiplatform.hot.resources.mappers;

import fr.multiplatform.hot.entities.character.CharacterPartial;
import fr.multiplatform.hot.resources.dtos.character.CharacterPartialRequest;
import fr.multiplatform.hot.resources.dtos.character.CharacterPartialResponse;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CharacterPartialMapper {

	@Mapping(target = "id", expression = "java(characterPartial.getId() == null ? null : new org.bson.types.ObjectId(characterPartial.getId()))")
	CharacterPartial toEntity(@Nonnull CharacterPartialRequest characterPartial);

	@Mapping(target = "id", expression = "java(characterPartial.getId() == null ? null : characterPartial.getId().toHexString())")
	CharacterPartialResponse toResource(@Nonnull CharacterPartial characterPartial);
}
