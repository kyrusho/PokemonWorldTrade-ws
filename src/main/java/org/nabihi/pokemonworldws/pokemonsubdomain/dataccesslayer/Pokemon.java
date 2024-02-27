package org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nabihi.pokemonworldws.common.PokemonIdentifier;
import org.nabihi.pokemonworldws.usersubdomain.dataccesslayer.PokemonBag;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons")
@Data
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //database id

    @Embedded
    private PokemonIdentifier pokemonIdentifier;

    private String name;

    @Column(name = "typee")
    private String typee;


   /* @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "regionid")
    private Region region; */

    @Column(name = "ability")
    private String ability;

    @Column(name = "weight")
    private String weight;

    @Column(name = "height")
    private String height;

    @Column(name = "classification")
    private String classification;

    @ManyToMany(mappedBy = "ownedPokemons")
    private Set<PokemonBag> pokemonBags = new HashSet<>();


    public Pokemon(String name, String typee, String ability, String weight, String height, String classification) {
        this.pokemonIdentifier = new PokemonIdentifier();
        this.name = name;
        this.typee = typee;
        //this.region = region;
        this.ability = ability;
        this.weight = weight;
        this.height = height;
        this.classification = classification;
    }

    public Pokemon(){}



}
