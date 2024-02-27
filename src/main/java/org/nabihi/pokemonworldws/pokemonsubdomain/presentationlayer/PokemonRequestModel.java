package org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SecondaryRow;

@Data
@NoArgsConstructor
public class PokemonRequestModel {

    private String name;

    private String typee;

    private String regionId;

    private String ability;

    private String weight;

    private String height;

    private String classification;

}
