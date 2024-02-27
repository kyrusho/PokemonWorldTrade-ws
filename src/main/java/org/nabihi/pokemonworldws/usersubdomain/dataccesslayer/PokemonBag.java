package org.nabihi.pokemonworldws.usersubdomain.dataccesslayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.nabihi.pokemonworldws.common.PokemonBagIdentifier;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;

import java.util.*;

//@Table(name = "user_pokemonbag")
@Entity
@Data
@Table(name = "user_pokemon_bag")
@Getter
public class PokemonBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //database id

    @Embedded
    private PokemonBagIdentifier pokemonBagIdentifier;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<Pokemon> ownedPokemons = new ArrayList<>();

    public PokemonBag(List<Pokemon> ownedPokemons){
        this.pokemonBagIdentifier = new PokemonBagIdentifier();
        this.ownedPokemons = ownedPokemons;
    }

    public PokemonBag(){}

}
