package org.nabihi.pokemonworldws.usersubdomain.presentationlayer;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.nabihi.pokemonworldws.usersubdomain.dataccesslayer.PokemonBag;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResponseModel {

    private String userId;

    private String username;

    private String pokemonBagId;

    private PokemonBag ownedPokemons;

}
