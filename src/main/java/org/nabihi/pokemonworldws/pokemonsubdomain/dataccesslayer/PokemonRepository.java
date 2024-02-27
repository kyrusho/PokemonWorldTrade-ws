package org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer;

import org.nabihi.pokemonworldws.common.PokemonIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {


    Pokemon findPokemonByPokemonIdentifier_PokemonId(String pokemonId);
}
