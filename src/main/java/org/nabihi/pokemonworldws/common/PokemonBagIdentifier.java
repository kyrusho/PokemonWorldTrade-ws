package org.nabihi.pokemonworldws.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Getter
@Embeddable
public class PokemonBagIdentifier {

    private String pokemonBagId;

    public PokemonBagIdentifier(){this.pokemonBagId = UUID.randomUUID().toString();
    }

    public PokemonBagIdentifier(String pokemonBagId){this.pokemonBagId = pokemonBagId;}

}
