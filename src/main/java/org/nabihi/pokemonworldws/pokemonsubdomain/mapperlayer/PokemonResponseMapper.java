package org.nabihi.pokemonworldws.pokemonsubdomain.mapperlayer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer.PokemonRequestModel;
import org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer.PokemonResponseModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PokemonResponseMapper {

    @Mapping(expression = "java(pokemon.getPokemonIdentifier().getPokemonId())", target = "pokemonId")
    PokemonResponseModel entityToResponseModel(Pokemon pokemon);

    List<PokemonResponseModel> entityListToResponseModel(List<Pokemon> pokemonList);
}
