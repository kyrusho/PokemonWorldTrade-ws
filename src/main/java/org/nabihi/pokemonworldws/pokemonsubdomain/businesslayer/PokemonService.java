package org.nabihi.pokemonworldws.pokemonsubdomain.businesslayer;

import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer.PokemonRequestModel;
import org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer.PokemonResponseModel;

import java.util.List;

public interface PokemonService {

    List<PokemonResponseModel> getAllPokemons();

    PokemonResponseModel getPokemonByPokemonId(String pokemonId);

    PokemonResponseModel addPokemon(PokemonRequestModel pokemonRequestModel);

    PokemonResponseModel updatePokemon(PokemonRequestModel pokemonRequestModel, String pokemonId);

    void deletePokemon(String pokemonId);
}
