package org.nabihi.pokemonworldws.usersubdomain.mapperlayer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nabihi.pokemonworldws.common.UserIdentifier;
import org.nabihi.pokemonworldws.usersubdomain.dataccesslayer.User;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    @Mapping(target = "id", ignore = true)
    User requestModelToEntity(UserRequestMapper userRequestModel, UserIdentifier userIdentifier);
}
