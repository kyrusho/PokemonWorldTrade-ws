package org.nabihi.pokemonworldws.usersubdomain.mapperlayer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nabihi.pokemonworldws.usersubdomain.dataccesslayer.User;
import org.nabihi.pokemonworldws.usersubdomain.presentationlayer.UserResponseModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    @Mapping(expression = "java(user.getUserIdentifier().getUserId())", target = "userId")
    //@Mapping(expression = "java(pokemonBag.getPokemonIdentifier().getPokemonBagId())", target = "pokemonBagId")
    UserResponseModel entityToResponseModel(User user);

    List<UserResponseModel> entityListToResponseModel(List<User> userList);

}
