package org.nabihi.pokemonworldws.pokemonsubdomain.mapperlayer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nabihi.pokemonworldws.common.PokemonIdentifier;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer.PokemonRequestModel;

@Mapper(componentModel = "spring")
public interface PokemonRequestMapper {

    @Mapping(target = "id", ignore = true)
    Pokemon requestModelToEntity(PokemonRequestModel pokemonRequestModel, PokemonIdentifier pokemonIdentifier);
}
