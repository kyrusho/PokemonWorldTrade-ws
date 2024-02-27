package org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokemonResponseModel {

    private String pokemonId;

    private String name;

    private String typee;

    //private RegionResponseDTO region;

    private String ability;

    private String weight;

    private String height;

    private String classification;
}
