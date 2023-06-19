package fr.multiplatform.hot.resources.mappers;

import fr.multiplatform.hot.entities.character.Character;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.resources.dtos.character.CharacterRequest;
import fr.multiplatform.hot.resources.dtos.character.CharacterResponse;
import fr.multiplatform.hot.resources.mappers.common.ObjectIdMapper;
import jakarta.annotation.Nonnull;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "cdi",
        uses = {
                PartyPartialMapper.class,
                ObjectIdMapper.class
        }
)
public interface CharacterMapper {
    @Mapping(target = "user", expression = "java(user)")
    Character toEntity(@Nonnull CharacterRequest character, @Context User user);

    CharacterResponse toResource(@Nonnull Character character);
}
