package fr.multiplatform.hot.resources.mappers.common;

import jakarta.annotation.Nonnull;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ObjectIdMapper {
    default ObjectId toObjectId(String stringId) {
        if (stringId == null) {
            return null;
        }
        return new ObjectId(stringId);
    }
    default String toString(@Nonnull ObjectId objectId) {
        return objectId.toHexString();
    }
}

