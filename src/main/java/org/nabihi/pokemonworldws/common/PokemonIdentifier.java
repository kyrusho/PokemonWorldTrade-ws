package org.nabihi.pokemonworldws.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@Getter
@Setter
public class PokemonIdentifier {

    private String pokemonId;

    public PokemonIdentifier(){
        this.pokemonId = UUID.randomUUID().toString();
    }

    public PokemonIdentifier(String pokemonId){
        this.pokemonId = pokemonId;
    }
}
